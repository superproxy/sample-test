package service.impl;

import dao.UserMapper;
import model.User;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

/**
 * <pre>
 * 如果有任何对代码的修改,请按下面的格式注明修改的内容.
 * 序号	时间			作者			修改内容
 * 1.	14-5-21  	yangxz	created this class.
 * </pre>
 */

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return true;
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

        return 4;
    }

    @Override
    public User login(String userName, String password) {
        return userMapper.getUser(userName, password);
    }
}
