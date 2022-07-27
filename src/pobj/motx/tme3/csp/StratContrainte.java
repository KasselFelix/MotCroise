package pobj.motx.tme3.csp;

public class StratContrainte implements IChoixVar {
	
	public IVariable chooseVar(ICSP problem){
		IVariable tmp=problem.getVars().get(0);
		for (int i=1;i<problem.getVars().size();i++){
			if(problem.getVars().get(i).getNbContraintes()<tmp.getNbContraintes()){
				tmp=problem.getVars().get(i);
			}
		}
		return tmp;
	}
}

