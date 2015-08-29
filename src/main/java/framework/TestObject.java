package framework;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class TestObject  implements Serializable {
    private String path;


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
