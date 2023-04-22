package com.pimentelprojects.finance.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double balance;
    @OneToMany(mappedBy="account")
    private List<Income> incomes;
    @OneToMany(mappedBy="account")
    private List<Expense> expenses;

}
