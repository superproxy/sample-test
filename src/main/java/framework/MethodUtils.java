package framework;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

/**
 * @author sajia
 */
public final class MethodUtils {
    private static final ParameterNameDiscoverer parameterNameDiscoverer
            = new LocalVariableTableParameterNameDiscoverer();

    // NOTE might go wrong if missing debug symbols
    public static String[] getParameterNames(final Method method) {
        return parameterNameDiscoverer.getParameterNames(method);
    }

//	public static ParameterInfo[] getParameterInfos(final Method method) {
//		String[] paramNames = getParameterNames(method);
//		Type[] paramTypes = method.getGenericParameterTypes();
//		int paramCount = paramNames.length;
//		ParameterInfo[] paramInfos = new ParameterInfo[paramCount];
//		for (int i = 0; i < paramCount; i++) {
//			paramInfos[i] = ParameterInfo.of(paramNames[i], paramTypes[i], i);
//		}
//		return paramInfos;
//	}
}