package fr.uvsq.rinshen.ex51;

public class GroupeFeuille extends Groupe {
	private static final long serialVersionUID = 7442726568681896649L;

	public GroupeFeuille() {
		super();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GroupeFeuille)) {
			return false;
		}
		GroupeFeuille test = (GroupeFeuille)obj;
		if (!this.getMembres().equals(test.getMembres())) {
			return false;
		}
		return true;
	}
}
