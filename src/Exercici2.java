import java.io.File;
import java.util.*;

import javax.swing.tree.DefaultMutableTreeNode;

public class Exercici2 {

	public static void main(String[] args) {
		
		//Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un arbre de directoris amb el
		//contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla en ordre alfabètic dins de cada nivell,
		//indicant a més si és un directori (D) o un fitxer (F), i la seva última data de modificació.
		
				String nom;
				
				Scanner entrada = new Scanner(System.in);
				System.out.println("introdueixi la ruta de la carpeta");
				
				nom = entrada.nextLine(); 
				mostrarDir(nom);
	}
	
	public static void mostrarDir(String nom) {
		
		long modData;
		Date data;
		
		TreeSet <File> arbre = new TreeSet<File>();
		File carpeta = new File(nom);
		File[] arrayElements = carpeta.listFiles();
	
		System.out.println("El contingut de " + carpeta.getAbsolutePath() + " és:"); //carpeta.getAboslutePath em retorna la ruta absoluta
		
		for (int i = 0; i < arrayElements.length; i++) {
			
			File f = arrayElements[i];
			
			arbre.add(f);
			
			modData = f.lastModified();
			data = new Date(modData);
				
			if (f.isDirectory()) {
								
			  System.out.print("[DIR] " );
			   
			  System.out.println(" "+ f.getName() +" -------   "+ data);
			
			
			} else {
				
				System.out.print("[FIT] " );
				
				System.out.println("      " + f.getName() +" --------   "+ data);
			}
			
		
	 }
			
			
		
	}	
			
}
