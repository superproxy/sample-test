package dao.user;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import dao.BaseDaoTest;
import model.user.User;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class UserMapperDbUnitTest extends BaseDaoTest {


    @Resource
    private UserMapper userMapper;


    /**
     * 额外初始化数据集
     *
     * @throws Exception
     */
    @Test
    @DatabaseSetup("/dao/user/Users.xml")
    public void testExits() throws Exception {
        User user = userMapper.queryByUserName("admin2");
        System.out.println(user);
        assertNotNull(user);
        user.setAge(99);
        assertEquals(userMapper.update(user), 1);
        user = userMapper.queryByUserName("admin2");
        assertTrue(99 == user.getAge());
    }

    /**
     * DatabaseSetup初始化数据集，操作delete admin2，期望的数据集ExpectedDatabase
     *
     * @throws Exception
     */
    @Test
    @DatabaseSetup("/dao/user/Users.xml")
    @ExpectedDatabase("/dao/user/left.xml")
    public void testRemove() throws Exception {
        this.userMapper.delete("admin2");
    }

    /**
     * datasetup 会初始化数据admin2，所以在插入数据会报主键冲突
     */
    @Test(expectedExceptions = Exception.class)
    @DatabaseSetup("/dao/user/Users.xml")
    public void test() {
        userMapper.create(new User("admin2", "admin2", 1));
    }


    @Test
    public void testNotExits() throws Exception {
        User user = userMapper.queryByUserName("admin2");
        System.out.println(user);
        assertNull(user);
    }
}