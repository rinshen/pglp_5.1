package fr.uvsq.rinshen.ex51;

import java.util.ArrayList;

public abstract class Groupe {
	private ArrayList<Personnel> membres;
	
	public Groupe() {
		membres=new ArrayList<Personnel>();
	}
	
	public void ajoute_membre(Personnel nouveau) {
		membres.add(nouveau);
	}
}
