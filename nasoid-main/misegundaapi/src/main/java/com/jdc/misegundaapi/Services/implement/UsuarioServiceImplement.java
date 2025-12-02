package com.jdc.misegundaapi.Services.implement;


import com.jdc.misegundaapi.entity.UsuarioEntity;
import com.jdc.misegundaapi.repository.UsuarioRepository;
import com.jdc.misegundaapi.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    @Transactional(readOnly = true)
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioEntity findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void deleteByIdUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
