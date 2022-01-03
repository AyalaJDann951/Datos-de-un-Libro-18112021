/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Archivo {
    public void escribirArchivo(Libro L) {
        int cod = L.getCodigo();
        String tit = L.getTitulo();
        String aut = L.getAutor();
        String p = L.getPais();
        int a = L.getAño();
        String form = String.format("%010d", cod);
        
        try{
            FileWriter fw = new FileWriter("d:/RegistroLibro18112021.txt", true);
            fw.write(form + "; " + tit + "; " + aut + "; " + p + "; " + a + "\n");
            fw.close();
            JOptionPane.showMessageDialog(null, "El libro ha sido registrado con el código " + form);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public ArrayList<Libro> leerArchivo() {
        ArrayList<Libro> libros = new ArrayList<>();
        Libro L = null;
        
        try{
            FileReader fr = new FileReader("d:/RegistroLibro18112021.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            String datos[];
            
            while(cadena != null){
                datos = cadena.split("; ");
                cadena = br.readLine();
                L = new Libro(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
                libros.add(L);
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return libros;
    }
    
    public void modificarArchivo(Libro L) {
        int cod = L.getCodigo();
        String tit = L.getTitulo();
        String aut = L.getAutor();
        String p = L.getPais();
        int a = L.getAño();
        String form = String.format("%010d", cod);
        
        try{
            FileWriter fw = new FileWriter("d:/RegistroLibro18112021.txt", true);
            FileReader fr = new FileReader("d:/RegistroLibro18112021.txt");
            ReemplazarArchivo obj = new ReemplazarArchivo();
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            String nuevo = form + "; " + tit + "; " + aut + "; " + p + "; " + a;
            String newCadena = "";
            String datos[];
            
            while(cadena != null){
                datos = cadena.split("; ");
                if(cod == Integer.parseInt(datos[0])) cadena = nuevo;
                newCadena += cadena + "\n";
                cadena = br.readLine();
            }
            
            obj.replaceFile("d:/Vacio.txt", "d:/RegistroLibro18112021.txt");
            fw.write(newCadena);
            fw.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "El libro " + L.getTitulo() + " ha sido modificado");
    }
    
    public void eliminarArchivo(int cod, String lib) {
        try{
            FileWriter fw = new FileWriter("d:/RegistroLibro18112021.txt", true);
            FileReader fr = new FileReader("d:/RegistroLibro18112021.txt");
            ReemplazarArchivo obj = new ReemplazarArchivo();
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            String newCadena = "";
            String datos[];
            
            while(cadena != null){
                datos = cadena.split("; ");
                if(cod != Integer.parseInt(datos[0])) newCadena += cadena + "\n";
                cadena = br.readLine();
            }
            
            obj.replaceFile("d:/Vacio.txt", "d:/RegistroLibro18112021.txt");
            fw.write(newCadena);
            fw.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "El libro " + lib + " ha sido eliminado");
    }
    
    public int contarLineas() {
        int nFilas = 0;
        
        try{
            FileReader fr = new FileReader("d:/RegistroLibro18112021.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            
            while(cadena != null){
                cadena = br.readLine();
                nFilas++;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return nFilas;
    }
}
