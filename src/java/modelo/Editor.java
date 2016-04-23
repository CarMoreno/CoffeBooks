/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Entity
@Table(name = "editor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editor.findAll", query = "SELECT e FROM Editor e"),
    @NamedQuery(name = "Editor.findByIdEditor", query = "SELECT e FROM Editor e WHERE e.idEditor = :idEditor"),
    @NamedQuery(name = "Editor.findByNombre", query = "SELECT e FROM Editor e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Editor.findByCiudad", query = "SELECT e FROM Editor e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Editor.findByEstado", query = "SELECT e FROM Editor e WHERE e.estado = :estado"),
    @NamedQuery(name = "Editor.findByPais", query = "SELECT e FROM Editor e WHERE e.pais = :pais"),
    @NamedQuery(name = "Editor.findByDomicilio", query = "SELECT e FROM Editor e WHERE e.domicilio = :domicilio"),
    @NamedQuery(name = "Editor.findByWebsite", query = "SELECT e FROM Editor e WHERE e.website = :website")})
public class Editor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEditor")
    private Integer idEditor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "domicilio")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "website")
    private String website;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEditor")
    private List<Libro> libroList;

    public Editor() {
    }

    public Editor(Integer idEditor) {
        this.idEditor = idEditor;
    }

    public Editor(Integer idEditor, String nombre, String ciudad, String estado, String pais, String domicilio, String website) {
        this.idEditor = idEditor;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.domicilio = domicilio;
        this.website = website;
    }

    public Integer getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(Integer idEditor) {
        this.idEditor = idEditor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditor != null ? idEditor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editor)) {
            return false;
        }
        Editor other = (Editor) object;
        if ((this.idEditor == null && other.idEditor != null) || (this.idEditor != null && !this.idEditor.equals(other.idEditor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Editor[ idEditor=" + idEditor + " ]";
    }
    
}
