package com.jdc.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import com.jdc.misegundaapi.enums.Sexo;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "canes")
public class CanesEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerro")
    private Long idPerro;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "codigo", nullable = false, length = 50)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;

    @Column(name = "peso_actual", nullable = false)
    private Double pesoActual;

    @Column(name = "esterilizado", nullable = false)
    private Boolean esterilizado;

    @Lob
    @Column(name = "imagen_sc", columnDefinition = "LONGBLOB")
    private byte[] imagenSc;

    @Column(name = "datos_sc", nullable = false, length = 500)
    private String datosSc;

    @Column(name = "estado",nullable = false)
    private Boolean estado;

    // ✅ ÚNICA RELACIÓN: Canes → Razas
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_raza", referencedColumnName = "idRaza", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonProperty("raza")  // ✅ Cambié el nombre para que sea más claro
    private RazasEntity raza;

    // Constructor vacío (requerido por JPA)
    public CanesEntity() {
    }

    // Getters y Setters
    public Long getIdPerro() {
        return idPerro;
    }

    public void setIdPerro(Long idPerro) {
        this.idPerro = idPerro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Boolean getEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(Boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public byte[] getImagenSc() {
        return imagenSc;
    }

    public void setImagenSc(byte[] imagenSc) {
        this.imagenSc = imagenSc;
    }

    public String getDatosSc() {
        return datosSc;
    }

    public void setDatosSc(String datosSc) {
        this.datosSc = datosSc;
    }

    // ✅ Getter/Setter para la relación con Raza
    public RazasEntity getRaza() {
        return raza;
    }

    public void setRaza(RazasEntity raza) {
        this.raza = raza;
    }
}