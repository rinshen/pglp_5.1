package fr.uvsq.rinshen.ex51;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Groupe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1072913158732325451L;
	private ArrayList<Personnel> membres;
	
	public Groupe() {
		membres=new ArrayList<Personnel>();
	}
	
	public void ajoute_membre(Personnel nouveau) {
		membres.add(nouveau);
	}
	
	public ArrayList<Personnel> getMembres() {
		return membres;
	}
}
