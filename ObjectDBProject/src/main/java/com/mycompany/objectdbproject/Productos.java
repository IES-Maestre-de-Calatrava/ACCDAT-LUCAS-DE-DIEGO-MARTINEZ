/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdbproject;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;



/**
 *
 * @author b15-20m
 */
@Entity
public class Productos implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private int idproducto;
    private String nombre;
    private int precio;
    @OneToOne(mappedBy = "idproducto", orphanRemoval = true)
    private Pedidos pedido;

    public Productos() {
    }
    public Productos(int idproducto) {
        this.idproducto = idproducto;
    }

    public Productos(int idproducto, String nombre, int precio) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
    }
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
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
        final Productos other = (Productos) obj;
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.precio != other.precio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.pedido, other.pedido);
    }
    
    
    
    
}


