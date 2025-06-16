package com.angelogomez.slci.api.domain.model;

// Importacion de librerias necesarias
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Clase Producto que representa un producto en el sistema
@Getter
@Setter
public class Producto {
    private int id;
    @NotBlank(message = "El código del producto no puede estar vacío")
    private String codigo;
    private String nombre;
    private String marca;
    // Validación para asegurar que el stock sea numero
    @Pattern(regexp = "^[0-9]+$")
    @Min(value = 0, message = "El stock debe ser un número entero positivo")
    @Max(value = 250, message = "El stock no puede ser mayor a 250")
    @NotNull(message = "El stock del producto no puede ser nulo")
    private int stock;
    private boolean estaDisponible;
    private double precio;
    private Date createdAt;
    private Date updatedAt;
}
