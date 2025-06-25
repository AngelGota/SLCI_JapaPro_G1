package com.angelogomez.slci.api.infrastructure.mapper;

import com.angelogomez.slci.api.domain.model.Producto;
import com.angelogomez.slci.api.infrastructure.entity.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    // Esto es un metodo de mapper, que sirve para convertir un ProductoEntity a Producto
//    public Producto mapToProducto(ProductoEntity productoEntity) {
//        Producto producto = modelMapper.map(productoEntity, Producto.class);
//        return producto;
//    }
    public Producto mapToProducto(ProductoEntity productoEntity) {
        return modelMapper.map(productoEntity, Producto.class);
    }

    public ProductoEntity mapToProductoEntity(Producto producto) {
        return modelMapper.map(producto, ProductoEntity.class);
    }

    public List<Producto> mapToProductos(List<ProductoEntity> productoEntityList) {
        return productoEntityList.stream()
                .map(this::mapToProducto)
                .toList();
    }

    public List<ProductoEntity> mapToProductoEntities(List<Producto> productoList) {
        return productoList.stream()
                .map(this::mapToProductoEntity)
                .toList();
    }
}
