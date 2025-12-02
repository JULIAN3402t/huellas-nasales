package com.jdc.misegundaapi.Services;

import com.jdc.misegundaapi.entity.CanesEntity;
import com.jdc.misegundaapi.entity.CiudadesEntity;

import java.util.List;

public interface CiudadesService {
    public List<CiudadesEntity> findAll();
    public CiudadesEntity findById(Long id);
    public CiudadesEntity save(CiudadesEntity ciudades);
    public void deleteByIdCiudad(Long id);
}
