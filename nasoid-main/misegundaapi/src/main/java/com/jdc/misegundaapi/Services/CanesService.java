package com.jdc.misegundaapi.Services;


import com.jdc.misegundaapi.entity.CanesEntity;

import java.util.List;

public interface CanesService {
    public List<CanesEntity> findAll();
    public CanesEntity findById(Long id);
    public CanesEntity save(CanesEntity canes);

    public void deleteByIdCan(Long id);
}
