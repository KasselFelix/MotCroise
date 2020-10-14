package pobj.motx.tme2;

import pobj.motx.tme1.Emplacement;

public class MotUnique implements IContrainte {
	
//	private String mot;
//	
//	public MotUnique(String mot){
//		this.mot=mot;
//	}
	
	public int reduce(GrillePotentiel gp) {

		int cpt=0;
		for(Emplacement e : gp.getGp().getPlaces() ){
			for (int c=0; c < e.getLettres().size();c++){
				String mot="";
				
				if(!e.getLettres().get(c).isVide())
					break;
				
				mot+=e.getLettres().get(c);
				if(c == e.getLettres().size()-1){
					System.out.println(mot);
					for(Dictionnaire d : gp.getMotsPot()){
						if(d.getMots().contains(mot)){
							d.getMots().remove(mot);
							cpt++;
						}
					}
				
				}
			}
		}
		System.out.println(cpt);
		return cpt;
	}
	
//	public int reduce(GrillePotentiel gp) {
//
//		int cpt=0;
//		System.out.println("passe");
//
//		for(Dictionnaire d : gp.getMotsPot()){
//			if(d.getMots().contains(mot)){
//				d.getMots().remove(mot);
//				cpt++;
//			}
//		}
//
//		return cpt;
//	}
}
