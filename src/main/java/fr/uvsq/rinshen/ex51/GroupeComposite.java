package fr.uvsq.rinshen.ex51;

import java.util.ArrayList;

public class GroupeComposite extends Groupe {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5967645000430610085L;
	private ArrayList<Groupe> sous_groupes;
	public GroupeComposite() {
		super();
		sous_groupes=new ArrayList<Groupe>();
	}
	
	public void ajoute_groupe(Groupe groupe) {
		sous_groupes.add(groupe);
	}
}
