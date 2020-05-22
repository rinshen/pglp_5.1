package fr.uvsq.rinshen.ex51;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe de base pour contenir des listes de personnes.
 */
public abstract class Groupe implements Serializable {
	private static final long serialVersionUID = -1072913158732325451L;
	private ArrayList<Personnel> membres;//Liste des menbres
	
	public Groupe() {
		membres = new ArrayList<Personnel>();
	}

	/**
	 * Ajoute un Personnel à la liste des personnes.
	 * @param nouveau -> Personnel à ajouter
	 */
	public void ajouteMembre(Personnel nouveau) {
		membres.add(nouveau);
	}
	
	public ArrayList<Personnel> getMembres() {
		return membres;
	}
}
