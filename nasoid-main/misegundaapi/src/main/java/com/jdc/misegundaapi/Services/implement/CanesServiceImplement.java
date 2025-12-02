package com.jdc.misegundaapi.Services.implement;

import com.jdc.misegundaapi.Services.CanesService;
import com.jdc.misegundaapi.entity.CanesEntity;
import com.jdc.misegundaapi.repository.CanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CanesServiceImplement implements CanesService {

    @Autowired
    private CanesRepository canesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CanesEntity> findAll() {
        return canesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CanesEntity findById(Long id) {
        return canesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CanesEntity save(CanesEntity canes) {
        return canesRepository.save(canes);
    }


    @Override
    @Transactional
    public void deleteByIdCan(Long id) {
        if (canesRepository.existsById(id)) {
            canesRepository.deleteById(id);
        }
    }
}
