package com.example.proyecto2ev_psp.controller;

import com.example.proyecto2ev_psp.model.Cliente;
import com.example.proyecto2ev_psp.model.Pedido;
import com.example.proyecto2ev_psp.model.Result;
import com.example.proyecto2ev_psp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(new Result.Success<>(pedidoService.getAll()));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(new Result.Success<>(pedidoService.getById(id)));
        } catch (Exception e) {
            return ResponseEntity.ok(new Result.Error<>(e.getMessage()));
        }
    }

    @GetMapping("/byCliente")
    private ResponseEntity<?> getByCliente(@RequestBody Cliente cliente){
        try {
            return ResponseEntity.ok(new Result.Success<>(pedidoService.getByCliente(cliente)));
        } catch (Exception e) {
            return ResponseEntity.ok(new Result.Error<>(e.getMessage()));
        }
    }

    @PostMapping
    private ResponseEntity<?> addPedido(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.savePedido(pedido));
    }

    @PutMapping
    private ResponseEntity<?> updatePedido(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.savePedido(pedido));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePedido(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(new Result.Success<>(pedidoService.deletePedido(id)));
        } catch (Exception e) {
            return ResponseEntity.ok(new Result.Error<>(e.getMessage()));
        }
    }
}
