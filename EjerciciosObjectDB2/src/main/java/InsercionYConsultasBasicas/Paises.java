/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsercionYConsultasBasicas;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author lucas
 */
@Entity
public class Paises implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private int idPais;
    private String nombrepais;

    public Paises(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    public Paises(int idPais, String nombrepais) {
        this.idPais = idPais;
        this.nombrepais = nombrepais;
    }
    
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    @Override
    public String toString() {
        return "Paises{" + "nombrepais=" + nombrepais + '}';
    }
    
}
