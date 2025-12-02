package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.Services.TerceroService;
import com.jdc.misegundaapi.entity.RazasEntity;
import com.jdc.misegundaapi.entity.TerceroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tercero")
public class TerceroRest {

    @Autowired
    private TerceroService terceroService;

    @GetMapping("/listar")
    public ResponseEntity<List<TerceroEntity>> listar() {
        return ResponseEntity.ok(terceroService.findAll());
    }

    @GetMapping("/listarByTercero")
    public ResponseEntity<List<TerceroEntity>> listarByTercero() {
        return ResponseEntity.ok(terceroService.findAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardar(@Validated @RequestBody TerceroEntity terceroEntity) {
        try {
            terceroEntity.setEstado(true);
            terceroEntity.setFecha_creacion(LocalDate.now());

            TerceroEntity tercero = terceroService.save(terceroEntity);
            return ResponseEntity.ok(tercero);

        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<TerceroEntity> deleteById(@PathVariable("id") Long id) {
        TerceroEntity tercero = terceroService.findById(id);
        terceroService.findAllByRolPersonal();
        terceroService.findAllByRolAdmin();
        return ResponseEntity.ok(tercero);
    }

}
