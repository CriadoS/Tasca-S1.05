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
class Empleado implements Serializable { // Classe que implementa el serialitzar
	
	 String nom;
	 String cognom;
	 String posicio;
	
	 public Empleado(String nom, String cognom, String posicio) {
		this.nom = nom;
		this.cognom = cognom;
		this.posicio = posicio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getPosicio() {
		return posicio;
	}

	public void setPosicio(String posicio) {
		this.posicio = posicio;
	}

	@Override
	public String toString() {
		return "Empleado [nom=" + nom + ", cognom=" + cognom + ", posicio=" + posicio + "]";
	}
	
	 
}