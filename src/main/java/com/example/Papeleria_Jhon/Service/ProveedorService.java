package com.example.Papeleria_Jhon.Service;

import com.example.Papeleria_Jhon.Model.Proveedor;
import com.example.Papeleria_Jhon.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    // Obtener proveedor por ID
    public Optional<Proveedor> getProveedorById(Integer id) {
        return proveedorRepository.findById(id);
    }

    // Guardar o actualizar proveedor
    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Eliminar proveedor por ID
    public void deleteProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
