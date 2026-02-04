package com.leansofx.qaserviceuser.service;

import com.leansofx.qaserviceuser.entity.Doctor;
import com.leansofx.qaserviceuser.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // 获取所有医生
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // 根据ID获取医生
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // 根据医生ID获取医生
    public Optional<Doctor> getDoctorByDocId(String docId) {
        return doctorRepository.findByDocId(docId);
    }

    // 根据用户名获取医生
    public Optional<Doctor> getDoctorByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

    // 创建医生
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // 更新医生
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        doctor.setDocId(doctorDetails.getDocId());
        doctor.setUsername(doctorDetails.getUsername());
        doctor.setPassword(doctorDetails.getPassword());
        doctor.setName(doctorDetails.getName());
        doctor.setTitle(doctorDetails.getTitle());
        doctor.setDepartment(doctorDetails.getDepartment());
        doctor.setAvatar(doctorDetails.getAvatar());
        doctor.setExperience(doctorDetails.getExperience());
        doctor.setSpecialties(doctorDetails.getSpecialties());
        doctor.setIsActive(doctorDetails.getIsActive());

        return doctorRepository.save(doctor);
    }

    // 删除医生
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        doctorRepository.delete(doctor);
    }

    // 根据科室查找医生
    public List<Doctor> getDoctorsByDepartment(String department) {
        return doctorRepository.findByDepartment(department);
    }

    // 根据激活状态查找医生
    public List<Doctor> getDoctorsByActiveStatus(Boolean isActive) {
        return doctorRepository.findByIsActive(isActive);
    }

    // 根据姓名模糊查询医生
    public List<Doctor> searchDoctorsByName(String name) {
        return doctorRepository.findByNameContaining(name);
    }

    // 根据职称查找医生
    public List<Doctor> getDoctorsByTitle(String title) {
        return doctorRepository.findByTitle(title);
    }

    // 获取激活状态的医生
    public List<Doctor> getActiveDoctors() {
        return doctorRepository.findActiveDoctors();
    }

    // 根据科室和激活状态查找医生
    public List<Doctor> getDoctorsByDepartmentAndActiveStatus(String department, Boolean isActive) {
        return doctorRepository.findByDepartmentAndIsActive(department, isActive);
    }
}