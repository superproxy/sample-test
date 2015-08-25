package service;

import model.User;

public interface UserService {
    User queryUser(String userName, String password) throws Exception;

    boolean addUser(User user);

    /**
     * 计算用户等级
     *
     * @param user 用户
     * @return 返回用户等级，数字表示
     */
    int calRank(User user);
}
