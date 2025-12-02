package com.jdc.misegundaapi.Services;

import com.jdc.misegundaapi.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioEntity> findAll();
    public UsuarioEntity findById(Long id);
    public UsuarioEntity save(UsuarioEntity usuario);
    public void deleteByIdUsuario(Long id);
}
