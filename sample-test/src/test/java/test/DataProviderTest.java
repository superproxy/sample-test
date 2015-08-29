package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataProviderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataProviderTest.class);

    public int calRank(int age) {
        if (age < 10) {
            return 0;
        }

        if (age < 20) {
            return 1;
        }

        if (age < 30) {
            return 2;
        }

        return 3;
    }


    @Test
    public void testCalRank() throws Exception {
        assertEquals(calRank(9), 0);
        assertEquals(calRank(10), 1);
        assertEquals(calRank(20), 2);
        assertEquals(calRank(30), 3);
        //设计测试样例
        assertEquals(calRank(100), 3);
    }

    @Test(dataProvider = "testCalRank2Data")
    public void testCalRank2(int age, int expected) throws Exception {
        LOGGER.debug("age:{}, expected:{}", age, expected);
        assertEquals(calRank(age), expected);
    }

    @DataProvider(name = "testCalRank2Data")
    public Object[][] testCalRank2Data(Method method) {
        LOGGER.debug("{}", method.getName());
        List<Object[]> objectList = new ArrayList<Object[]>();
        int expected = 0;
        objectList.add(new Object[]{9, expected});
        expected = 1;
        objectList.add(new Object[]{10, expected});

        expected = 2;
        objectList.add(new Object[]{20, expected});

        expected = 3;
        objectList.add(new Object[]{30, expected});

        expected = 3;
        objectList.add(new Object[]{2, expected});
        return objectList.toArray(new Object[0][0]);
    }
}