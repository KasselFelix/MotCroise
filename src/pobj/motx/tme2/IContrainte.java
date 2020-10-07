package pobj.motx.tme2;

/**
 * Interface representant les contraintes 
 */
public interface IContrainte {
	
	/**
	 * filtre une grille 
	 * @param grille grille a filtrer
	 * @return le nombre de mots filtres.
	 */
	int reduce(GrillePotentiel grille);
}
