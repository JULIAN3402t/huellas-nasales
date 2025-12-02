package com.jdc.misegundaapi.Services.implement;

import com.jdc.misegundaapi.Services.CiudadesService;
import com.jdc.misegundaapi.entity.CanesEntity;
import com.jdc.misegundaapi.entity.CiudadesEntity;
import com.jdc.misegundaapi.repository.CiudadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CiudadesServiceImplement implements CiudadesService {

    @Autowired
    private CiudadesRepository ciudadesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CiudadesEntity> findAll() {
        return ciudadesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CiudadesEntity findById(Long id) {
        return ciudadesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CiudadesEntity save(CiudadesEntity ciudad) {
        return ciudadesRepository.save(ciudad);
    }



    @Override
    @Transactional
    public void deleteByIdCiudad(Long id) {
        ciudadesRepository.deleteById(id);
    }
}
