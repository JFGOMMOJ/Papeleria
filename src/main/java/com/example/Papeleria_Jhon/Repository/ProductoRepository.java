package com.example.Papeleria_Jhon.Repository;

import com.example.Papeleria_Jhon.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
