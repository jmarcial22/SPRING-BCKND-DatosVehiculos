package baq.transito.ConsultaVehiculos.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "REC_USERS")
public class RecUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTRASENA")
    private String contrasena;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String prenom;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROFILE")
    private String profile;

    @Lob
    @Column(name = "FIRMA")
    private Serializable firma;
    @Size(max = 90)
    @Column(name = "CARGO")
    private String cargo;
    @Size(max = 50)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 1)
    @Column(name = "ACTIVO")
    private String activo;
    @Column(name = "LAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "NEXT_PASSWORD_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextPasswordChange;


    public RecUsers() {
    }

    public RecUsers(String usuario) {
        this.usuario = usuario;
    }

    public RecUsers(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario.toUpperCase();
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecUsers)) {
            return false;
        }
        RecUsers other = (RecUsers) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    public Serializable getFirma() {
        return firma;
    }

    public void setFirma(Serializable firma) {
        this.firma = firma;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getNextPasswordChange() {
        return nextPasswordChange;
    }

    public void setNextPasswordChange(Date nextPasswordChange) {
        this.nextPasswordChange = nextPasswordChange;
    }




    @Override
    public String toString() {
        return "recaudo.controllers.RecUsers[ usuario=" + usuario + " ]";
    }

}
