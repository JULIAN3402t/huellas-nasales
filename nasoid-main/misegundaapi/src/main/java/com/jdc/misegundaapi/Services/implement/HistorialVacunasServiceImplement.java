package com.jdc.misegundaapi.Services.implement;

import com.jdc.misegundaapi.Services.HistorialVacunasService;
import com.jdc.misegundaapi.entity.HistorialVacunasEntity;
import com.jdc.misegundaapi.repository.HistorialVacunasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistorialVacunasServiceImplement implements HistorialVacunasService {

    @Autowired
    private HistorialVacunasRepository historialVacunasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<HistorialVacunasEntity> findAll() {
        return historialVacunasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public HistorialVacunasEntity findById(Long id) {
        return historialVacunasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public HistorialVacunasEntity save(HistorialVacunasEntity historial) {
         return historialVacunasRepository.save(historial);
    }

    @Override
    @Transactional
    public void deleteByIdHistorial(Long id) {
        historialVacunasRepository.deleteById(id);
    }
}
