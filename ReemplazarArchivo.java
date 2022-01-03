/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ReemplazarArchivo {
    public void replaceFile(String file1, String file2) {   
	BufferedReader reader = null;
        BufferedWriter writer = null;
        
	try{
            FileReader fr  = new FileReader(file1);  
            FileWriter fw = new FileWriter(file2);
            reader = new BufferedReader(fr);
            writer = new BufferedWriter(fw);
            String line = null;
            StringBuffer sbf=new StringBuffer();
            
            while((line = reader.readLine()) != null){
                sbf.append(line);  
            }
            
            String newString = sbf.toString().replace("{name}", " ");
            newString = newString.replace("{type}", "dog");
            newString = newString.replace("{master}", " ");
            writer.write(newString);    
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(reader!=null)
                    reader.close();
                    if(writer!=null) writer.close();
            } catch(IOException e){
		e.printStackTrace();
            }
	}
    }
}
