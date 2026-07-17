package com.serms.controller;
import java.util.List;

import com.serms.entity.Department;
import com.serms.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String listDepartments(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        List<Department> departments = departmentService.searchDepartments(keyword);

        model.addAttribute("departments", departments);
        model.addAttribute("keyword", keyword);

        return "departments";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("department", new Department());
        return "department-add";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }
    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable Long id, Model model) {

        Department department = departmentService.getDepartmentById(id);

        if (department == null) {
            return "redirect:/departments";
        }

        model.addAttribute("department", department);

        return "department-edit";
    }
    @PostMapping("/update/{id}")
    public String updateDepartment(@PathVariable Long id,
                                   @ModelAttribute Department department) {

        department.setId(id);

        departmentService.updateDepartment(department);

        return "redirect:/departments";
    }
    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {

        departmentService.deleteDepartment(id);

        return "redirect:/departments";
    }

}