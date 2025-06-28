package com.zpark.gmd.project.beans;

import java.util.Date;

public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private String password;
    private Integer salary;
    private Date joinDate; // 注意你原来的变量名拼写错误，这里修正为 joinDate
    private Integer deptId;

    // 无参构造方法
    public Employee() {
    }

    // 有参构造方法（可选，根据需求添加）
    public Employee(Integer id, String name, String gender, String password, Integer salary, Date joinDate, Integer deptId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.salary = salary;
        this.joinDate = joinDate;
        this.deptId = deptId;
    }

    // getter 和 setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    // 可选：重写 toString 方法，方便调试打印
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                ", deptId=" + deptId +
                '}';
    }
}