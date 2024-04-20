package com.hualan.domain;

import java.util.Date;

public class Student {
    private int id;
    private String  name;
    private String sex;
    private int age;
    private String college;
    private String major;
    private String phone;
    private Date createTime;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String sex, int age, String college, String major, String phone) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.college = college;
        this.major = major;
        this.phone = phone;
    }

    public Student(int id, String name, String sex, int age, String college, String major, String phone, Date createTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.college = college;
        this.major = major;
        this.phone = phone;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
