package com.example.proyecto2ev_psp.service;

import com.example.proyecto2ev_psp.ConfigProperties;
import com.example.proyecto2ev_psp.model.Cliente;
import com.example.proyecto2ev_psp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ConfigProperties configProperties;

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }
    public Cliente getById(Long id){
        return clienteRepository.getById(id);
    }
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Cliente deleteCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        clienteRepository.delete(cliente);
        return cliente;
    }
}
