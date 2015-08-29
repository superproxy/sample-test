package framework;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MethodContext implements Serializable {
    private String path;
    private transient Method method;
    private transient Annotation annotation;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
