package framework;

import framework.support.csv.CsvDataProvider;
import framework.support.json.JsonDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class CommonDataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDataProvider.class);

    private static Map<Class, DataProvider> dataProviderMap = new HashMap<Class, DataProvider>();

    static {
        register(new CsvDataProvider());
        register(new JsonDataProvider());
    }

    private static void register(DataProvider dataProvider) {
        dataProviderMap.put(dataProvider.getDataType(), dataProvider);
    }


    /**
     * 自动读取测试文件json或者cvs中的数据
     *
     * @param method
     * @return
     */
    @org.testng.annotations.DataProvider
    public static Object[][] genData(Method method) {
        Annotation[] annotations = method.getAnnotations();

        MethodContext methodContext = testObject(annotations);
        LOGGER.debug("methodContext:{}", methodContext);
        for (Annotation annotation : annotations) {
            Class c = annotation.annotationType();
            if (dataProviderMap.containsKey(c)) {
                DataProvider dataProvider = dataProviderMap.get(c);
                methodContext.setAnnotation(annotation);
                methodContext.setMethod(method);
                return dataProvider.getObjects(methodContext);
            }

        }
        throw new RuntimeException("no data");
    }

    private static MethodContext testObject(Annotation[] annotations) {
        MethodContext methodContext = new MethodContext();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Path) {
                methodContext.setPath(((Path) annotation).value());
            }
        }
        return methodContext;
    }
}
