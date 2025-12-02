package com.jdc.misegundaapi.Services;

import com.jdc.misegundaapi.entity.RazasEntity;
import com.jdc.misegundaapi.entity.TerceroEntity;

import java.util.List;

public interface TerceroService {
    public List<TerceroEntity> findAll();

    TerceroEntity findById(Long id);
    public TerceroEntity save(TerceroEntity tercero);
    void deleteById(Long id); // nombre estándar
    List<TerceroEntity> findAllByRolPersonal();
    List<TerceroEntity> findAllByRolAdmin();

}
