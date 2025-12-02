package com.jdc.misegundaapi.Services.implement;

import com.jdc.misegundaapi.Services.RazasService;
import com.jdc.misegundaapi.entity.RazasEntity;
import com.jdc.misegundaapi.repository.RazasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RazasServiceImplement implements RazasService {

    @Autowired
    private RazasRepository razaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RazasEntity> findAll() {
        return razaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RazasEntity findById(Long id) {
        return razaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public RazasEntity save(RazasEntity raza) {
        return razaRepository.save(raza);
    }
    @Override
    @Transactional
    public void deleteByIdRaza(Long id) {
        razaRepository.deleteById(id);
    }
}
