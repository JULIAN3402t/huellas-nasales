package com.jdc.misegundaapi.repository;

import com.jdc.misegundaapi.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
