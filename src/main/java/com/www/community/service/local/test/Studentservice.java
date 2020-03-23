package com.www.community.service.local.test;

import com.www.community.model.param.test.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Studentservice {
    @Test
    public void test20200316() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "sdf", 5, "sdf"));
        students.add(new Student(2, "阿萨", 2, "sdf"));
        students.add(new Student(1, "sdf", 1, "sdf"));
        students.add(new Student(7, "sdf", 7, "sdf"));
        students.add(new Student(8, "sdf", 8, "sdf"));
        students.add(new Student(9, "sdf", 9, "sdf"));
        students.add(new Student(10, "sdf", 10, "sdf"));
        List<Student> teacher=new ArrayList<>();
        teacher.stream().distinct().forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("dgf");
        String[] strings = list.toArray(new String[0]);
        for (String string:strings
             ) {
            System.out.println("遍历数组"+string);
        }

        students.stream().filter(s -> "阿萨".equals(s.getName())).collect(Collectors.toList()).forEach(System.out::println);
        students.stream().map(s -> s.getName()).collect(Collectors.toList()).forEach(System.out::println);
        //students.stream().distinct().forEach(System.out::println);
        Student s=students.stream().max((stu1, stu2) -> Integer.compare(stu1.getAge(), stu2.getAge())).get();
        System.out.println(s.toString());
    }
}
