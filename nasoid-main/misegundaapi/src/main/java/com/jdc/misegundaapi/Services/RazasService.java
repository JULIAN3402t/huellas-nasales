package com.jdc.misegundaapi.Services;

import com.jdc.misegundaapi.entity.RazasEntity;

import java.util.List;

public interface RazasService {
    public List<RazasEntity> findAll();
    public RazasEntity findById(Long id);
    public RazasEntity save(RazasEntity raza);
    public void deleteByIdRaza(Long id);
}
