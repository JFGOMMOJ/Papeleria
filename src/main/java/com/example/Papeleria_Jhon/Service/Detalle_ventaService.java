package com.example.Papeleria_Jhon.Service;

import com.example.Papeleria_Jhon.Model.Detalle_venta;
import com.example.Papeleria_Jhon.Repository.Detalle_ventaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Detalle_ventaService {

    @Autowired
    private Detalle_ventaRepository Detalle_ventaRepository;

    // Listar todos los detalles de venta
    public List<Detalle_venta> getAllDetallesVenta() {
        return Detalle_ventaRepository.findAll();
    }

    // Obtener un detalle de venta por ID
    public Optional<Detalle_venta> getDetalleVentaById(Integer id) {
        return Detalle_ventaRepository.findById(id);
    }

    // Guardar o actualizar un detalle de venta
    public Detalle_venta saveDetalleVenta(Detalle_venta detalleVenta) {
        return Detalle_ventaRepository.save(detalleVenta);
    }

    // Eliminar un detalle de venta por ID
    public void deleteDetalleVenta(Integer id) {
        Detalle_ventaRepository.deleteById(id);
    }
}
