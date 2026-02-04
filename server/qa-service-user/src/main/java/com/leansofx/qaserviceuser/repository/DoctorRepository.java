package com.leansofx.qaserviceuser.repository;

import com.leansofx.qaserviceuser.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    // 根据医生ID查找医生
    Optional<Doctor> findByDocId(String docId);
    
    // 根据用户名查找医生
    Optional<Doctor> findByUsername(String username);
    
    // 根据科室查找医生
    List<Doctor> findByDepartment(String department);
    
    // 根据激活状态查找医生
    List<Doctor> findByIsActive(Boolean isActive);
    
    // 根据姓名模糊查询医生
    List<Doctor> findByNameContaining(String name);
    
    // 根据职称查找医生
    List<Doctor> findByTitle(String title);
    
    // 查找激活状态的医生
    @Query("SELECT d FROM Doctor d WHERE d.isActive = true")
    List<Doctor> findActiveDoctors();
    
    // 根据科室和激活状态查找医生
    @Query("SELECT d FROM Doctor d WHERE d.department = :department AND d.isActive = :isActive")
    List<Doctor> findByDepartmentAndIsActive(@Param("department") String department, @Param("isActive") Boolean isActive);
}