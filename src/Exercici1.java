import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
public class Exercici1 {
   
	public static void main(String[] args) {
		
		//Crear un programa que llisti alfabeticament el contigunt d'un directori 
		
		String ruta;
		
		ruta = ".";  // agafa el directori de treball actual
		
		mostrarDir(ruta);
		
	}
	public static void mostrarDir(String nom) {
		
		File carpeta = new File(nom);
		
		File [] arrayElements = carpeta.listFiles();
		
		Arrays.sort(arrayElements); //Ordenar alfabeticament 
		
		System.out.println("El contingut de " + carpeta.getAbsolutePath() + " és:"); //carpeta.getAboslutePath em retorna la ruta absoluta
		
		for (int i = 0; i < arrayElements.length; i++) {
			
			File f = arrayElements[i];
			
			System.out.println(f.getName());
			
			
			}
		
		}
			
	
	}
		
		
	



