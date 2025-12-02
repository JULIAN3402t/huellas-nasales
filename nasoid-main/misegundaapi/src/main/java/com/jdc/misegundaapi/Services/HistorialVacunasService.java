package com.jdc.misegundaapi.Services;

import com.jdc.misegundaapi.entity.CiudadesEntity;
import com.jdc.misegundaapi.entity.HistorialVacunasEntity;

import java.util.List;

public interface HistorialVacunasService {
    public List<HistorialVacunasEntity> findAll();
    public HistorialVacunasEntity findById(Long id);
    public HistorialVacunasEntity save(HistorialVacunasEntity historialVacunas);

    public void deleteByIdHistorial(Long id);
}
