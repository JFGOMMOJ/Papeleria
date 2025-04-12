package com.example.Papeleria_Jhon.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;

    private LocalDate fecha;

    // Relación con Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Relación con Empleado
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    // Relación con DetalleVenta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<Detalle_venta> detalles;

    public Venta() {
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Detalle_venta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle_venta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id_venta=" + id_venta +
                ", fecha=" + fecha +
                ", cliente=" + (cliente != null ? cliente.getId_cliente() : null) +
                ", empleado=" + (empleado != null ? empleado.getId_empleado() : null) +
                '}';
    }
}
