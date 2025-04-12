package com.example.Papeleria_Jhon.Service;

import com.example.Papeleria_Jhon.Model.Producto;
import com.example.Papeleria_Jhon.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<Producto> getProductoById(Integer id) {
        return productoRepository.findById(id);
    }

    // Guardar o actualizar un producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar un producto por ID
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}
