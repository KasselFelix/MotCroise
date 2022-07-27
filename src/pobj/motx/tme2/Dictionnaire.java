package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<String>();
	private EnsembleLettre[] cache=null;

	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.cache=cache;
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len la longueur voulue 
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<String>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		if(cpt>0)cache=null;
		mots = cible;
		return cpt;
	}
	
	/**
	 * retire les mots du dictionnaire qui n'ont pas le caractere c a la position i
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param c le caractere voulu
	 * @param i l'indice de la case voulu
	 * @return le nombre de mots supprimés du dictionnaire
	 */
	public int filtreParLettre(char c,int i){
		List<String> cible = new ArrayList<String>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.charAt(i) == c)
				cible.add(mot);
			else
				cpt++;
		}
		if(cpt>0)cache=null;
		mots = cible;
		return cpt;
	}
	
	/**
	 * retire les mots dont la ieme lettre ne sont pas dans l'ensemble de lettres 
	 * Attention cette operation modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param i indice de la lettre voulu
	 * @param e ensemble de lettres
	 * @return le nombre de mots supprimes du dictionnaire
	 */
	public int filtrageParLettre(int i, EnsembleLettre e)
	{
		List<String> cible = new ArrayList<String>();
		int cpt=0;
		for (String mot : mots) 
		{
			if (e.contains(mot.charAt(i)))
				cible.add(mot);
			else
				cpt++;
		}
		if(cpt>0)cache=null;
		mots = cible;
		return cpt;
	}

	/**
	 * charge un dictionnaire depuis un fichier situe au path  fourni
	 * @param path chemin d'accès au dictionnaire
	 * @return un dictionnaire contenant les mots possible
	 */
	public static Dictionnaire loadDictionnaire(String path){
		Dictionnaire d=new Dictionnaire();
		// Try-with-resource : cette syntaxe permet d’accéder au contenu du fichier ligne par ligne
		try {
			BufferedReader br= new BufferedReader(new FileReader(new File(path)));
			String s=br.readLine();
			while(s != null) {
				d.add(s);
				s=br.readLine();
			}
		}
		catch(IOException e) {
			// Problème d’accès au fichier
			e.printStackTrace();
		}
		return d;
	}
	
	public EnsembleLettre charAt(int index){
		if (this.mots.size()==0)
			return new EnsembleLettre();
		if (cache==null)
			cache=new EnsembleLettre[mots.get(0).length()];
		if(cache[index]==null){
			EnsembleLettre solution=new EnsembleLettre();
			for(String mot : this.mots)
				solution.add(mot.charAt(index));
			cache[index]=solution;
		}
		return cache[index];
	}
	/**
	  Accede a la liste des mots du dictionnaire
     * @return mots Liste des mots dans le dictionnaire
	 */
	public List<String> getMots() {
		return mots;
	}
	
	public void setMots(List<String> mots) {
		this.mots = mots;
	}

	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
}
