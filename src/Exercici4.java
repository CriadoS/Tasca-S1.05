import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.BufferedReader;
public class Exercici4 {

	public static void main(String[] args) {
		
		//Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola.
		
		String nom;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introdueixi la ruta de la carpeta");
		nom = entrada.nextLine(); 
		
		
		String rutaDirectori = nom; // ruta de la carpeta a llistar els elements 
        String rutaFitxerSortida = "contingut_directori"; // Actualitza amb la ruta del fitxer de sortida
        
     
        File carpeta = new File(rutaDirectori);
        File fitxerDades = new File (rutaFitxerSortida);// guardo la ruta 
		
		// Obre el fitxer de sortida per escriure-hi
        try (FileWriter writer = new FileWriter(rutaFitxerSortida)) {
        	
            mostrarDir(carpeta, writer);
            System.out.println("El fitxer s'ha creat correctament");
            llegirFitxer(fitxerDades);

            
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
	public static void llegirFitxer(File fitxerDades)  {
		
	    String contingut; 
		
		try {
			
				FileReader f = new FileReader(fitxerDades); 
		        BufferedReader b = new BufferedReader(f); 
		        while((contingut = b.readLine())!=null) { 
		        	System.out.println(contingut); 
		        } 
		        b.close();
				
		}catch(Exception e) {
			
			System.out.println("No s'ha trobat el fitxer");
			
			
		}
		
	}

}
