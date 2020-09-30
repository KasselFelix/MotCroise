package pobj.motx.tme1;
import java.util.ArrayList;

public class GrillePlaces {
	
	private ArrayList<Emplacement> places;
	
	private Grille grille;
	private int horizontal;
	
	public GrillePlaces(Grille grille) {
		this.grille=grille;
		places = new ArrayList<Emplacement>();
		for(int l=0;l<grille.nbLig();l++) {
			ArrayList<Case> lig=this.getLig(l);
			horizontal=places.size();
			cherchePlaces(lig);
		}
		horizontal=places.size();
		for(int c=0;c<grille.nbCol();c++) {
			ArrayList<Case> col=this.getCol(c);
			cherchePlaces(col);
		}
		
	}
	
	private void cherchePlaces(ArrayList<Case> cases) {
		Emplacement e=new Emplacement();
		for (int i=0;i<cases.size();i++) {
			if(!cases.get(i).isPleine()) {
				e.add(cases.get(i));
				//si la case est en bordure
				if(e.size()>1 && i == cases.size()-1){
					places.add(e);
					//Mot Ajouté!
				}
			}

			else {
				if(e.size()>1){
					places.add(e);
					//Mot Ajouté !
				}
				e =new Emplacement();
			}
			
		}
	}
	
	
	public ArrayList<Emplacement> getPlaces(){
        return places;

    }
	
	public int getNbHorizontal() {
		return horizontal;
	}
	
	private ArrayList<Case> getLig(int lig){
		ArrayList<Case> cases=new ArrayList<Case>();
		//if(lig<grille.nbLig() && lig >= 0) {
			for (int i=0;i<grille.nbCol();i++) {
				cases.add(grille.getCase(lig,i));
			}
		//}			  
	        return cases;
	}
	
	private ArrayList<Case> getCol(int col){
		ArrayList<Case> cases=new ArrayList<Case>();
		//if(col<grille.nbCol() && col >= 0) {
			for (int i=0;i<grille.nbLig();i++) {
				cases.add(grille.getCase(i,col));
			}
		//}
		return cases;
	}
	
	
	
	public String toString() {
		String s="";
		for(int i=0;i<places.size();i++) {
			s+=places.get(i).toString();
			s+="\n";
		}
		return s;
	}
}
