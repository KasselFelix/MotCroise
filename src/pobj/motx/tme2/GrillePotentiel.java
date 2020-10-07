package pobj.motx.tme2;

import pobj.motx.tme1.*;
import java.util.List;
import java.util.ArrayList;

public class GrillePotentiel {
	
	private GrillePlaces gp;
	private Dictionnaire d;
	private List<Dictionnaire> motsPot;
	private List<IContrainte> contraintes;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet){
		gp = grille;
		d = dicoComplet;
		motsPot= new ArrayList<Dictionnaire>();
		contraintes= new ArrayList<IContrainte>();
		
		/**/
		for(Emplacement e : gp.getPlaces()){
			Dictionnaire domaineE = d.copy();
			domaineE.filtreLongueur(e.size());
			for(int i=0;i<e.getLettres().size();i++){
				domaineE.filtreParLettre(e.getLettres().get(i).getChar(),i);
			}
			motsPot.add(domaineE);
		}
		
		/**
		//version optimiser non complete filtre par lettrre manquant
		for(int cpt=0;cpt<gp.getPlaces().size();cpt++){
			motsPot.add(new Dictionnaire()); 
		}
		//parcour tout le dictionnaire
		for(int i=0;i<d.size();i++){
			//pour chaque emplacement
			for( int e=0;e<gp.getPlaces().size();e++){
				Dictionnaire domaineE=motsPot.get(e);
				Emplacement emplacement=gp.getPlaces().get(e);
				//si la taille du mot du dictionnaire = mot de l'emplacement 
				if (d.get(i).length()==emplacement.size()){
					domaineE.add(d.get(i));//on ajoute le mot dans le domaine de cet emplacement
				}
			}
		}
		/**/
		
		int c1=0;
		int c2=0;
		IContrainte c;
		for(int m1=0;m1<gp.getNbHorizontal();m1++){
			List<Case> motH = gp.getPlaces().get(m1).getLettres();
			for (int m2=gp.getNbHorizontal();m2<gp.getPlaces().size();m2++){
				List<Case> motV = gp.getPlaces().get(m2).getLettres();
				for(Case cMotH : motH){
					c2=0;
					if(cMotH.isVide()){
						for(Case cMotV : motV){
							if(cMotH.getChar()==cMotV.getChar() ){
								c = new CroixContrainte(m1,c1,m2,c2);
								if(!contraintes.contains(c))
									contraintes.add(c);
							}
							c2++;
						}
					}
					c1++;
				}
			}
		}
		//propage();
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces newGplaces=new GrillePlaces(gp.getGrille().copy());
		for(int i=0;i<soluce.length();i++) {
			Case c=newGplaces.getPlaces().get(m).getLettres().get(i);
			c.setChar(soluce.charAt(i));
		}
		GrillePotentiel newGp= new GrillePotentiel(newGplaces,this.d);
		return newGp;
	}
	
	
	public boolean isDead(){
		for(Dictionnaire domaine : motsPot)
			if(domaine.size()==0)
				return true;
		return false;
	}
	
	private boolean propage(){
		while(true){
			int nbEliminations=0;
			for (IContrainte c : contraintes) 
				nbEliminations+= c.reduce(this);
			if(this.isDead())return false;
			if(nbEliminations==0)return true;
		}
	}
	
	public GrillePlaces getGp() {
		return gp;
	}

	public Dictionnaire getD() {
		return d;
	}

	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	public List<IContrainte> getContraintes() {
		return contraintes;
	}

}
