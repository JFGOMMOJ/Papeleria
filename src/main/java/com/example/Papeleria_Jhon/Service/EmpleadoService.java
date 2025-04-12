package com.example.Papeleria_Jhon.Service;

import com.example.Papeleria_Jhon.Model.Empleado;
import com.example.Papeleria_Jhon.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Obtener todos los empleados
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    // Obtener un empleado por ID
    public Optional<Empleado> getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id);
    }

    // Guardar o actualizar un empleado
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Eliminar un empleado
    public void deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
