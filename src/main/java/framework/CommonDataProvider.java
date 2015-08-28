package framework;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class CommonDataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDataProvider.class);

    @DataProvider
    public static Object[][] testData(Method method) {
        Annotation[] annotations = method.getAnnotations();

        TestObject testObject = testObject(annotations);
        LOGGER.debug("testObject:{}", testObject);
        for (Annotation annotation : annotations) {
            if (annotation instanceof Json) {
                LOGGER.debug("json");
                return getObjects(method, testObject);
            }
            if (annotation instanceof Cvs) {
                LOGGER.debug("cvs");
                return getObjects(method, testObject);
            }
        }

        return getObjects(method, testObject);
    }

    private static TestObject testObject(Annotation[] annotations) {
        TestObject testObject = new TestObject();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Path) {
                testObject.setPath(((Path) annotation).value());
            }
        }
        return testObject;
    }

    private static Object[][] getObjects(Method method, TestObject testObject) {
        String filePath = testObject.getPath();
        // 分析json串，然后传递给各个model
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(filePath));

            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }

            String s = sb.toString();

//        动态创建类
            Input input = JSON.parseObject(s, Input.class);
            LOGGER.debug("input:{}", input);

            return  new Object[][]
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // 构建object json格式方式
        return new Object[0][0];
    }


}
