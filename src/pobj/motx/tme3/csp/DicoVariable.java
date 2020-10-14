package pobj.motx.tme3.csp;
import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

public class DicoVariable implements IVariable {
	/**indice (celui de l’emplacement de mot correspondant)*/
	private int index;
	private GrillePotentiel gp;
	
	public DicoVariable(int index, GrillePotentiel gp) {
		this.index=index;
		this.gp=gp;
	}
	
	public List<String> getDomain(){
		List<String> domain = gp.getMotsPot().get(index).getMots();
		return domain;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(gp.getGp().getPlaces().get(index));
		return sb.toString();
	}

	public int getIndex() {
		return index;
	}

	public GrillePotentiel getGp() {
		return gp;
	}
}
