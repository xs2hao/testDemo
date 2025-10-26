package com.example.studentdemo.service.impl;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.service.StudentService;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import com.example.studentdemo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Optional<Student> getStudentById(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> searchStudentsByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public List<Student> getStudentsByClass(String className) {
        return studentDao.findByClassName(className);
    }

    @Override
    public Integer insertAndReturnId(Student student)  { return studentDao.insertAndReturnId(student); };
}
