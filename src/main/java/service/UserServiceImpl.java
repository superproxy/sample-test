package service;

import model.User;

public class UserServiceImpl implements UserService {
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
}
