package com.leansofx.qaserviceuser.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String docId;      // 对应JSON中的id字段

    @Column(nullable = false, unique = true)
    private String username;   // 对应JSON中的username字段

    @Column(nullable = false)
    private String password;   // 对应JSON中的password字段

    @Column(nullable = false)
    private String name;       // 对应JSON中的name字段

    @Column(nullable = false)
    private String title;      // 对应JSON中的title字段

    @Column(nullable = false)
    private String department; // 对应JSON中的department字段

    @Column(length = 1000)
    private String avatar;     // 对应JSON中的avatar字段

    @Column(length = 500)
    private String experience; // 对应JSON中的experience字段

    @Column(length = 1000)
    private String specialties; // 存储为JSON字符串格式，对应JSON中的specialties数组

    @Column(nullable = false)
    private Boolean isActive;  // 对应JSON中的isActive字段

    // 构造函数
    public Doctor() {}

    public Doctor(String docId, String username, String password, String name, String title, 
                  String department, String avatar, String experience, String specialties, Boolean isActive) {
        this.docId = docId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.title = title;
        this.department = department;
        this.avatar = avatar;
        this.experience = experience;
        this.specialties = specialties;
        this.isActive = isActive;
    }

    // Getter和Setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}