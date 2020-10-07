package pobj.motx.tme2;
import java.util.List;
import java.util.ArrayList;

/**
 *classe représentant un ensemble de letttres
 */
public class EnsembleLettre {
	/**Liste representant l'ensemble de lettres*/
	private List<Character> lettres= new ArrayList<Character>();
	/**
	 * ajoute la lettre c a l'ensemble si elle n'est pas deja presente
	 * @param c caractere a ajouter
	 */
	public void add(char c) {
		for(Character charac : lettres) {
			if(charac==c) 
				return;
		}
		lettres.add(c);
	}
	/**
	 * Accede a la taille de l'ensemble de lettres
	 * @return la taille de la liste representant l'ensemble de lettres
	 */
	public int size() {
		return lettres.size();
	}
	/**
	 * verifie si la lettre c est dans l'ensemble 
	 * @param c caractere a tester
	 * @return true si c est dans l'ensemble false sinon.
	 */
	public boolean contains(char c) {
		return lettres.contains(c); 
	}
	/**
	 * Calcule 'intersection entre cette ensemble et l'ensemble eL2 
	 * modifie la liste
	 * @param e un ensemble de lettres avec lequel on calcule l'intersection
	 * @return un ensemble de lettres représentant l'intersection des deux ensembles.
	 */
	boolean retainAll(List<Character> liste) {
		return lettres.retainAll(liste);
	}	

	/**
	 * Calcule 'intersection entre cette ensemble et l'ensemble eL2 
	 * @param eL2
	 * @return l'intersection entre cette ensemble et de l'ensemble eL2
	 */
	public EnsembleLettre intersection(EnsembleLettre eL2) {
		EnsembleLettre newEl = new EnsembleLettre();
		for(char l : eL2.getLettres()){
			if (this.contains(l))
				newEl.add(l);
		}
		return newEl;
	}
	
	public List<Character> getLettres() {
		return lettres;
	}
	
}
