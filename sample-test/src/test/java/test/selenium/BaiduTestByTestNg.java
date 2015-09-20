package test.selenium;

import com.thoughtworks.selenium.SeleneseTestNgHelper;
import org.testng.annotations.Test;

@Test
public class BaiduTestByTestNg extends SeleneseTestNgHelper {
    @Test
    public void test() throws Exception {
        selenium.type("id=kw", "abcd");
        selenium.click("id=su");
    }
}