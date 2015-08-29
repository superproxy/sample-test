package framework;

import org.apache.commons.lang3.builder.ToStringBuilder;
import model.User;

import java.io.Serializable;

/**
 * Created by 14120295 on 2015/8/28.
 */
public class Input implements Serializable {
    private User user;

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    private User user1;
    private int expected;

    public int getExpected() {
        return expected;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
