package framework;

import framework.cvs.CvsDataProvider;
import framework.json.JsonDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class CommonDataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDataProvider.class);

    private static Map<Class, IDataProvider> dataProviderMap = new HashMap<Class, IDataProvider>();

    static {
        register(new CvsDataProvider());
        register(new JsonDataProvider());
    }

    private static void register(IDataProvider dataProvider) {
        dataProviderMap.put(dataProvider.getDataType(), dataProvider);
    }


    /**
     * 自动读取测试文件json或者cvs中的数据
     *
     * @param method
     * @return
     */
    @DataProvider
    public static Object[][] genData(Method method) {
        Annotation[] annotations = method.getAnnotations();

        TestObject testObject = testObject(annotations);
        LOGGER.debug("testObject:{}", testObject);
        for (Annotation annotation : annotations) {
            Class c = annotation.annotationType();
            if (dataProviderMap.containsKey(c)) {
                IDataProvider iDataProvider = dataProviderMap.get(c);
                return iDataProvider.getObjects(method, testObject);
            }

        }
        throw new RuntimeException("no data");
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
}
