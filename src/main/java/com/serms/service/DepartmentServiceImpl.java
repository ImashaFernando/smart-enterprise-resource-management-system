package com.serms.service;

import com.serms.entity.Department;
import com.serms.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }


    @Override
    public Department getDepartmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }
    @Override
    public List<Department> searchDepartments(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return repository.findAll();
        }

        return repository
                .findByDepartmentNameContainingIgnoreCaseOrDepartmentCodeContainingIgnoreCaseOrManagerNameContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword
                );
    }
}