package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe qui represente les emplacement des mots dans une grille 
 */
public class Emplacement{
	/** liste de cases representant un mot */
	private List<Case>lettres;
	/**
	 * Construit un emplacement vide
	 */
    public Emplacement(){
        lettres=new ArrayList<Case>();

    }
    /**
     * donne la taille du mot de notre emplacement
     * @return la taille de la liste contenant les lettres du mot
     */
	public int size(){
        return lettres.size();

    }
	/**
     * ajoute une case a notre emplacement
     * @param c nouvelle case de l'emplacement
     */
    public void add(Case c) {
    	lettres.add(c);
    }
    /**
     * Accede à lettres
     * @return les cases composant un emplacement.
     */
    public List<Case> getLettres() {
		return lettres;
	}
    
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	for(Case l : lettres)
    		sb.append(l.toString() );
    	return sb.toString();
    }
}