package test;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@Test
public class TestGmt {

    @Test
    public void f1() {

//       System.out.println(new Date(0));

        do1();
//       do2();

    }

    private void do2() {
        Calendar cd = Calendar.getInstance();
        cd.setTimeInMillis(0);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String timeStr = sdf.format(cd.getTime());
        System.out.println("lastModify=" + timeStr);
    }

    private void do1() {
        Calendar cd = Calendar.getInstance();
        cd.setTimeInMillis(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String timeStr = sdf.format(cd.getTime());
        System.out.println("lastModify=" + timeStr);
    }


}
