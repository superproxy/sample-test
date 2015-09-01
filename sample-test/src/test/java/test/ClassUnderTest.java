package test;

import java.io.File;

public class ClassUnderTest {
    public boolean callArgumentInstance(File file) {
        return file.exists();
    }
}
