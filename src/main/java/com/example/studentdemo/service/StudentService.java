// StudentService.java
package com.example.studentdemo.service;

import com.example.studentdemo.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    // 根据ID查询学生
    Optional<Student> getStudentById(Integer id);

    // 查询所有学生
    List<Student> getAllStudents();

    // 根据姓名搜索学生
    List<Student> searchStudentsByName(String name);

    // 根据班级查询学生
    List<Student> getStudentsByClass(String className);

    Integer insertAndReturnId(Student student);

}

