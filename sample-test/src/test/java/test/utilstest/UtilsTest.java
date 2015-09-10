package test.utilstest;

import org.testng.annotations.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class UtilsTest {

    @Test
    public void test() {
        User user1 = new User(1, "John", "Doe");
        User user2 = new User(1, "John", "Doe");
//        assertEquals(user1, user2);  // 失败，不会执行下面的

        assertReflectionEquals(user1, user2);
    }

}
