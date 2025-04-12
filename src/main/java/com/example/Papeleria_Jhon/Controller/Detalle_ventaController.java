package com.example.Papeleria_Jhon.Controller;

import com.example.Papeleria_Jhon.Model.Detalle_venta;
import com.example.Papeleria_Jhon.Service.Detalle_ventaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle_venta")
public class Detalle_ventaController {

    @Autowired
    private Detalle_ventaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<Detalle_venta>> getAllDetallesVenta() {
        List<Detalle_venta> detalles = detalleVentaService.getAllDetallesVenta();
        if (detalles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle_venta> getDetalleVentaById(@PathVariable Integer id) {
        Optional<Detalle_venta> detalle = detalleVentaService.getDetalleVentaById(id);
        return detalle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{saveDetalleVenta}")
    public ResponseEntity<Detalle_venta> saveDetalleVenta(@RequestBody Detalle_venta detalle) {
        try {
            Detalle_venta savedDetalle = detalleVentaService.saveDetalleVenta(detalle);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDetalle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable Integer id) {
        Optional<Detalle_venta> detalle = detalleVentaService.getDetalleVentaById(id);
        if (detalle.isPresent()) {
            detalleVentaService.deleteDetalleVenta(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
