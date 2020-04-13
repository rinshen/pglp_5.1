package fr.uvsq.rinshen.ex51;

interface DataAccessObject<T> {
	public abstract void ecrire(T obj, String fichier);

	public abstract T lire(String fichier);
}
