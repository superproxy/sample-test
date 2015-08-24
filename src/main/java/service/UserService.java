package service;

import model.User;

/**
 * <pre>
 * 如果有任何对代码的修改,请按下面的格式注明修改的内容.
 * 序号	时间			作者			修改内容
 * 1.	14-5-21  	yangxz	created this class.
 * </pre>
 */
public interface UserService {
    User login(String userName, String password);

    boolean addUser(User user);

    /**
     * 计算用户等级
     *
     * @param user 用户
     * @return 返回用户等级，数字表示
     */
    int calRank(User user);
}
