package com.mycompany.objectdbproject;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author b15-20m
 */
@Entity
@NamedQueries({
   @NamedQuery(name="Usuarios.findAll",
           query = "select from Usuarios"),
    @NamedQuery(name="Usuarios.findById",
           query = "select from Usuarios where idusuario =:IDUSUARIOP"),
})
public class Usuarios implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    @Id @GeneratedValue
    private int idusuario;
    
    private String nombre;
    
    private String contra;
    @OneToMany(mappedBy = "idusuario", orphanRemoval=true)
    private List<Pedidos> pedidosCollection;
    
    public Usuarios(){
        
    }
    public Usuarios(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
    }
    public Usuarios(int idusuario, String nombre, String contra) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.contra = contra;
    }
    public Usuarios(int idusuario, String nombre, String contra, List<Pedidos> pedidosCollection) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.contra = contra;
        this.pedidosCollection = pedidosCollection;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public List<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(List<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuarios other = (Usuarios) obj;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.contra, other.contra);
    }
    
    
}
