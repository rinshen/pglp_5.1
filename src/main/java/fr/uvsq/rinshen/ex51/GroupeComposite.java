package fr.uvsq.rinshen.ex51;

import java.util.ArrayList;

/**
 * Classe pouvant contenir des personnels et/ou des sous groupes de personnels.
 */
public class GroupeComposite extends Groupe {
	private static final long serialVersionUID = -5967645000430610085L;
	private ArrayList<Groupe> sousGroupes;
	//liste des sous groupes (peut contenir n'importe quelle classe héritant de Groupe
	
	public GroupeComposite() {
		super();
		sousGroupes = new ArrayList<Groupe>();
	}
	
	/**
	 * Fonction ajoutant un objet héritant de Groupe à la liste des sous groupes.
	 * @param groupe -> Groupe à ajouter
	 */
	public void ajouteGroupe(Groupe groupe) {
		sousGroupes.add(groupe);
	}
	
	public ArrayList<Groupe> getSousGroupes() {
		return sousGroupes;
	}

	/**
	 * Fonction d'égalité utilisée pour les tests.
	 * @param obj -> Objet à comparer
	 * @return true si les objets ont le même type et les même attributs
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GroupeComposite)) {
			return false;
		}
		GroupeComposite test = (GroupeComposite)obj;
		if (!this.getMembres().equals(test.getMembres())) {
			return false;
		}
		if (!this.sousGroupes.equals(test.sousGroupes)) {
			return false;
		}
		return true;
	}
}
