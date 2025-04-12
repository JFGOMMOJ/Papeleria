package com.example.Papeleria_Jhon.Controller;

import com.example.Papeleria_Jhon.Model.Proveedor;
import com.example.Papeleria_Jhon.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        List<Proveedor> proveedores = proveedorService.getAllProveedores();
        if (proveedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Integer id) {
        Optional<Proveedor> proveedor = proveedorService.getProveedorById(id);
        return proveedor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/saveProveedor")
    public ResponseEntity<Proveedor> saveProveedor(@RequestBody Proveedor proveedor) {
        try {
            Proveedor savedProveedor = proveedorService.saveProveedor(proveedor);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProveedor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteProveedor/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id) {
        Optional<Proveedor> proveedor = proveedorService.getProveedorById(id);
        if (proveedor.isPresent()) {
            proveedorService.deleteProveedor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
