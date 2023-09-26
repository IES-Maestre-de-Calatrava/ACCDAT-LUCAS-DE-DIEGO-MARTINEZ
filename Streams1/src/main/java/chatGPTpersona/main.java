/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatGPTpersona;

import static chatGPTpersona.Persona.crearPersonaDesdeBytes;
import static chatGPTpersona.Persona.crearPersonaEnBytes;
import java.io.IOException;

/**
 *
 * @author b15-15m
 */
public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Crear una persona y convertirla en bytes
        String nombre = "Juan";
        String telefono = "123-456-7890";
        byte[] personaBytes = crearPersonaEnBytes(nombre, telefono);

        // Reconstruir la persona a partir de los bytes
        Persona personaReconstruida = crearPersonaDesdeBytes(personaBytes);

        // Imprimir la persona reconstruida
        System.out.println("Persona Reconstruida: " + personaReconstruida);
    }
}
