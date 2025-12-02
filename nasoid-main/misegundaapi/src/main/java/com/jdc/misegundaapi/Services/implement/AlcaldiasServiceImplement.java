package com.jdc.misegundaapi.Services.implement;

import com.jdc.misegundaapi.Services.AlcaldiasService;
import com.jdc.misegundaapi.entity.AlcaldiasEntity;
import com.jdc.misegundaapi.entity.RazasEntity;
import com.jdc.misegundaapi.repository.AlcaldiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlcaldiasServiceImplement implements AlcaldiasService {

    @Autowired
    private AlcaldiasRepository alcaldiasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AlcaldiasEntity> findAll() {
        return alcaldiasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AlcaldiasEntity findById(Long id) {
        return alcaldiasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public AlcaldiasEntity save(AlcaldiasEntity alcaldiasEntity) {
        return alcaldiasRepository.save(alcaldiasEntity);
    }

    @Override
    @Transactional
    public void deleteByIdAlcaldia(Long id) {
        alcaldiasRepository.deleteById(id);
    }
}
