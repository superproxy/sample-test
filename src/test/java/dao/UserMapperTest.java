package dao;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertNotNull;

@Test
public class UserMapperTest extends BaseTest {

    @Resource
    private UserMapper userMapper;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetUser() throws Exception {
        assertNotNull(userMapper.getUser("admin", "admin"));

    }
}