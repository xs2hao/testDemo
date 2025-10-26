// StudentController.java
package com.example.studentdemo.controller;

import com.example.studentdemo.common.ApiResult;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")  // 允许前端跨域访问
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 根据ID查询学生
     * GET http://localhost:8080/api/students/1
     */
    @GetMapping("/{id}")
    public ApiResult<Student> getStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ApiResult.success("查询成功", student.get());
        } else {
            return ApiResult.notFound("未找到ID为 " + id + " 的学生");
        }
    }

    /**
     * 查询所有学生
     * GET http://localhost:8080/api/students
     */
    @GetMapping
    public ApiResult<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ApiResult.success("查询成功", students);
    }

    /**
     * 根据姓名搜索学生
     * GET http://localhost:8080/api/students/search?name=张
     */
    @GetMapping("/search")
    public ApiResult<List<Student>> searchStudents(@RequestParam String name) {
        List<Student> students = studentService.searchStudentsByName(name);
        return ApiResult.success("查询成功", students);
    }

    /**
     * 根据班级查询学生
     * GET http://localhost:8080/api/students/class?className=三年级二班
     */
    @GetMapping("/class")
    public ApiResult<List<Student>> getStudentsByClass(@RequestParam String className) {
        List<Student> students = studentService.getStudentsByClass(className);
        return ApiResult.success("查询成功", students);
    }

    /**
     * 健康检查接口
     * GET http://localhost:8080/api/students/health
     */
    @GetMapping("/health")
    public ApiResult<String> healthCheck() {
        return ApiResult.success("服务运行正常", null);
    }

    @PostMapping(path="/add")
    public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student) {
        Integer newId = studentService.insertAndReturnId(student);
        Map<String, Object> response = new HashMap<>();
        if (newId != null) {
            response.put("success", true);
            response.put("message", "学生创建成功");
            response.put("studentId", newId);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "学生创建失败");
            return ResponseEntity.status(500).body(response);
        }
    }
}