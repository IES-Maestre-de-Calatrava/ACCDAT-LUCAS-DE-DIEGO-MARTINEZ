/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatGPTpersona;

/**
 *
 * @author b15-15m
 */
import java.io.*;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String telefono;

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters y setters para los atributos

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", telefono=" + telefono + "]";
    }

    // Método para convertir la persona en bytes
    public byte[] toBytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    // Método para crear una persona a partir de bytes
    public static Persona fromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Persona persona = (Persona) objectInputStream.readObject();
        objectInputStream.close();
        return persona;
    }
    
    public static byte[] crearPersonaEnBytes(String nombre, String telefono) throws IOException {
        Persona persona = new Persona(nombre, telefono);
        return persona.toBytes();
    }
    
    public static Persona crearPersonaDesdeBytes(byte[] bytes) throws IOException, ClassNotFoundException {
        return Persona.fromBytes(bytes);
    }
}
