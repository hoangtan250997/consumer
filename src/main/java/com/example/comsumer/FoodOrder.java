package com.example.comsumer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drink_order")
public class FoodOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    private Double amount;
}
