package service.user;

import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.BaseTest;

public class UserCacheTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testQueryUser() {
        User user = userService.queryUser("admin");
        Assert.assertNotNull(user);
        System.out.println("query admin first end");
        Assert.assertNotNull(userService.queryUser("admin"));
        System.out.println("query admin send end");
        Assert.assertEquals(cacheManager.getCache("test").get("user_admin").get(), user);
    }

    @Test
    public void testUpdateUser() {
        User user = userService.queryUser("admin");
        Assert.assertEquals(user.getAge(), 1);
        user.setAge(0);
        userService.updateUser(user);
        user = userService.queryUser("admin");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getAge(), 0);
    }


}