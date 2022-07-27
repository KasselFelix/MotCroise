package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme1.Case;
import java.util.ArrayList;

public class MotX implements ICSP {
	
	private GrillePotentiel gp;
	private List<IVariable> variables;
	
	public MotX(GrillePotentiel gp) {
		this.gp=gp;
		variables = new ArrayList<IVariable>();
		for(int i=0;i<gp.getGp().getPlaces().size();i++) {
			Emplacement e =gp.getGp().getPlaces().get(i);
			for(Case c : e.getLettres()) {
				if(c.isVide()) {
					DicoVariable dV= new DicoVariable(i,gp);
					variables.add(dV);
					break;
				}
			}
		}
	}
	
	public ICSP assign(IVariable vi, String val){
		if(vi instanceof DicoVariable){
			DicoVariable dVi=  (DicoVariable) vi;
			ICSP newMotX=new MotX(gp.fixer(dVi.getIndex(), val));
			variables.remove(vi);
			return newMotX;
		}
		return null;
	}
	
	public List<IVariable> getVars(){
		return variables;
	}
	
	public boolean isConsistent() {
		return !gp.isDead();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(gp.getGp().getGrille());
		return sb.toString();
	}
}
