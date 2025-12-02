package com.jdc.misegundaapi.Services.implement;

import com.jdc.misegundaapi.Services.TerceroService;
import com.jdc.misegundaapi.entity.CiudadesEntity;
import com.jdc.misegundaapi.entity.TerceroEntity;
import com.jdc.misegundaapi.repository.TerceroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TerceroServiceImplement implements TerceroService {

    private final TerceroRepository terceroRepository;

    @Autowired
    public TerceroServiceImplement(TerceroRepository terceroRepository) {
        this.terceroRepository = terceroRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TerceroEntity> findAll() {
        return terceroRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public TerceroEntity findById(Long id) {
        return terceroRepository.findById(id).orElse(null);
    }



    @Override
    @Transactional
    public TerceroEntity save(TerceroEntity tercero) {
        return terceroRepository.save(tercero);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        if (terceroRepository.existsById(id)) {
            terceroRepository.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TerceroEntity> findAllByRolPersonal() {
        return terceroRepository.findAllByRolPersonal();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TerceroEntity> findAllByRolAdmin() {
        return terceroRepository.findAllByRolAdmin();
    }
}
