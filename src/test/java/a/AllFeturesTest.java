package a;

import org.testng.annotations.Test;

import java.util.Random;
@Test
public class AllFeturesTest extends  BaseTest {

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
