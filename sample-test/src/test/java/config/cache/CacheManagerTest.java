package config.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
@ActiveProfiles("dev")
public class CacheManagerTest {

    @Configuration
//    @EnableCaching
    @Import({CacheConfigDev.class, CacheConfig.class})
    public static class AppConfig {
    }

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test() {
        for (String cacheName : cacheManager.getCacheNames()) {
            System.out.println("cache Name:" + cacheName);

        }

        Cache cache = cacheManager.getCache("movieFindCache");
        cache.put("a", "1");
        Assert.assertEquals(cache.get("a").get(), "1");
    }

}