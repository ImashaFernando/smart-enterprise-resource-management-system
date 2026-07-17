package com.serms.repository;

import com.serms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByDepartmentNameContainingIgnoreCaseOrDepartmentCodeContainingIgnoreCaseOrManagerNameContainingIgnoreCase(
            String departmentName,
            String departmentCode,
            String managerName
    );

}