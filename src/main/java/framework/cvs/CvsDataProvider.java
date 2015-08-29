package framework.cvs;

import framework.IDataProvider;
import framework.TestObject;

import java.lang.reflect.Method;

public class CvsDataProvider implements IDataProvider {
    @Override
    public Class getDataType() {
        return Cvs.class;
    }

    @Override
    public Object[][] getObjects(Method method, TestObject testObject) {
        return new Object[0][];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
