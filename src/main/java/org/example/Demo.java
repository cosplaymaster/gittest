package org.example;

import com.google.gson.Gson;
import org.example.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        Gson gson = new Gson();
        List<Student>students =new ArrayList<Student>();

        Student student = new Student(123,"小红","16");
        System.out.println(student);

        students.add(student);
        System.out.println(gson.toJson(students));


    }

}
