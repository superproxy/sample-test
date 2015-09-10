package test.junit;


import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;


public class TestAllFetures {
    @Test
    public void test() {
        assertTrue(true);
    }

    public void testOpenPage() {
        assertTrue(true);
    }

//    @Test
//    public void ParaTest(String test1) {
//        System.out.println("This is " + test1);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        throw new IllegalArgumentException("NullPoint");
    }

    @Test()
    public void testThat() {
        int x = 3;
        assertThat(x, is(3));

        assertThat(x, is(not(4)));

        String responseString = "color";
        assertThat(responseString, either(containsString("color")).or(containsString("colour")));
        List<Integer> myList = Arrays.asList(1, 2, 3, 4);
//        Set<Integer> myList = {1, 2, 3, 4};
        assertThat(myList, hasItem(3));
    }


    @Ignore
    @Test
    public void testIgnore() {
        System.out.println("This test case will ignore");
    }

    @Test(timeout = 10)
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(1);
    }


    //    @Test(dataProvider = "provideNumbers")
    public void test(int number, int expected) {
        assertEquals(number + 10, expected);
    }

    //    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][]{
                {10, 20},
                {100, 110},
                {200, 210}
        };
    }


    //    @Test(threadPoolSize = 3, invocationCount = 6, timeOut = 500)
    public void f1() {
        log("start");
        try {
            int sleepTime = new Random().nextInt(1000);
            if (sleepTime > 500) log("   should fail");
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            log("  *** INTERRUPTED");
        }
        log("end");
    }

    private void log(String s) {
        System.out.println("[" + Thread.currentThread().getId() + "] " + s);
    }

}
