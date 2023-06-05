package Exercici5;

import java.io.Serializable;

public class Empleado implements Serializable {

	private String nom;
	private String cognom;
	private String posicio;
	
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
