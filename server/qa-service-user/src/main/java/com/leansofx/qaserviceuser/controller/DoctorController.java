package com.leansofx.qaserviceuser.controller;

import com.leansofx.qaserviceuser.entity.Doctor;
import com.leansofx.qaserviceuser.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // 获取所有医生
    @GetMapping("/list")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // 根据ID获取医生
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 根据医生ID获取医生
    @GetMapping("/by-doc-id/{docId}")
    public ResponseEntity<Doctor> getDoctorByDocId(@PathVariable String docId) {
        Optional<Doctor> doctor = doctorService.getDoctorByDocId(docId);
        if (doctor.isPresent()) {
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 根据用户名获取医生
    @GetMapping("/by-username/{username}")
    public ResponseEntity<Doctor> getDoctorByUsername(@PathVariable String username) {
        Optional<Doctor> doctor = doctorService.getDoctorByUsername(username);
        if (doctor.isPresent()) {
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 创建医生
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    // 更新医生
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
            return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 删除医生
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable Long id) {
        try {
            doctorService.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 根据科室获取医生
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Doctor>> getDoctorsByDepartment(@PathVariable String department) {
        List<Doctor> doctors = doctorService.getDoctorsByDepartment(department);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // 根据激活状态获取医生
    @GetMapping("/active/{isActive}")
    public ResponseEntity<List<Doctor>> getDoctorsByActiveStatus(@PathVariable Boolean isActive) {
        List<Doctor> doctors = doctorService.getDoctorsByActiveStatus(isActive);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // 模糊搜索医生姓名
    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<Doctor>> searchDoctorsByName(@PathVariable String name) {
        List<Doctor> doctors = doctorService.searchDoctorsByName(name);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // 根据职称获取医生
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Doctor>> getDoctorsByTitle(@PathVariable String title) {
        List<Doctor> doctors = doctorService.getDoctorsByTitle(title);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // 获取激活状态的医生
    @GetMapping("/active")
    public ResponseEntity<List<Doctor>> getActiveDoctors() {
        List<Doctor> doctors = doctorService.getActiveDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // 根据科室和激活状态获取医生
    @GetMapping("/department/{department}/active/{isActive}")
    public ResponseEntity<List<Doctor>> getDoctorsByDepartmentAndActiveStatus(
            @PathVariable String department, 
            @PathVariable Boolean isActive) {
        List<Doctor> doctors = doctorService.getDoctorsByDepartmentAndActiveStatus(department, isActive);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}