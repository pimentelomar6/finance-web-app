package com.pimentelprojects.finance.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "incomes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String description;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    private LocalDate date;
}
