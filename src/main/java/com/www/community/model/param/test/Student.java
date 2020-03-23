package com.www.community.model.param.test;

import lombok.Data;

import java.util.Objects;

@Data
public class Student {

    private Integer id;
    private String name;
    private int age;
    private String address;

    public Student(Integer id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, address);
    }
}
