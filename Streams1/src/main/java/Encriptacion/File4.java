/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Lukitass
 */
public class File4 {
    
    File file1 = new File (".\\file1.txt");
    File file2 = new File (".\\file2.txt");
    
    try(BufferedReader br= new BufferedReader(new FileReader(file1));BufferedWriter bw =
            new BufferedWriter(new FileWriter (file2)){
                int x = 0;
                int i = br.read();
                while(i!=-1){
                    x=i+3;
                    bw.write((char)x); 
                }
            } catch(IOException ioe){
            System.out.println(ioe);
            } catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
            }
    
}
