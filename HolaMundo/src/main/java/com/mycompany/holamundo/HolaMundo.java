/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.holamundo;

import java.io.File;

/**
 *
 * @author Lukitass
 */
public class HolaMundo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        File ficheroPrueba = new File(".\\ejemploprueba.txt");
        System.out.println(ficheroPrueba.getPath());
        float tamano = ficheroPrueba.length();
        System.out.println(tamano + " bytes");
    }    
}
