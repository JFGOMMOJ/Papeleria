package com.example.Papeleria_Jhon.Model;

import jakarta.persistence.*;

@Entity
public class Detalle_venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle;

    private Integer cantidad;
    private double precio_unitario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    public Detalle_venta() {
    }

    public Integer getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(Integer id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Detalle_venta{" +
                "id_detalle=" + id_detalle +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                ", producto=" + (producto != null ? producto.getId_producto() : null) +
                ", venta=" + (venta != null ? venta.getId_venta() : null) +
                '}';
    }
}
