package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.Services.UsuarioService;
import com.jdc.misegundaapi.entity.RazasEntity;
import com.jdc.misegundaapi.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioEntity>> listar() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<UsuarioEntity> listarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardar(@Validated @RequestBody UsuarioEntity usuarioEntity) {
        try {
            usuarioEntity.setEstado(true);
            usuarioEntity.setFechaCreacion(LocalDate.now());

            UsuarioEntity usuario = usuarioService.save(usuarioEntity);
            return ResponseEntity.ok(usuario);

        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<UsuarioEntity> deleteById(@PathVariable("id") Long id) {
        UsuarioEntity usuario = usuarioService.findById(id);
        usuarioService.deleteByIdUsuario(id);
        return ResponseEntity.ok(usuario);
    }


}
