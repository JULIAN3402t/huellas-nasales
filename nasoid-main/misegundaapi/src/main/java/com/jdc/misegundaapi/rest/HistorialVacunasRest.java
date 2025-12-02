package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.Services.HistorialVacunasService;
import com.jdc.misegundaapi.entity.AlcaldiasEntity;
import com.jdc.misegundaapi.entity.HistorialVacunasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historialVacunas")
public class HistorialVacunasRest {

    @Autowired
    private HistorialVacunasService historialVacunasService;


    @GetMapping("/listarByHistorialVacunas")
    private ResponseEntity<List<HistorialVacunasEntity>> findAll() {
        return ResponseEntity.ok(historialVacunasService.findAll());
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity<HistorialVacunasEntity> ListarById(@PathVariable ("id")Long id) {
        return ResponseEntity.ok(historialVacunasService.findById(id));
    }
    @PostMapping("/crear")
    private ResponseEntity<?> guardar(@Validated @RequestBody HistorialVacunasEntity historialVacunasEntity) {
        try{
            historialVacunasEntity.setEstado(true);

            HistorialVacunasEntity historialVacunas = historialVacunasService.save(historialVacunasEntity);
            return ResponseEntity.ok(historialVacunas);
        } catch (Exception e){
            System.out.println("El error es :"+e.getMessage());
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @DeleteMapping("/deleteBy/{id}")
    private ResponseEntity<HistorialVacunasEntity> deleteById(@PathVariable ("id") Long id) {
        HistorialVacunasEntity historialVacunas = historialVacunasService.findById(id);
        historialVacunasService.deleteByIdHistorial(id);
        return ResponseEntity.ok(historialVacunas);
    }

}
