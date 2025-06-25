package com.angelogomez.slci.api.application;

import com.angelogomez.slci.api.domain.model.Producto;
import com.angelogomez.slci.api.domain.port.ProductoIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductoService{

    private final ProductoIn productoIn;

    public Producto crearProducto(Producto producto) {
        log.info("inicio crearProducto");
        Producto productoCreado = productoIn.crearProducto(producto);
        log.info("fin crearProducto");
        return productoCreado;
    }

    public List<Producto> listarProductos() {
        return productoIn.listarProductos();
    }

    public String eliminarProducto(int id) {
        productoIn.eliminarProducto(id);
        return "Producto eliminado con éxito";
    }
}
