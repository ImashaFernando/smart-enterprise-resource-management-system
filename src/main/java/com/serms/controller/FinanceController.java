package com.serms.controller;

import com.serms.entity.Finance;
import com.serms.service.FinanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping
    public String listFinance(@RequestParam(required = false) String keyword, Model model) {

        model.addAttribute("financeList", financeService.searchFinance(keyword));
        model.addAttribute("keyword", keyword);

        return "finance";
    }

    @GetMapping("/add")
    public String addFinance(Model model) {
        model.addAttribute("finance", new Finance());
        return "finance-add";
    }
}