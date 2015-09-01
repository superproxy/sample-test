package test;

import org.apache.commons.lang3.StringUtils;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.testng.ITestObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertTrue;

@Test
@PrepareForTest(StringUtils.class)
public class MockStaticTest {
    @ObjectFactory
    public ITestObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }
    @Test
    public void test4() {
        mockStatic(StringUtils.class);
        when(StringUtils.isEmpty("abc")).thenReturn(Boolean.FALSE);
        assertTrue(StringUtils.isEmpty("abc"));
    }
}