package com.zeuscontrol.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Entidad que representa un producto en el inventario")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;
    @Schema(description = "Nombre del producto", example = "Masmelos")
    private String name;
    @Schema(description = "Descripción del producto", example = "Masmelos copo")
    private String description;
    @Schema(description = "Precio del producto", example = "15000")
    private Double price;
    @Schema(description = "Cantidad disponible del producto", example = "10")
    private Integer quantity;

    // Constructor sin argumentos (obligatorio para JPA)
    public Product() {
    }

    // Constructor con argumentos
    public Product(Long id, String name, String description, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}



