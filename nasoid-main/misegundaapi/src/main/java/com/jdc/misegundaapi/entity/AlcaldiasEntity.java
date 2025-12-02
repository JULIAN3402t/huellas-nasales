package com.jdc.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "alcaldias")
//@Getter
//@Setter

public class AlcaldiasEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalcaldia")
    private Long idalcaldia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_creacion", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "estado",nullable = false)
    private Boolean estado;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkciudad", referencedColumnName = "idciudad", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JsonProperty("fkciudad")
    private  CiudadesEntity ciudadesEntity;

    public Long getIdalcaldia() {
        return idalcaldia;
    }

    public void setIdalcaldia(Long idalcaldia) {
        this.idalcaldia = idalcaldia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CiudadesEntity getCiudadesEntity() {
        return ciudadesEntity;
    }

    public void setCiudadesEntity(CiudadesEntity ciudadesEntity) {
        this.ciudadesEntity = ciudadesEntity;
    }
}
