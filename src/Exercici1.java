import java.io.File;
import java.util.*;
public class Exercici1 {
   
	public static void main(String[] args) {
		
		//Crear un programa que llisti alfabeticament el contigunt d'un directori 
		
		String nom;
		
		nom = "C:\\Users\\formacio"; 
		
		mostrarDir(nom);
		
	}
	public static void mostrarDir(String nom) {
		
		File carpeta = new File(nom);
		
		File[] arrayElements = carpeta.listFiles();
		
		System.out.println("El contingut de " + carpeta.getAbsolutePath() + " és:"); //carpeta.getAboslutePath em retorna la ruta absoluta
		
		for (int i = 0; i < arrayElements.length; i++) {
			
			File f = arrayElements[i];
			
			if (f.isDirectory()) {
				
			System.out.print("[DIR] ");
			
			} else {
				
			System.out.print("[FIT] ");
			}
			
			System.out.println(f.getName());
			}
		
		}
			
	
	}
		
		
	



