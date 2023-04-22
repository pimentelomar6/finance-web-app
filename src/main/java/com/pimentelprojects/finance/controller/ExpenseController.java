package com.pimentelprojects.finance.controller;

import com.pimentelprojects.finance.dto.ExpenseDTO;
import com.pimentelprojects.finance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String expenseList(Model model){
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "details";
    }

    @GetMapping("create")
    public String createExpenseForm(Model model){
        model.addAttribute("accountId", 1);
        return "form";
    }

    @PostMapping("create")
    public String createExpense(@ModelAttribute("expense") ExpenseDTO expense){
        expenseService.createExpense(expense);
        return "redirect:/expense";
    }

    @GetMapping("{id}")
    public String editExpense(@PathVariable("id") Long id, Model model){
        model.addAttribute("expense", expenseService.getById(id));
        model.addAttribute("accountId", 1);
        return "form";
    }

    @PostMapping("{id}")
    public String editExpense(@ModelAttribute("expense") ExpenseDTO expense){
        expenseService.updateExpense(expense);
        return "redirect:/expense";
    }


    @GetMapping("{id}/delete")
    public String deleteExpense(@PathVariable("id") Long id){
        expenseService.deleteExpenseById(id);
        return "redirect:/expense";
    }
}
