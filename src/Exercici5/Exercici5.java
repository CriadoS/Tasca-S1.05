package Exercici5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercici5 {

	public static void main(String[] args) {
		//Ara el programa ha de serialitzar un Objecte Java
		//a un fitxer .ser i després l’ha de desserialitzar.
		
		Empleado empleado1 = new Empleado ("Pep", "Cuado", "Programador"); // Objecte a serialitzar
		
		try {
			
			ObjectOutputStream escrivint_fitxer = new ObjectOutputStream (new FileOutputStream("." + "fitxer.ser"));
			
			escrivint_fitxer.writeObject(empleado1);
			
			escrivint_fitxer.close();
			
			ObjectInputStream recuperar = new ObjectInputStream (new FileInputStream("." + "fitxer.ser"));
			
			Empleado empleadoRecuperat = new Empleado("","","");
			
			empleadoRecuperat = (Empleado) recuperar.readObject();
			
			System.out.println(empleadoRecuperat);
				
		} catch(Exception e) {
			
			System.out.println("S'ha produit un error");
		}
	
	}

}

	 
