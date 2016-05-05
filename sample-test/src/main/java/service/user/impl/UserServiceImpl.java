package service.user.impl;

import cache.CommonCacheManager;
import dao.user.UserMapper;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import service.user.UserService;

import javax.annotation.Resource;

@CacheConfig(cacheNames = {"user"})
@Service
public class UserServiceImpl implements UserService, CommonCacheManager<User> {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public boolean addUser(User user) {
        return userMapper.create(user) > 0;
    }

    @Override
    public int calRank(User user) {
        if (user.getAge() < 10) {
            return 0;
        }

        if (user.getAge() < 20) {
            return 1;
        }

        if (user.getAge() < 30) {
            return 2;
        }

        return 3;
    }

    @Override
    public User queryUser(String userName, String password) {
        return userMapper.query(userName, password);
    }

    @Override
    @Cacheable(key = "'user_'+#userName")
    public User queryUser(String userName) {
        System.out.println("query user");
        return userMapper.queryByUserName(userName);
    }

    @Override
    @CacheEvict(value = "user", key = "'user_'+#user.name")
    public boolean updateUser(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public void removeCache(String key) {
        cacheManager.getCache("user").evict(key);
    }

    @Override
    public void addCache(String key, User object) {
        cacheManager.getCache("user").put(key, object);
    }

    @Override
    public User getCache(String key) {
        return (User) cacheManager.getCache("user").get(key);
    }
}
