package com.angelogomez.slci.api.domain.port;

import com.angelogomez.slci.api.domain.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductoImpl implements ProductoIn{

    private final ProductoOut productoOut;

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        return productoOut.buscarProductoPorId(idProducto);
    }

    @Override
    public String deshabilitarProducto(Integer idProducto) {
        return productoOut.deshabilitarProducto(idProducto);
    }

    @Override
    public String habilitarProducto(Integer idProducto) {
        return productoOut.habilitarProducto(idProducto);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoOut.crearProducto(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoOut.actualizarProducto(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoOut.listarProductos();
    }

    @Override
    public void eliminarProducto(Integer id) {
    }
}
