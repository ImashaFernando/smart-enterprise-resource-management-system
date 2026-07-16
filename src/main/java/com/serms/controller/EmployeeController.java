package com.serms.controller;

import com.serms.entity.Employee;
import com.serms.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employees(

            @RequestParam(required = false) String keyword,

            Model model) {

        if (keyword != null && !keyword.trim().isEmpty()) {

            model.addAttribute(
                    "employees",
                    employeeService.searchEmployees(keyword));

        } else {

            model.addAttribute(
                    "employees",
                    employeeService.getAllEmployees());

        }

        model.addAttribute("keyword", keyword);

        return "employees";
    }

    @GetMapping("/employees/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-add";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    // ===== EDIT =====
    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);

        return "employee-edit";
    }

    // ===== UPDATE =====
    @PostMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @ModelAttribute Employee employee) {

        employee.setId(id);

        employeeService.updateEmployee(employee);

        return "redirect:/employees";
    }
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return "redirect:/employees";
    }

}