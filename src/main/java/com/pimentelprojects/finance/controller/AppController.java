package com.pimentelprojects.finance.controller;

import com.pimentelprojects.finance.service.AccountService;
import com.pimentelprojects.finance.service.ExpenseService;
import com.pimentelprojects.finance.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AppController {


    private final AccountService accountService;
    private final IncomeService incomeService;
    private final ExpenseService expenseService;


    @GetMapping
    public String inicio(Model model){
        model.addAttribute("account", accountService.getById(1l));
        model.addAttribute("income", incomeService.categoryAmountList());
        model.addAttribute("expense", expenseService.categoryAmountList());
        return "home";
    }
}
