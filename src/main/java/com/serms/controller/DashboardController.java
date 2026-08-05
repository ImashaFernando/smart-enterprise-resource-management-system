package com.serms.controller;

import com.serms.service.DepartmentService;
import com.serms.service.EmployeeService;
import com.serms.service.FinanceService;
import com.serms.service.InventoryService;
import com.serms.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final ProjectService projectService;
    private final InventoryService inventoryService;
    private final FinanceService financeService;

    public DashboardController(EmployeeService employeeService,
                               DepartmentService departmentService,
                               ProjectService projectService,
                               InventoryService inventoryService,
                               FinanceService financeService) {

        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.projectService = projectService;
        this.inventoryService = inventoryService;
        this.financeService = financeService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("employeeCount",
                employeeService.getAllEmployees().size());

        model.addAttribute("departmentCount",
                departmentService.getAllDepartments().size());

        model.addAttribute("projectCount",
                projectService.getAllProjects().size());

        model.addAttribute("inventoryCount",
                inventoryService.getAllInventory().size());

        model.addAttribute("totalRevenue",
                financeService
                        .getTotalIncome());

        return "dashboard";
    }

}