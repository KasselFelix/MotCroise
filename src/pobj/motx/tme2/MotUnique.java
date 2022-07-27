package pobj.motx.tme2;


public class MotUnique implements IContrainte {

	
	public int reduce(GrillePotentiel gp) {

		int cpt=0;
		int i=0;
		for(Dictionnaire d : gp.getMotsPot() ){
			if(d.size()==1){
				String mot = d.get(0);
				for(Dictionnaire domaine : gp.getMotsPot()){
					i=0;
					if(d != domaine ){
						if(domaine.getMots().contains(mot)){
							domaine.getMots().remove(mot);
							gp.getGp().getPlaces().get(i).addContraintes(1);
							cpt++;
						}
					}
					i++;
				}
			}
		}
		//System.out.println("u : "+cpt);
		return cpt;
	}
}