package framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public interface IDataProvider {
    Class getDataType();

    Object[][] getObjects(Method method, Annotation annotation, TestObject testObject);
}
