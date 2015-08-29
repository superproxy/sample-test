package framework;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class TestModel implements Serializable {
    private String name;
    private String password;
    private int age;
    private int rank;

    public TestModel(String name, String password, int age) {
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public TestModel(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TestModel(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public TestModel() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
