package com.serms.controller;

import com.serms.entity.Employee;
import com.serms.service.DepartmentService;
import com.serms.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService,
                              DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    // ===========================
    // Employee List
    // ===========================
    @GetMapping
    public String listEmployees(Model model) {

        model.addAttribute("employees", employeeService.getAllEmployees());

        return "employees";
    }

    // ===========================
    // Add Employee Page
    // ===========================
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "employee-add";
    }

    // ===========================
    // Save Employee
    // ===========================
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    // ===========================
    // Edit Employee Page
    // ===========================
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "employee-edit";
    }

    // ===========================
    // Update Employee
    // ===========================
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @ModelAttribute Employee employee) {

        employee.setId(id);

        employeeService.updateEmployee(employee);

        return "redirect:/employees";
    }

    // ===========================
    // Delete Employee
    // ===========================
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return "redirect:/employees";
    }
}