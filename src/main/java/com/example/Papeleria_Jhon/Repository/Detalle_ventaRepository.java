package com.example.Papeleria_Jhon.Repository;

import com.example.Papeleria_Jhon.Model.Detalle_venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_ventaRepository extends JpaRepository<Detalle_venta, Integer> {

}
