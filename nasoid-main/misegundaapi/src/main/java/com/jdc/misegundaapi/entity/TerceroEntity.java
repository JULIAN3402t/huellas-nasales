package com.jdc.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tercero")
public class TerceroEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id // ✅ Importar esta de jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtercero")
    private Long idtercero;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "primer_apellido", nullable = false, length = 50)
    private String primer_apellido;

    @Column(name = "segundo_apellido", nullable = false, length = 50)
    private String segundo_apellido;

    @Column(name = "documento", nullable = false, length = 25, unique = true)
    private String documento;

    @Column(name = "tipo_documento", nullable = false)
    private Integer tipodocumento;

    @Column(name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 20)
    private String direccion;

    @Column(name = "rol", nullable = false)
    private Integer rol;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
    @Column(name = "fecha_creacion", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_creacion;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkalcaldia", referencedColumnName = "idalcaldia", nullable = false)
    private AlcaldiasEntity alcaldiasEntity;


    public Long getIdtercero() {
        return idtercero;


    }

    public void setIdtercero(Long idtercero) {
        this.idtercero = idtercero;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Integer tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }



    public AlcaldiasEntity getAlcaldiasEntity() {
        return alcaldiasEntity;
    }

    public void setAlcaldiasEntity(AlcaldiasEntity alcaldiasEntity) {
        this.alcaldiasEntity = alcaldiasEntity;
    }
}

