package test.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class TestAllFetures {
    @Test
    public void test() {
        assertTrue(true);
    }

    @Test(groups = {"functiontest"})
    public void testOpenPage() {
        assertTrue(true);
    }

    @Test
    @Parameters("test1")
    public void ParaTest(String test1) {
        System.out.println("This is " + test1);
    }


    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "NullPoint")
    public void testException() {
        throw new IllegalArgumentException("NullPoint");
    }


    @Test(enabled = false)
    public void testIgnore() {
        System.out.println("This test case will ignore");
    }


    @Test(dataProvider = "provideNumbers")
    public void test(int number, int expected) {
        assertEquals(number + 10, expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][]{
                {10, 20},
                {100, 110},
                {200, 210}
        };
    }


    @Test(threadPoolSize = 3, invocationCount = 6, timeOut = 500)
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
