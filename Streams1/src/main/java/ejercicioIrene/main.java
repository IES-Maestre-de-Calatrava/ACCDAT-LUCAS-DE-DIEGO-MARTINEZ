/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioIrene;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author b15-15m
 */
public class main {
    JFileChooser fileChooser = new JFileChooser();
    
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (.txt)","txt");
    
    int resultado = fileChooser.showOpenDialog(null);
    
    if(resultado == JFileChooser.APPROVE_OPTION){
        String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        
        try{
            
        }
}