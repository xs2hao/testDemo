// StudentApiApplication.java
package com.example.studentdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
        System.out.println("学生查询接口服务已启动：http://localhost:8080");
        System.out.println("接口文档：");
        System.out.println("1. 根据ID查询：GET http://localhost:8080/api/students/{id}");
        System.out.println("2. 查询所有：GET http://localhost:8080/api/students");
        System.out.println("3. 按姓名搜索：GET http://localhost:8080/api/students/search?name=关键词");
        System.out.println("4. 按班级查询：GET http://localhost:8080/api/students/class?className=班级名");
        System.out.println("5. 健康检查：GET http://localhost:8080/api/students/health");
    }
}