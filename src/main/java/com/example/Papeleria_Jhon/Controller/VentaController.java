package com.example.Papeleria_Jhon.Controller;

import com.example.Papeleria_Jhon.Model.Venta;
import com.example.Papeleria_Jhon.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Obtener todas las ventas
    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.getAllVentas();
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ventas);
    }

    // Obtener venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Integer id) {
        return ventaService.getVentaById(id)
                .map(venta -> ResponseEntity.ok().body(venta))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nueva venta
    @PostMapping ("/saveVenta")
    public ResponseEntity<Venta> saveVenta(@RequestBody Venta venta) {
        try {
            Venta savedVenta = ventaService.saveVenta(venta);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVenta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Actualizar venta
    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        return ventaService.getVentaById(id).map(existing -> {
            venta.setId_venta(id);
            Venta updated = ventaService.saveVenta(venta);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        return ventaService.getVentaById(id).map(venta -> {
            ventaService.deleteVenta(id);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }

    // obtenerVentasPorEmpleado
    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<List<Venta>> getVentasPorEmpleado(@PathVariable Integer idEmpleado) {
        List<Venta> ventas = ventaService.obtenerVentasPorEmpleado(idEmpleado);
        return ResponseEntity.ok(ventas);
    }
}
