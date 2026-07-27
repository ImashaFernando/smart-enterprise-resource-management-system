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
    public String listFinance(@RequestParam(required = false) String keyword,
                              Model model) {

        model.addAttribute("financeList",
                financeService.searchFinance(keyword));

        model.addAttribute("keyword", keyword);

        return "finance";
    }

    @GetMapping("/add")
    public String addFinance(Model model) {

        model.addAttribute("finance", new Finance());

        return "finance-add";
    }

    @PostMapping("/save")
    public String saveFinance(@ModelAttribute("finance") Finance finance) {

        financeService.saveFinance(finance);

        return "redirect:/finance";
    }

    @GetMapping("/edit/{id}")
    public String editFinance(@PathVariable Long id,
                              Model model) {

        model.addAttribute("finance",
                financeService.getFinanceById(id));

        return "finance-edit";
    }

    @PostMapping("/update/{id}")
    public String updateFinance(@PathVariable Long id,
                                @ModelAttribute Finance finance) {

        finance.setId(id);

        financeService.saveFinance(finance);

        return "redirect:/finance";
    }

    @GetMapping("/delete/{id}")
    public String deleteFinance(@PathVariable Long id) {

        financeService.deleteFinance(id);

        return "redirect:/finance";
    }

}