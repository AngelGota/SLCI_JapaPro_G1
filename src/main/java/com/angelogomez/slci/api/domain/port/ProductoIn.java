package com.angelogomez.slci.api.domain.port;

import com.angelogomez.slci.api.domain.model.Producto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductoIn {
    Producto buscarProductoPorId(Integer idProducto);
    String deshabilitarProducto(Integer idProducto);
    String habilitarProducto(Integer idProducto);
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(Producto producto);
    List<Producto> listarProductos();
    void eliminarProducto(Integer id);
}
