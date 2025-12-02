package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.entity.RazasEntity;
import com.jdc.misegundaapi.Services.RazasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/razas")
public class RazasRest {

    @Autowired
    private RazasService razasService;

    @GetMapping("/listar")
    public ResponseEntity<List<RazasEntity>> listar() {
        return ResponseEntity.ok(razasService.findAll());
    }

    @GetMapping("/listarByRazas")
    public ResponseEntity<List<RazasEntity>> listarByRazas() {
        return ResponseEntity.ok(razasService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<RazasEntity> listarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(razasService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardar(@Validated @RequestBody RazasEntity razasEntity) {
        try {
            razasEntity.setEstado(true);
            razasEntity.setFecha_creacion(LocalDate.now());

            RazasEntity razaGuardada = razasService.save(razasEntity);
            return ResponseEntity.ok(razaGuardada);

        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<RazasEntity> deleteById(@PathVariable("id") Long id) {
        RazasEntity raza = razasService.findById(id);
        razasService.deleteByIdRaza(id);
        return ResponseEntity.ok(raza);
    }
}