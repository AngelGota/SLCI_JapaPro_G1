package com.angelogomez.slci.api.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductoEntity {
    @Id
    private int id;
    @Column(name = "code")
    private String codigo;
    @Column(name = "name")
    private String nombre;
    @Column(name = "description")
    private String marca;
    @Column(name = "stock")
    private int stock;
    @Column(name = "available")
    private boolean estaDisponible;
    @Column(name = "price")
    private double precio;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

}