package com.angelogomez.slci.api.application;

import com.angelogomez.slci.api.domain.model.Producto;
import com.angelogomez.slci.api.infrastructure.entity.ProductoEntity;
import com.angelogomez.slci.api.infrastructure.mapper.ProductoMapper;
import com.angelogomez.slci.api.infrastructure.repository.ProductoInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoService{

    private final ProductoInterface productoInterface;
    private final ProductoMapper productoMapper;

    // Metodo para crear un producto
    // Con el void nosotros le decimos que no retorna nada
    public Producto crearProducto(Producto producto) {
        ProductoEntity productoEntity = productoMapper.mapToProductoEntity(producto);
        ProductoEntity newEntity = productoInterface.save(productoEntity);

        // Activa notificacion en la consola

        return productoMapper.mapToProducto(newEntity);
    }

    // El mismo metodo pero mas compacto
    public Producto crearProductoCompacto(ProductoEntity productoEntity){
        return productoMapper.mapToProducto(productoInterface.save(productoEntity));
    }

}
