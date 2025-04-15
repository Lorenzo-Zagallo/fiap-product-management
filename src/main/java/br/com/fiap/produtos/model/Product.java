package br.com.fiap.produtos.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    
    private Long id;
    private String name;
    private String description;
    private Double price;
    private LocalDateTime registrationDate;
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, LocalDateTime registrationDate, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.registrationDate = registrationDate;
        this.category = category;
    }

    public Product(String name, String description, Double price, LocalDateTime registrationDate, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.registrationDate = registrationDate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Product setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
