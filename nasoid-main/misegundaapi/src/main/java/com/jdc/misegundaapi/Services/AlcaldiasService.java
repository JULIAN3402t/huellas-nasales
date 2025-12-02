package com.jdc.misegundaapi.Services;

import com.jdc.misegundaapi.entity.AlcaldiasEntity;
import com.jdc.misegundaapi.entity.CanesEntity;

import java.util.List;

public interface AlcaldiasService {
    public List<AlcaldiasEntity> findAll();
    public AlcaldiasEntity findById(Long id);
    public AlcaldiasEntity save(AlcaldiasEntity alcaldiasEntity);
    public void deleteByIdAlcaldia(Long id);
}
