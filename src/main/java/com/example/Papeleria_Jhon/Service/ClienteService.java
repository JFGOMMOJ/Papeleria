package com.example.Papeleria_Jhon.Service;

import com.example.Papeleria_Jhon.Model.Cliente;
import com.example.Papeleria_Jhon.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener cliente por ID
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    // Crear o actualizar cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente por ID
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

}
