package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.Services.CanesService;
import com.jdc.misegundaapi.Services.CiudadesService;
import com.jdc.misegundaapi.entity.CanesEntity;
import com.jdc.misegundaapi.entity.CiudadesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/ciudades")
public class CiudadesRest {


    @Autowired
    private CiudadesService ciudadesService;



    @GetMapping("/listarByCiudades")
    private ResponseEntity<List<CiudadesEntity>> listarByCiudad() {
        return ResponseEntity.ok(ciudadesService.findAll());
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity<CiudadesEntity> listarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ciudadesService.findById(id));
    }

    @PostMapping("/crear")
    private ResponseEntity<?> guardar(@Validated @RequestBody CiudadesEntity ciudadesEntity) {
        try {
            ciudadesEntity.setEstado(true);

            // El service se encarga de manejar las relaciones
            CiudadesEntity CiudadGuardado = ciudadesService.save(ciudadesEntity);
            return ResponseEntity.ok(CiudadGuardado);

        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteBy/{id}")
    private ResponseEntity<CiudadesEntity> deleteById(@PathVariable("id") Long id) {
        CiudadesEntity ciudades = ciudadesService.findById(id);
        ciudadesService.deleteByIdCiudad(id);
        return ResponseEntity.ok(ciudades);
    }
}
