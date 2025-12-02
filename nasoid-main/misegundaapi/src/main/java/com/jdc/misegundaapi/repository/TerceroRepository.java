package com.jdc.misegundaapi.repository;

import com.jdc.misegundaapi.entity.TerceroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerceroRepository extends JpaRepository<TerceroEntity, Long> {

    @Query("SELECT ter FROM TerceroEntity ter WHERE ter.rol = 1")
    List<TerceroEntity> findAllByRolAdmin();

    @Query("SELECT ter FROM TerceroEntity ter WHERE ter.rol = 2")
    List<TerceroEntity> findAllByRolPersonal();
}
