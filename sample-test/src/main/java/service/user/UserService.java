package service.user;

import model.user.User;

public interface UserService {
    User queryUser(String userName, String password) throws Exception;

    User queryUser(String userName);

    boolean addUser(User user);
    boolean updateUser(User user);

    /**
     * 计算用户等级
     *
     * @param user 用户
     * @return 返回用户等级，数字表示
     */
    int calRank(User user);
}
