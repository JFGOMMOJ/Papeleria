package com.example.Papeleria_Jhon.Service;

import com.example.Papeleria_Jhon.Model.Venta;
import com.example.Papeleria_Jhon.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Listar todas las ventas
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    // Buscar una venta por ID
    public Optional<Venta> getVentaById(Integer id) {
        return ventaRepository.findById(id);
    }

    // Guardar o actualizar una venta
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Eliminar una venta por ID
    public void deleteVenta(Integer id) {
        ventaRepository.deleteById(id);
    }

    //Obtener ventas por empleado
    public List<Venta> obtenerVentasPorEmpleado(Integer idEmpleado) {
        return ventaRepository.listarVentasPorEmpleado(idEmpleado);
    }
}
