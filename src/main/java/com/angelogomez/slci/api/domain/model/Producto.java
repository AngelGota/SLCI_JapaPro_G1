package com.angelogomez.slci.api.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String marca;
    private int stock;
    private boolean estaDisponible;
    private double precio;
    private Date createdAt;
    private Date updatedAt;
}
