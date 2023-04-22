package com.pimentelprojects.finance.repository;

import com.pimentelprojects.finance.dto.CategoryAmountDTO;
import com.pimentelprojects.finance.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT new com.pimentelprojects.finance.dto.CategoryAmountDTO(f.category, SUM(f.amount)) FROM Income f GROUP BY f.category")
    List<CategoryAmountDTO> categoryAmountList();
}
