package pobj.motx.tme2;

import pobj.motx.tme1.*;
import java.util.List;
import java.util.ArrayList;
/**
 *classe representant les mots potentiel d'une grille
 */
public class GrillePotentiel {
	/** grille des emplacement de mots*/
	private GrillePlaces gp;
	/** dictionnaire contenant la totalite des mots possible*/
	private Dictionnaire d;
	/** domaine potentiel des emplacements de mots*/
	private List<Dictionnaire> motsPot;
	/**liste des contraintes de croisement*/
	private List<IContrainte> contraintes;
	/**
	 * construit une grille potentiel a partir d'une grille d'emplacement de mots et d'un dictionnaire
	 * @param grille grille d'emplacement des mots
	 * @param dicoComplet dictionnaire de mots
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet){
		this.gp = grille;
		this.d = dicoComplet;
		this.motsPot= new ArrayList<Dictionnaire>();
		this.contraintes= new ArrayList<IContrainte>();
		
		/**/
		for(Emplacement e : gp.getPlaces()){
			Dictionnaire domaineE = d.copy();
			domaineE.filtreLongueur(e.size());
			for(int i=0;i<e.getLettres().size();i++){
				if(!e.getLettres().get(i).isVide())
					domaineE.filtreParLettre(e.getLettres().get(i).getChar(),i);
			}
			motsPot.add(domaineE);
		}
		
		/**
		//c'etait censé etre opti ....
		for(int cpt=0;cpt<gp.getPlaces().size();cpt++){
			motsPot.add(new Dictionnaire()); 
		}
		Dictionnaire domaineE;
		Emplacement emplacement;
		List<Case> lettreE;
		//parcour tout le dictionnaire
		for(int i=0;i<d.size();i++){
			//pour chaque emplacement
			for( int e=0;e<gp.getPlaces().size();e++){
				domaineE=motsPot.get(e);
				emplacement=this.gp.getPlaces().get(e);
				//si la taille du mot du dictionnaire = mot de l'emplacement 
				if (d.get(i).length()==emplacement.size()){
					lettreE=emplacement.getLettres();
					for(int c=0;c<lettreE.size();c++){
						//si les caracteres des case pleine de l'emplacement correspondent aux lettres du mot   
						if (d.get(i).charAt(c)!=lettreE.get(c).getChar() && !lettreE.get(c).isVide()){
							break;
						}
						if(c==lettreE.size()-1)domaineE.add(d.get(i));//on ajoute le mot dans le domaine de cet emplacement
					}
				}
			}
		}
		/**/
		
		IContrainte c;
		for(int m1=0;m1<gp.getNbHorizontal();m1++){
			List<Case> motH = gp.getPlaces().get(m1).getLettres();
			for (int m2=gp.getNbHorizontal();m2<gp.getPlaces().size();m2++){
				List<Case> motV = gp.getPlaces().get(m2).getLettres();
				for(int c1=0;c1<motH.size();c1++){
					if(motH.get(c1).isVide()){
						for(int c2=0;c2<motV.size();c2++){
							if(motH.get(c1)== motV.get(c2)){
								c = new CroixContrainte(m1,c1,m2,c2);
								if(!contraintes.contains(c)){
									contraintes.add(c);
									if(!contraintes.contains(c)){
										contraintes.add(c);
										gp.getPlaces().get(m1).addContraintes(1);
										gp.getPlaces().get(m2).addContraintes(1);
									}
								}
							}
						}
					}
				}
			}
		}
		
		IContrainte mC = new MotUnique();
		contraintes.add(mC);
		
