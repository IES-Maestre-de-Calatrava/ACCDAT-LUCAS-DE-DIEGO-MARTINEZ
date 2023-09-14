/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file2creando;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Lukitass
 */
public class File2Creando {

    public static void main(String[] args) throws IOException {
        System.out.println("Ficheros en el directorio del proyecto: ") ;
        File fi=new File(".\\carpeta");
        fi.mkdir();
        String camino = fi.getPath();  
        
        File file1 = new File(camino,"File 1");
        File file2 = new File (camino,"File 2");
        
        file1.createNewFile();
        file2.createNewFile();
        
        
        String[] archivos = fi.list();
        for (int i=0;i<archivos.length;i++) {
            System.out.println(archivos[i]);
        }   
    }
}
