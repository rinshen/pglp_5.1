package fr.uvsq.rinshen.ex51;


/**
 * Groupe contenant uniquement des personnes.
 */
public class GroupeFeuille extends Groupe {
	private static final long serialVersionUID = 7442726568681896649L;

	public GroupeFeuille() {
		super();
	}
	
	/**
	 * Fonction d'égalité utilisée pour les tests.
	 * @param obj -> Objet à comparer
	 * @return true si les objets ont le même type et les même attributs
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GroupeFeuille)) {
			return false;
		}
		GroupeFeuille test = (GroupeFeuille)obj;
		if (!this.getMembres().containsAll(test.getMembres())) {
			return false;
		}
		if (!test.getMembres().containsAll(this.getMembres())) {
			return false;
		}
		return true;
	}
}
