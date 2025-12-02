package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.Services.AlcaldiasService;
import com.jdc.misegundaapi.entity.AlcaldiasEntity;
import com.jdc.misegundaapi.entity.CanesEntity;
import com.jdc.misegundaapi.repository.AlcaldiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alcaldias")
public class AlcaldiasRest {

    @Autowired
    private AlcaldiasService alcaldiasService;




    @PostMapping("/crear")
    private ResponseEntity<?> guardar(@Validated @RequestBody AlcaldiasEntity alcaldiasEntity) {
        try{
            alcaldiasEntity.setEstado(true);

            AlcaldiasEntity alcaldiasave = alcaldiasService.save(alcaldiasEntity);
            return ResponseEntity.ok(alcaldiasave);

        }catch (Exception e){
            System.out.println("El error es :"+ e.getMessage());
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }
}
