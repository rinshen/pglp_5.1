package fr.uvsq.rinshen.ex51;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
/**
 * Hello world!
 *
 */
public final class Personnel
{
    private final String nom;
    private final String prenom;
    private final String fonction;
    private final LocalDate date_naissance;
    private final ArrayList<String> num_telephone;
    
    public static class Builder{
    	private String nom;
        private String prenom;
        private String fonction;
        private LocalDate date_naissance;
        private ArrayList<String> num_telephone;
        
        public Builder(String Nom, String Prenom) {
        	nom=Nom;
        	prenom=Prenom;
        	
        	fonction="nom spécifiée";
        	date_naissance=LocalDate.of(0, Month.JANUARY, 0);
        	num_telephone=new ArrayList<String>();
        }
    	
        public Builder fonction(String Fonction) {
        	fonction=Fonction;
        	return this;
        }
        
        public Builder date_naissance(int jour, Month mois, int annee) {
        	date_naissance=LocalDate.of(annee, mois, jour);
        	return this;
        }
        
        public Builder num_telephone(String numero) {
        	num_telephone.add(numero);
        	return this;
        }
        
        public Personnel build() {
        	return new Personnel(this);
        }
    }
    
    public Personnel(Builder builder) {
    	nom=builder.nom;
    	prenom=builder.prenom;
    	fonction=builder.fonction;
    	date_naissance=builder.date_naissance;
    	num_telephone=builder.num_telephone;
    }
}
