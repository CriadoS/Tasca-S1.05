import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.TreeSet;

public class Nivell2_1 {

	public static void main(String[] args) {
		/*Executa l'exercici 3 del nivell anterior parametritzant tots els mètodes en un fitxer de configuració.
		 *Pots utilitzar un fitxer Java Properties, o bé la llibreria Apache Commons Configuration si ho prefereixes.
		  	De l'exercici anterior, parametritza el següent:
			Directori a llegir.
			Nom i directori del fitxer TXT resultant.
		 */
		
		Properties propietats = new Properties(); // creo una classe properties
		InputStream entrada = null; // clase abstracte per llegir les dades 
		
		try {
			
			entrada = new FileInputStream("datos.properties");
			
			propietats.load(entrada); // carrego el contingut 
				
			System.out.println(propietats.getProperty("directori")); // valor del directori
			System.out.println(propietats.getProperty("directori_final")); // valor del directori i el fitxer 
		
			
			String directori = propietats.getProperty("directori"); // guardo el directori en un string
			String rutaFitxerSortida = propietats.getProperty("directori_final"); // guardo la ruta del fitxer final 
			
			
			File carpeta = new File (directori);
			File fitxerDades = new File (rutaFitxerSortida);// guardo la ruta 
			
			FileWriter writer = new FileWriter(fitxerDades);
			
			mostrarDir(carpeta,writer);
			writer.close(); // tancar aquí el writer sino no funciona 
			llegirFitxer(fitxerDades);
			
			entrada.close();
			
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}catch(IOException e ) {
			e.printStackTrace();
			
		}
		
	}

	public static void mostrarDir(File carpeta, FileWriter writer){ // Sino poso els throws no funciona 
		
		long modData;
		Date data;
		
		TreeSet <File> arbre = new TreeSet<File>();
		File[] contingut = carpeta.listFiles();
	
	    if (contingut != null) {
	       
	    	try {
	    		
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
	    		
	    	}catch(IOException e) {
	    		
	    		e.printStackTrace();
	    		
	    	}
	    	
	    }
       
	}
	 public static void llegirFitxer(File fitxerDades)  {
			
		    String linia; 
		    
			try {
		
				FileReader lector = new FileReader(fitxerDades); 
		        
				BufferedReader buffer = new BufferedReader(lector); 
		       
		        while((linia = buffer.readLine())!= null) { 
		        	
		        	System.out.println(linia); 
		        } 
		        
		        buffer.close();
		        lector.close();
					
			}catch(Exception e) {
				
				System.out.println("No s'ha trobat el fitxer");
				
				
			}
		    	
			
		}

}
