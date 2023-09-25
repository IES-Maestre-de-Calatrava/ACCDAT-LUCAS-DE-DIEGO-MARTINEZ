/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File2Lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Lukitass
 */
public class main {
    
    File file1= new File(".\\file.txt");
    
    try(FileReader fr = new FileReader(file1)){    
            int i;
            char[] cadena= new char[20];
            i = fr.read(cadena);
            System.out.print(cadena);
            while (i!=-1){
                Arrays.fill(cadena,'\u0000');
                i = fr.read(cadena);
                System.out.print(cadena);

            }
        } catch (FileNotFoundException fn){
            System.out.print("File no encontrado"+fn);
        } catch (IOException ioe){
            System.out.print(ioe);
        }    
    
}
