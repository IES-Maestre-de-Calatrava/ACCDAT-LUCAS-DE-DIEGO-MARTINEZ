package com.mycompany.objectdbproject;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author b15-20m
 */
@Entity
public class Pedidos implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private int idpedido;
    private int precioTotal;
    private Date fechaEntrega;
    @JoinColumn(name="idproducto", referencedColumnName="idproducto")
    @OneToOne
    private Productos idproducto;
    @JoinColumn (name="idusuario", referencedColumnName="idusuario")
    @ManyToOne
    private Usuarios idusuario;
    public Pedidos() {
    }

    public Pedidos(int idpedido) {
        this.idpedido = idpedido;
    }

    public Pedidos(int precioTotal, Date fechaEntrega, Productos idproducto, Usuarios idusuario) {
        this.precioTotal = precioTotal;
        this.fechaEntrega = fechaEntrega;
        this.idproducto = idproducto;
        this.idusuario = idusuario;
    }

    public Pedidos(int idpedido, int precioTotal, Date fechaEntrega, Productos idproducto, Usuarios idusuario) {
        this.idpedido = idpedido;
        this.precioTotal = precioTotal;
        this.fechaEntrega = fechaEntrega;
        this.idproducto = idproducto;
        this.idusuario = idusuario;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Productos getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Productos idproducto) {
        this.idproducto = idproducto;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Pedidos other = (Pedidos) obj;
        if (this.idpedido != other.idpedido) {
            return false;
        }
        if (this.precioTotal != other.precioTotal) {
            return false;
        }
        if (!Objects.equals(this.fechaEntrega, other.fechaEntrega)) {
            return false;
        }
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        return Objects.equals(this.idusuario, other.idusuario);
    }

    @Override
    public String toString() {
        return "Pedidos{" + "idpedido=" + idpedido + ", precioTotal=" + precioTotal + ", fechaEntrega=" + fechaEntrega + ", idproducto=" + idproducto + ", idusuario=" + idusuario + '}';
    }
}
