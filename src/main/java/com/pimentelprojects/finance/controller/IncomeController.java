package com.pimentelprojects.finance.controller;


import com.pimentelprojects.finance.dto.IncomeDTO;
import com.pimentelprojects.finance.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping
    public String incomeList(Model model){
        model.addAttribute("incomes", incomeService.getAllIncomes());
        return "incomes/details";
    }

    @GetMapping("create")
    public String createIncomeForm(Model model){
        model.addAttribute("accountId", 1);
        return "incomes/form";
    }

    @PostMapping("create")
    public String createIncome(@ModelAttribute("income") IncomeDTO income){
        incomeService.createIncome(income);
        return "redirect:/income";
    }

    @GetMapping("{id}")
    public String editIncomeForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("income", incomeService.getById(id));
        model.addAttribute("accountId", 1);
        return "incomes/form";
    }

    @PostMapping("{id}")
    public String editIncome(@ModelAttribute("income") IncomeDTO income){
        incomeService.updateIncome(income);
        return "redirect:/income";
    }



    @GetMapping("{id}/delete")
    public String deleteIncome(@PathVariable("id") Long id){
        incomeService.deleteById(id);
        return "redirect:/income";
    }
}
