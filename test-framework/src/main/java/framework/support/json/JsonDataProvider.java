package framework.support.json;

import com.alibaba.fastjson.JSON;
import framework.DataProvider;
import framework.MethodContext;
import framework.MethodUtils;
import javassist.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonDataProvider implements DataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDataProvider.class);

    @Override
    public Class getDataType() {
        return Json.class;
    }

    @Override
    public Object[][] getObjects(MethodContext methodContext) {
        Annotation annotation = methodContext.getAnnotation();
        Method method = methodContext.getMethod();

        //  parse selft
        if (annotation instanceof Json) {
            String path = ((Json) annotation).value();
            if (StringUtils.isNoneEmpty(path)) {
                methodContext.setPath(path);
            }
        }

        String filePath = methodContext.getPath();
        // 分析json串，然后传递给各个model
        String s = readWholeTextFromFile(filePath);
        // 动态创建类：数据成员对应，参数传进来的类型
        try {
            return getObjects(method, s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object[][] getObjects(Method method, String s) throws CannotCompileException, NotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 类无中生有
        String className = "test." + method.getDeclaringClass().getName() + "_" + method.getName();
        // 参数从左到右
        String[] paramNames = MethodUtils.getParameterNames(method);
        int paramCount = paramNames.length;
        Class[] paraTypes = method.getParameterTypes();
        CtClass aClass = buildClass(className, paramNames, paramCount, paraTypes);
        Class c = aClass.toClass();
        List<Object> inputs = JSON.parseArray(s, c);
        List<Object[]> list = new ArrayList<Object[]>();
        for (Object input : inputs) {
            Object[] objects = new Object[paramCount];
            for (int i = 0; i < paramCount; i++) {
                String fieldName = paramNames[i];
                String upperName = getUpperName(fieldName);
                objects[i] = input.getClass().getMethod("get" + upperName).invoke(input);
            }
            list.add(objects);
        }

        aClass.detach();    //删除定义的类
        return list.toArray(new Object[0][0]);
    }

    private static CtClass buildClass(String className, String[] paramNames, int paramCount, Class[] paraTypes) throws CannotCompileException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass newClass = pool.makeClass(className);
//        //添加构造器
//        CtConstructor cons = new CtConstructor(new CtClass[]{}, newClass);
//        newClass.addConstructor(cons);

        // 添加私有成员name及其getter、setter方法
        for (int i = 0; i < paramCount; i++) {
            String typeName = paraTypes[i].getName();
            String fieldName = paramNames[i];
            String upperName = getUpperName(fieldName);
            CtField ctField = new CtField(pool.get(typeName), fieldName, newClass);
            ctField.setModifiers(Modifier.PRIVATE);
            newClass.addField(ctField);
            newClass.addMethod(CtNewMethod.setter("set" + upperName, ctField));
            newClass.addMethod(CtNewMethod.getter("get" + upperName, ctField));
        }

        return newClass;
    }

    private static String getUpperName(String fieldName) {
        return StringUtils.upperCase(fieldName.substring(0, 1)) + fieldName.substring(1);
    }

    private static String readWholeTextFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            LOGGER.debug("path:{}", new File(".").getAbsolutePath());
            Scanner scanner = new Scanner(new FileInputStream(filePath));

            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
