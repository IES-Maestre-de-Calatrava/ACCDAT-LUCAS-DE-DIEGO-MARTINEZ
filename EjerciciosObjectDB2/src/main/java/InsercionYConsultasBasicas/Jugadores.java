/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsercionYConsultasBasicas;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author lucas
 */
public class Jugadores implements Serializable {
    
    @Id @GeneratedValue
    private static int idJugador;
    private Paises pais;

    public Jugadores(Paises pais) {
        this.pais = pais;
    }

    public static int getIdJugador() {
        return idJugador;
    }

    public static void setIdJugador(int idJugador) {
        Jugadores.idJugador = idJugador;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }
    
    
}
