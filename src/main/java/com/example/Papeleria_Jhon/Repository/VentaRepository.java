package com.example.Papeleria_Jhon.Repository;

import com.example.Papeleria_Jhon.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = "SELECT v.* FROM venta v WHERE v.id_empleado = :idEmpleado", nativeQuery = true)
    List<Venta> listarVentasPorEmpleado(@Param("idEmpleado") Integer idEmpleado);
}

