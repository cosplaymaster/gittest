package org.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class Controller {

    @Autowired
    StudentMapper studentMapper;

    private Gson gson = new Gson();

    @GetMapping("/test")
    public String test() {

        List<Student> students = studentMapper.selectList(null);

        int a = 1;
        int b = 2;
        int c = a + b;
        //return "a+b= " + c;

        return gson.toJson(students);
    }
    @GetMapping("/delete")
    public void delete() {

        String student="{\"id\":5,\"name\":\"小军\",\"score\":\"100\"}";
        Student student1 = gson.fromJson(student, Student.class);
        studentMapper.deleteById(student1);
    }
    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {

        //String student="{\"id\":8,\"name\":\"小唐\",\"score\":\"30\"}";
        //Student student1 = gson.fromJson(student, Student.class);
        studentMapper.insert(student);
    }
    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentMapper.updateById(student);
    }
}
