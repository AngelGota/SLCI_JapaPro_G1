package com.angelogomez.slci.api.infrastructure.adapter;

import com.angelogomez.slci.api.domain.model.Producto;
import com.angelogomez.slci.api.domain.port.ProductoOut;
import com.angelogomez.slci.api.infrastructure.entity.ProductoEntity;
import com.angelogomez.slci.api.infrastructure.mapper.ProductoMapper;
import com.angelogomez.slci.api.infrastructure.repository.ProductoInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductoAdapter implements ProductoOut {

    private final ProductoInterface productoInterface;
    private final ProductoMapper productoMapper;

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        return null;
    }

    @Override
    public String deshabilitarProducto(Integer idProducto) {
        return "";
    }

    @Override
    public String habilitarProducto(Integer idProducto) {
        return "";
    }

    @Override
    public Producto crearProducto(Producto producto) {
        // Aquí se implementaría la lógica para crear un producto
        ProductoEntity conversionProducto = productoMapper.mapToProductoEntity(producto);
        ProductoEntity productoGuardado = productoInterface.save(conversionProducto);
        Producto returnProducto = productoMapper.mapToProducto(productoGuardado);
        return returnProducto;
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return null;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoMapper.mapToProductos(productoInterface.findAll());
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        productoInterface.deleteById(idProducto);
    }
}
