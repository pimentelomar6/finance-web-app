package com.pimentelprojects.finance.service;


import com.pimentelprojects.finance.dto.CategoryAmountDTO;
import com.pimentelprojects.finance.dto.IncomeDTO;
import com.pimentelprojects.finance.models.Income;

import java.util.List;

public interface IncomeService {

    List<IncomeDTO> getAllIncomes();

    IncomeDTO getById(Long id);
    void createIncome(IncomeDTO incomeDTO);

    void updateIncome(IncomeDTO incomeDTO);

    void deleteById(Long id);

    List<CategoryAmountDTO> categoryAmountList();

}
