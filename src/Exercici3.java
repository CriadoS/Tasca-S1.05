import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;


public class Exercici3 {

	public static void main(String[] args) {
		

		String nom;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introdueixi la ruta de la carpeta");
		nom = entrada.nextLine(); 
		
		
		String rutaDirectori = nom; // ruta de la carpeta a llistar els elements 
        String rutaFitxerSortida = "contingut_directori"; // Actualitza amb la ruta del fitxer de sortida

        File carpeta = new File(rutaDirectori);
		
		// Obre el fitxer de sortida per escriure-hi
        try (FileWriter writer = new FileWriter(rutaFitxerSortida)) {
        	
            mostrarDir(carpeta, writer);
            System.out.println("El fitxer s'ha creat correctament");
            
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
	}
	public static void mostrarDir(File carpeta, FileWriter writer) throws IOException { // Sino poso els throws no funciona 
		
		long modData;
		Date data;
		
		TreeSet <File> arbre = new TreeSet<File>();
		File[] contingut = carpeta.listFiles();

        if (contingut != null) {
            
            for (File element : contingut) {
            	
            	arbre.add(element); //afegir els elements de la carpeta al treeset 
            	
            	modData = element.lastModified(); //última modificació del fitxer 
				data = new Date(modData); // ho paso a data sino no es pot llegir
				
				if (element.isDirectory()) {
                   
                    writer.write("[DIR] "+ element.getName()+ data + "\n" );
                    mostrarDir(element, writer);  // Crida recursivament a la mateixa funció per buscar subcarpetes 
                }
                if (element.isFile()) {
                    writer.write("[FIT] "+"  "+ element.getName() + data+ "\n" );
                }
               
                
            }
        }
    
	}
}
