package com.github.superproxy.dataprovider;

public interface DataProvider {
    Class getDataType();

    Object[][] getObjects(MethodContext methodContext);
}
