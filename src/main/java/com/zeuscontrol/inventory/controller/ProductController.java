package com.zeuscontrol.inventory.controller;

import com.zeuscontrol.inventory.model.Product;
import com.zeuscontrol.inventory.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Operation(summary = "Obtener todos los productos", description = "Recupera una lista de todos los productos disponibles")
    @ApiResponse(responseCode = "200", description = "Lista de productos recuperada con éxito")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @Operation(summary = "Obtener producto por ID", description = "Recupera un producto utilizando su ID")
    @ApiResponse(responseCode = "200", description = "Producto recuperado con éxito")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @Operation(summary = "Crear un nuevo producto", description = "Agrega un nuevo producto al inventario")
    @ApiResponse(responseCode = "201", description = "Producto creado con éxito")
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @Operation(summary = "Actualizar un producto existente", description = "Actualiza los detalles de un producto utilizando su ID")
    @ApiResponse(responseCode = "200", description = "Producto actualizado con éxito")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto utilizando su ID")
    @ApiResponse(responseCode = "204", description = "Producto eliminado con éxito")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
