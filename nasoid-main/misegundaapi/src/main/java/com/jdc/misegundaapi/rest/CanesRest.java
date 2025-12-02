package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.entity.CanesEntity;
import com.jdc.misegundaapi.Services.CanesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/canes")
public class CanesRest {

    @Autowired
    private CanesService canesService;

    @GetMapping("/listar")
    private ResponseEntity<List<CanesEntity>> listar() {
        return ResponseEntity.ok(canesService.findAll());
    }

    @GetMapping("/listarByCanes")
    private ResponseEntity<List<CanesEntity>> listarByPedido() {
        return ResponseEntity.ok(canesService.findAll());
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity<CanesEntity> listarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(canesService.findById(id));
    }

    @PostMapping("/crear")
    private ResponseEntity<?> guardar(@Validated @RequestBody CanesEntity canesEntity) {
        try {
            canesEntity.setEstado(true);

            // El service se encarga de manejar las relaciones
            CanesEntity CanGuardado = canesService.save(canesEntity);
            return ResponseEntity.ok(CanGuardado);

        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteBy/{id}")
    private ResponseEntity<CanesEntity> deleteById(@PathVariable("id") Long id) {
        CanesEntity canes = canesService.findById(id);
        canesService.deleteByIdCan(id);
        return ResponseEntity.ok(canes);
    }
}
