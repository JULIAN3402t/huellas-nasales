package com.jdc.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "historialvacunas")
public class HistorialVacunasEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorialVacuna")
    private long idHistorialVacuna;

    @Column(name = "tipo_vacuna",nullable = false,length = 100)
    private String tipoVacuna;

    @Column(name = "fecha_aplicacion", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_aplicacion;

    @Column(name = "proxima_dosis", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date proxima_dosis;

    @Column(name = "lote_vacuna",nullable = false,length = 50)
    private String loteVacuna;

    @Column(name = "veterinario",nullable = false,length = 100)
    private String veterinario;

    @Column(name = "observaciones",nullable = false,length = 200)
    private String observaciones;

    @Column(name = "fecha_registro", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_registro;

    @Column(name = "estado",nullable = false)
    private Boolean estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPerro", nullable = false)
    private CanesEntity canesEntity;



    public long getIdHistorialVacuna() {
        return idHistorialVacuna;
    }

    public void setIdHistorialVacuna(long idHistorialVacuna) {
        this.idHistorialVacuna = idHistorialVacuna;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public Date getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(Date fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public Date getProxima_dosis() {
        return proxima_dosis;
    }

    public void setProxima_dosis(Date proxima_dosis) {
        this.proxima_dosis = proxima_dosis;
    }

    public String getLoteVacuna() {
        return loteVacuna;
    }

    public void setLoteVacuna(String loteVacuna) {
        this.loteVacuna = loteVacuna;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public CanesEntity getCanesEntity() {
        return canesEntity;
    }

    public void setCanesEntity(CanesEntity canesEntity) {
        this.canesEntity = canesEntity;
    }
}
