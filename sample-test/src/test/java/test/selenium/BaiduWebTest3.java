package test.selenium;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class BaiduWebTest3 {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.baidu.com/");
		selenium.start();
	}

	@Test
	public void testC() throws Exception {
		selenium.type("id=kw", "abcd");
		selenium.click("id=su");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}