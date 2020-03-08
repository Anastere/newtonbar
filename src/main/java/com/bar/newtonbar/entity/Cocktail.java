package com.bar.newtonbar.entity;

import com.bar.newtonbar.util.HashMapConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cocktails")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @Transient
    private String recipeJSON;
    @NotNull
    @Convert(converter = HashMapConverter.class)
    private HashMap<String, Integer> recipe;
    @ManyToMany(mappedBy = "cocktails")
    private Set<Order> orders;

    public Cocktail(String name, BigDecimal price, String recipeJSON) {
        this.name = name;
        this.price = price;
        setRecipeJSON(recipeJSON);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public HashMap<String, Integer> getRecipe() {
        return recipe;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRecipe(HashMap<String, Integer> recipe) {
        this.recipe = recipe;
        try {
            serializeCustomerAttributes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getRecipeJSON() {
        try {
            serializeCustomerAttributes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return recipeJSON;
    }

    public void setRecipeJSON(String recipeJSON) {
        this.recipeJSON = recipeJSON;
        try {
            deserializeCustomerAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeCustomerAttributes() throws JsonProcessingException {
        this.recipeJSON = new ObjectMapper().writeValueAsString(recipe);
    }

    public void deserializeCustomerAttributes() throws IOException {
        this.recipe = new ObjectMapper().readValue(recipeJSON, HashMap.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cocktail cocktail = (Cocktail) o;
        return Objects.equals(id, cocktail.id) &&
                Objects.equals(name, cocktail.name) &&
                Objects.equals(price, cocktail.price) &&
                Objects.equals(recipeJSON, cocktail.recipeJSON) &&
                Objects.equals(recipe, cocktail.recipe) &&
                Objects.equals(orders, cocktail.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, recipeJSON, recipe, orders);
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", recipeJSON='" + recipeJSON + '\'' +
                '}';
    }
}
