package test.mock;

import org.apache.commons.lang3.StringUtils;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//import static org.mockito.Mockito.when;

@PrepareForTest(StringUtils.class)
public class MockTest {

    @Test
    public void test() {
        List list = mock(List.class);
        when(list.get(0)).thenReturn(1);
        assertEquals(list.get(0), 1);
    }

    @Test
    public void testVoid() {
        MyInterface myInterface = mock(MyInterface.class);
        try {
             myInterface.put(new Object());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Mock
    private List list;

    @BeforeMethod
    private void beforeMethod() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test2() {
        when(list.get(0)).thenReturn(1);
        assertEquals(list.get(0), 1);
        assertEquals(list.get(0), 1);
    }

    @Test
    public void test3() {
        mock(StringUtils.class);
        when(StringUtils.isEmpty("abc")).thenReturn(true);
        assertTrue(StringUtils.isEmpty("abc"));
    }

    @Test
    public void test4() {
        mockStatic(StringUtils.class);
        when(StringUtils.isEmpty("abc")).thenReturn(Boolean.FALSE);
        assertTrue(StringUtils.isEmpty("abc"));

        PowerMockito.verifyStatic();
    }


    @Test
    public void testCallArgumentInstance() {
        File file = mock(File.class);
        ClassUnderTest underTest = new ClassUnderTest();
        PowerMockito.when(file.exists()).thenReturn(true);
        Assert.assertTrue(underTest.callArgumentInstance(file));
    }
}