package com.example.proyecto2ev_psp.controller;

import com.example.proyecto2ev_psp.model.Cliente;
import com.example.proyecto2ev_psp.model.Result;
import com.example.proyecto2ev_psp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(new Result.Success<>(clienteService.getAll()));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(new Result.Success<>(clienteService.getById(id)));
        } catch (Exception e) {
            return ResponseEntity.ok(new Result.Error<>(e.getMessage()));
        }
    }

    @PostMapping
    private ResponseEntity<?> addCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    @PutMapping
    private ResponseEntity<?> updateCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteCliente(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(new Result.Success<>(clienteService.deleteCliente(id)));
        } catch (Exception e) {
            return ResponseEntity.ok(new Result.Error<>(e.getMessage()));
        }
    }
}
