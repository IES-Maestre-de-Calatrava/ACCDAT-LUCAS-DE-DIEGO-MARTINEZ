/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file3eliminando;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Lukitass
 */
public class File3Eliminando {

    public static void main(String[] args) throws IOException {
        System.out.println("Ficheros en el directorio del proyecto: ") ;
        
        File carpeta = new File(".\\carpeta");
        carpeta.mkdir();
        String camino = carpeta.getPath();
        
        File file1 = new File (camino,"file1");
        File file2 = new File (camino,"file2");
        
        file1.createNewFile();
        file2.createNewFile();
        
        String[] archivos = carpeta.list();
        
        for (int i=0;i<archivos.length;i++){
            System.out.println(archivos[i]);
        }
        
        File[] lista = carpeta.listFiles();
        
        for (File e:lista){
            if(e.isDirectory()){
                System.out.println("el directorio esta vacio");
            } else if (e.isFile()){
                e.delete();
            }
        }
    }
}
