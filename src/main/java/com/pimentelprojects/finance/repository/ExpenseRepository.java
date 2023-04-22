package com.pimentelprojects.finance.repository;

import com.pimentelprojects.finance.dto.CategoryAmountDTO;
import com.pimentelprojects.finance.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT new com.pimentelprojects.finance.dto.CategoryAmountDTO(f.category, SUM(f.amount)) FROM Expense f GROUP BY f.category")
    List<CategoryAmountDTO> categoryAmountList();
}
