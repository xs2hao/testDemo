// StudentDao.java
package com.example.studentdemo.dao;

import com.example.studentdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 根据ID查询学生
    public Optional<Student> findById(Integer id) {
        String sql = "SELECT id, name, age, gender, class_name as className FROM student WHERE id = ?";
        try {
            Student student = jdbcTemplate.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(Student.class),
                    id
            );
            return Optional.ofNullable(student);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // 查询所有学生
    public List<Student> findAll() {
        String sql = "SELECT id, name, age, gender, class_name as className FROM student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    // 根据姓名模糊查询
    public List<Student> findByName(String name) {
        String sql = "SELECT id, name, age, gender, class_name as className FROM student WHERE name LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), "%" + name + "%");
    }

    // 根据班级查询
    public List<Student> findByClassName(String className) {
        String sql = "SELECT id, name, age, gender, class_name as className FROM student WHERE class_name = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), className);
    }

    public boolean update(Student student) {
        String sql = "UPDATE student SET class_name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getClassName(), student.getId()) > 0;
    }

    /**
     * 插入并返回生成的主键
     */
    public Integer insertAndReturnId(Student student) {
        String sql = "INSERT INTO student (name, age, gender, class_name) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getClassName());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() == null) {
            return 0;
        } else {
            Long id = keyHolder.getKey().longValue();
            return id.intValue();

        }
    }
}