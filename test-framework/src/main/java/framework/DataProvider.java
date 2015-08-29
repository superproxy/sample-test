package framework;

public interface DataProvider {
    Class getDataType();

    Object[][] getObjects(MethodContext methodContext);
}