		propage();
	}
	/**
	 * constructeur optimiser
	 * construit une grille potentiel a partir d'une grille d'emplacement de mots ,d'un dictionnaire et d'une liste de dictionnaires
	 * @param grille grille d'emplacement des mots
	 * @param dicoComplet dictionnaire de mots
	 * @param listDico liste des domaines potentiel pour chaque emplacement
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet,List<Dictionnaire> listDico){
		this.gp = grille;
		this.d = dicoComplet;
		this.motsPot= new ArrayList<Dictionnaire>();
		this.contraintes= new ArrayList<IContrainte>();
		
		
		for(int e=0; e<gp.getPlaces().size();e++){
			Dictionnaire domaineE = listDico.get(e).copy();
			domaineE.filtreLongueur(gp.getPlaces().get(e).size());
			for(int i=0;i<gp.getPlaces().get(e).getLettres().size();i++){
				if(!gp.getPlaces().get(e).getLettres().get(i).isVide())
					domaineE.filtreParLettre(gp.getPlaces().get(e).getLettres().get(i).getChar(),i);
			}
			motsPot.add(domaineE);
		}
		
		IContrainte c;
		for(int m1=0;m1<gp.getNbHorizontal();m1++){
			List<Case> motH = gp.getPlaces().get(m1).getLettres();
			for (int m2=gp.getNbHorizontal();m2<gp.getPlaces().size();m2++){
				List<Case> motV = gp.getPlaces().get(m2).getLettres();
				for(int c1=0;c1<motH.size();c1++){
					if(motH.get(c1).isVide()){
						for(int c2=0;c2<motV.size();c2++){
							if(motH.get(c1)== motV.get(c2)){
								c = new CroixContrainte(m1,c1,m2,c2);
								if(!contraintes.contains(c)){
									contraintes.add(c);
									gp.getPlaces().get(m1).addContraintes(1);
									gp.getPlaces().get(m2).addContraintes(1);
								}
							}
						}
					}
				}
			}
		}
		
		IContrainte mC = new MotUnique();
		contraintes.add(mC);
		
		propage();
	}
	/**
	 * fixe le mot soluce dans l'emplacement d'indice m
	 * @param m indice de l'emplacement
	 * @param soluce mots a fixer
	 * @return newGp nouvelle grille resultant de l'affectation des lettres de soluce dans les cases de m 
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces newGplaces=new GrillePlaces(gp.getGrille().copy());
		for(int i=0;i<soluce.length();i++) {
			Case c=newGplaces.getPlaces().get(m).getLettres().get(i);
			c.setChar(soluce.charAt(i));
		}
		GrillePotentiel newGp= new GrillePotentiel(newGplaces,this.d,this.motsPot);
		return newGp;
	}
	
	
	/**
	 * verifie qu'aucun mot n'a de domaine potentiel vide
	 * @return true si un des dictionnaires de la liste motsPot est vide et false sinon
	 */
	public boolean isDead(){
		//int cpt=0;
		for(Dictionnaire domaine : motsPot){
			if(domaine.size()==0){
				//System.out.println(cpt);
				//System.out.println(gp.getPlaces().get(cpt));
				return true;
			}
			//cpt++;
		}
		return false;
	}
	/**
	 * propage les contraintes en reduisant le domaine potentiel des mots sur chacune des contraintes
	 * @return true si la stabilite est atteinte et false sinon : mot croise irrealisable
	 */
	private boolean propage(){
		while(true){
			int nbEliminations=0;
			for (IContrainte c : contraintes) 
				nbEliminations+= c.reduce(this);
			if(nbEliminations==0)return true;
			if(this.isDead())return false;
		}
	}
	/**
	 * Accede a la grille des emplacements de mots
	 * @return gp
	 */
	public GrillePlaces getGp() {
		return gp;
	}
	/**
	 * Accede au dictionnaire contenant la totalite des mots possible
	 * @return d;
	 */
	public Dictionnaire getD() {
		return d;
	}
	/**
	 * Accede a la liste de domaines potentiels de mots
	 * @return motsPot
	 */
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}
	/**
	 * Accede aux contraintes
	 * @return la liste des contraintes
	 */
	public List<IContrainte> getContraintes() {
		return contraintes;
	}

}
