// Student.java
package com.example.studentdemo.entity;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;  // 改为字符串类型，前端更友好
    private String className;

    // 构造方法
    public Student() {}

    public Student(Integer id, String name, Integer age, String gender, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.className = className;
    }

    public Student(String name, Integer age, String gender, String className) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.className = className;
    }

    // Getter 和 Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}