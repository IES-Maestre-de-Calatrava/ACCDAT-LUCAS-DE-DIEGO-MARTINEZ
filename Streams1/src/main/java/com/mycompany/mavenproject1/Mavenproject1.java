/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Lukitass
 */
public class Mavenproject1 {

    public static void main(String[] args) throws FileNotFoundException {
        
        File file1= new File(".\\file.txt");
        
        try(FileReader fr= new FileReader(file1)){
            
            int car = fr.read();
            
            while(car != -1){
                char cara = (char) car;
                System.out.print(cara);
                car = fr.read();
            }    
            
        } catch (FileNotFoundException fn){
            System.out.print("File no encontrado"+fn);
        } catch (IOException ioe){
            System.out.print(ioe);
        }    
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Metodo de leer files con arrays");
        System.out.println("");

        
        try(FileReader fr = new FileReader(file1)){
            
            int i;
            char[] cadena= new char[20];
            i = fr.read(cadena);
            while (i!=-1){
                System.out.print(cadena);
                Arrays.fill(cadena,'\u0000');
                i = fr.read(cadena);
            }
            
        } catch (FileNotFoundException fn){
            System.out.print("File no encontrado"+fn);
        } catch (IOException ioe){
            System.out.print(ioe);
        }    
        
    }
}
