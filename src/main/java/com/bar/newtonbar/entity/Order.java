package com.bar.newtonbar.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private BigDecimal totalPrice;
    @ManyToMany
    @JoinTable(
            name = "order_cocktail",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cocktail_id"))
    private List<Cocktail> cocktails;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Order(BigDecimal totalPrice, List<Cocktail> cocktails) {
        this.totalPrice = totalPrice;
        this.cocktails = cocktails;
    }

}
