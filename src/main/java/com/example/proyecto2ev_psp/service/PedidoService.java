package com.example.proyecto2ev_psp.service;

import com.example.proyecto2ev_psp.ConfigProperties;
import com.example.proyecto2ev_psp.model.Cliente;
import com.example.proyecto2ev_psp.model.Pedido;
import com.example.proyecto2ev_psp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ConfigProperties configProperties;

    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }
    public Pedido getById(Long id){
        return pedidoRepository.getById(id);
    }
    public List<Pedido> getByCliente(Cliente cliente){
        return pedidoRepository.getAllByCliente(cliente);
    }
    public Pedido savePedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public Pedido deletePedido(Long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedidoRepository.delete(pedido);
        return pedido;
    }
}
