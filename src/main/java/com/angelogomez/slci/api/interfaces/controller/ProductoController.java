package com.angelogomez.slci.api.interfaces.controller;

import com.angelogomez.slci.api.application.ProductoService;
import com.angelogomez.slci.api.domain.model.Producto;
import com.angelogomez.slci.api.interfaces.dto.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
@Slf4j
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/crear")
    public ApiResponse crearProducto(@Valid @RequestBody Producto producto) {
        Producto productoResult = productoService.crearProducto(producto);
        ApiResponse response = new ApiResponse();
        if (productoResult != null) {
            response.setData(productoResult);
            response.setMessage("Producto creada con exito");
            response.setSuccess(Boolean.TRUE);
        } else {
            response.setMessage("Error al crear el producto");
            response.setSuccess(Boolean.FALSE);
        }
        return response;
    }

    @PostMapping("/actualizar")
    public ApiResponse actualizarProducto(@Valid @RequestBody Producto producto) {
        Producto productoResult = productoService.actualizarProducto(producto);
        ApiResponse response = new ApiResponse();
        if (productoResult != null) {
            response.setData(productoResult);
            response.setMessage("Producto actualizado con exito");
            response.setSuccess(Boolean.TRUE);
        } else {
            response.setMessage("Error al actualizado el producto");
            response.setSuccess(Boolean.FALSE);
        }
        return response;
    }

    @GetMapping
    public ApiResponse listarProductos() {
        log.info("Listando productos");
        ApiResponse response = new ApiResponse();
        response.setData(productoService.listarProductos());
        response.setMessage("Lista de productos obtenida con éxito");
        response.setSuccess(Boolean.TRUE);
        return response;
    }

    @DeleteMapping
    public ApiResponse eliminarProducto(@RequestParam int id) {
        log.info("Eliminando producto con ID: {}", id);
        ApiResponse response = new ApiResponse();
        try {
            productoService.eliminarProducto(id);
            response.setMessage("Producto eliminado con éxito");
            response.setSuccess(Boolean.TRUE);
        } catch (Exception e) {
            log.error("Error al eliminar el producto: {}", e.getMessage());
            response.setMessage("Error al eliminar el producto");
            response.setSuccess(Boolean.FALSE);
        }
        return response;
    }
}
