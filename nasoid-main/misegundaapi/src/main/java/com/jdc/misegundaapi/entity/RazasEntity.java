package com.jdc.misegundaapi.entity;

import com.jdc.misegundaapi.enums.Sexo;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.jdc.misegundaapi.enums.Tamanio;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Razas")
public class RazasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRaza",nullable = false)
    private Long idRaza;

    @Column(name = "nombre",nullable = false,length = 200)
    private String nombre;

    @Column(name = "color",nullable = false,length = 50)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamanio")
    private Tamanio tamanio;

    @Column(name = "peso_promedio",nullable = false)
    private Double peso_promedio;

    @Column(name = "caracteristica",nullable = false,length = 200)
    private String caracteristica;

    @Column(name = "fecha_creacion", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_creacion;

    @Column(name = "estado",nullable = false)
    private Boolean estado;

    public Long getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Long idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }

    public void setTamanio(Tamanio tamanio) {
        this.tamanio = tamanio;

    }

    public Double getPeso_promedio() {
        return peso_promedio;
    }

    public void setPeso_promedio(Double peso_promedio) {
        this.peso_promedio = peso_promedio;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
