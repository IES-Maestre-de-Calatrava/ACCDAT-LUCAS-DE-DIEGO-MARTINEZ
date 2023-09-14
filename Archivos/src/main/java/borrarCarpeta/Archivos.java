/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package borrarCarpeta;

import java.io.File;

/**
 *
 * @author Lukitass
 */
public class Archivos {
    
    public static void borrarCarpeta(File dir){
        File[] fileList = dir.listFiles();
        for(File e:fileList){
            if (e.isDirectory()){
            borrarCarpeta(e);
        }
        e.delete();
        }
        dir.delete();
    }
    
}
