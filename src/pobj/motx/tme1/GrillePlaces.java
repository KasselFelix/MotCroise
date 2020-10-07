package pobj.motx.tme1;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe de representation des emplacements des mots dans la grille
 */
public class GrillePlaces {
	/** Liste des emplacement des mots dans la grille*/
	private List<Emplacement> places;
	/**la grille sur laquelle on recherche l'emplacement des mots*/
	private Grille grille;
	/** nombre de mots horizontaux*/
	private int nbHorizontal;
	/**
     * Construit une Grille place a partir d'une grille specifiee en precisant le nombre de mots
     * horizontaux et la liste d'emplacement des mots
     * @param grille grille sur laquelle on recherche l'emplacement des mots
     */
	public GrillePlaces(Grille grille) {
		this.grille=grille;
		places = new ArrayList<Emplacement>();
		
		for(int l=0;l<grille.nbLig();l++)
			cherchePlaces(this.getLig(l));
		
		nbHorizontal=places.size();
		
		for(int c=0;c<grille.nbCol();c++)
			cherchePlaces(this.getCol(c));

		System.out.println(this.toString());
	}
	/**
	 * Accede aux cases de la ligne en parametre et les ajoute dans une liste de Case
	 * @param lig
	 * @return les cases qui constituent une ligne donnée
	 */
	private List<Case> getLig(int lig){
		ArrayList<Case> cases=new ArrayList<Case>();
		for (int i=0;i<grille.nbCol();i++)
			cases.add(grille.getCase(lig,i));
	    return cases;	
	}
	
	/**
	 * Accede aux cases de la colonne en parametre et les ajoute dans une liste de Case
	 * @param col
	 * @return les cases qui constituent une colonne donnée
	 */
	private List<Case> getCol(int col){
		ArrayList<Case> cases=new ArrayList<Case>();
		for (int i=0;i<grille.nbLig();i++)
			cases.add(grille.getCase(i,col));
		return cases;
	}
	 /**
     * recherche l'emplacement des mots dans la liste de cases et les ajoute a la liste des places
     * @param cases liste de cases ou chercher les mots
     */
	private void cherchePlaces(List<Case> cases) {
		Emplacement e=new Emplacement();
		for (int i=0;i<cases.size();i++) {//parcour chaque case de la list en parametre
			if(!cases.get(i).isPleine()) {//si la case n'est pas pleine
				e.add(cases.get(i));
				//si la case est en fin de liste
				if(e.size()>1 && i == cases.size()-1){//on verifie si le nombre de case du dernier emplacement >= 2
					places.add(e);//emplacement ajouter dans places
				}
			}
			else {//sinon
				if(e.size()>1){// si l'emplacement >= 2
					places.add(e);//emplacement ajouter dans places
				}
				e =new Emplacement();//reinitialisation de l'emplacement
			}
		}
	}
	/**
     * Accede a la grille
     * @return la grille sur laquelle on recherche l'emplacement des mots
     */
	public Grille getGrille() {
		return grille;
	}
	
	public List<Emplacement> getPlaces(){
        return places;

    }
	/**
     * Accede aux nombres d'emplacement horizontal dans la grille
     * @return le nombre d'mplacement horizontal
     */
	public int getNbHorizontal() {
		return nbHorizontal;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Emplacement e : places) {
			sb.append(e.toString());
			sb.append("\n");
		}
		return sb.toString();
	} 
}
