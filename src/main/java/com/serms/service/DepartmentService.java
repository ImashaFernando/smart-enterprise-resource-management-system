package com.serms.service;

import com.serms.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();
    List<Department> searchDepartments(String keyword);

    Department saveDepartment(Department department);

    Department getDepartmentById(Long id);

    Department updateDepartment(Department department);

    void deleteDepartment(Long id);

}