package com.example.Papeleria_Jhon.Repository;

import com.example.Papeleria_Jhon.Model.Producto;
import com.example.Papeleria_Jhon.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Query(value = "SELECT p.* FROM producto p INNER JOIN proveedor pr ON p.id_proveedor = pr.id_proveedor WHERE pr.id_proveedor = :idProveedor", nativeQuery = true)
    List<Producto> listarProductosPorProveedor(@Param("idProveedor") Integer idProveedor);

}
