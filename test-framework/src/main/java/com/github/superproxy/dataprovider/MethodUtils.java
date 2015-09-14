package com.github.superproxy.dataprovider;

import java.lang.reflect.Method;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

public final class MethodUtils {
    private static final ParameterNameDiscoverer parameterNameDiscoverer
            = new LocalVariableTableParameterNameDiscoverer();

    // NOTE might go wrong if missing debug symbols
    public static String[] getParameterNames(final Method method) {
        return parameterNameDiscoverer.getParameterNames(method);
    }
}