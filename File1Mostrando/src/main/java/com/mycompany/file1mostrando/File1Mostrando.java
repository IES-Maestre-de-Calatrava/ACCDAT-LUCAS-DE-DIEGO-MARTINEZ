/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1mostrando;

/**
 *
 * @author Lukitass
 */

import java.io.File;
public class File1Mostrando {

    public static void main(String[ ] args){
        System.out.println("Ficheros en el directorio del proyecto: ") ;
        File fi=new File(".\\carpeta");
        String[] archivos = fi.list();
        for (int i=0;i<archivos.length;i++) {
            System.out.println(archivos[i]);
        }        
    }
}
