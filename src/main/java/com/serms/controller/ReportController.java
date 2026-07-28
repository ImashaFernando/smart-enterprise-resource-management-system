package com.serms.controller;

import com.serms.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;

@Controller
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports")
    public String reports(Model model) {

        // Raw numeric values
        double income = reportService.getTotalIncome();
        double expense = reportService.getTotalExpense();
        double balance = income - expense;

        // Formatted values for display
        DecimalFormat df = new DecimalFormat("#,##0.00");

        model.addAttribute("totalIncome", df.format(income));
        model.addAttribute("totalExpense", df.format(expense));
        model.addAttribute("netBalance", df.format(balance));

        // Raw values for Chart.js
        model.addAttribute("incomeValue", income);
        model.addAttribute("expenseValue", expense);

        model.addAttribute("totalTransactions",
                reportService.getTotalTransactions());

        model.addAttribute("recentTransactions",
                reportService.getRecentTransactions());

        return "reports";
    }
}