package framework;

import java.lang.reflect.Method;

public interface IDataProvider {
    Class getDataType();

    Object[][] getObjects(Method method, TestObject testObject);
}
