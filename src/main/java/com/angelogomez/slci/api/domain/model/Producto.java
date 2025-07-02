package com.angelogomez.slci.api.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Producto {
    private int id;
    @NotBlank
    private String codigo;
    private String nombre;
    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;
    @NotNull(message = "El stock no puede ser nulo")
    @Min(value = 10, message = "El stock debe ser al menos 10")
    private int stock;
    private boolean estaDisponible;
    private double precio;
    private Date createdAt;
    private Date updatedAt;
}
