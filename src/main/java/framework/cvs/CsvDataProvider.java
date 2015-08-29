package framework.cvs;

import framework.IDataProvider;
import framework.MethodUtils;
import framework.TestObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvDataProvider implements IDataProvider {
    @Override
    public Class getDataType() {
        return Csv.class;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvDataProvider.class);

    @Override
    public Object[][] getObjects(Method method, TestObject testObject) {
        String filePath = testObject.getPath();
        try {
            return getObjects(filePath, method);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object[][] getObjects(String filePath, Method method) throws Exception {
        LOGGER.debug("path:{}", new File(".").getAbsolutePath());
        Scanner scanner = new Scanner(new FileInputStream(filePath), "UTF-8");
        // 第一行
        String head = scanner.nextLine();

        LOGGER.debug("head:{}", head);
        String[] paramNames = MethodUtils.getParameterNames(method);
        int paramCount = head.split(",").length;
        Class[] paraTypes = method.getParameterTypes();
        List<Object[]> list = new ArrayList<Object[]>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] array = data.split(",");
            LOGGER.debug("data:{}", data);
            Object[] objects = new Object[paramCount];
            for (int i = 0; i < paramCount; i++) {
                objects[i] = array[i];
            }
            list.add(objects);
        }
        return list.toArray(new Object[0][0]);
    }
}
