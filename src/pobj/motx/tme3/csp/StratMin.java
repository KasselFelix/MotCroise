package pobj.motx.tme3.csp;

public class StratMin implements IChoixVar {
	
	public IVariable chooseVar(ICSP problem){
		IVariable tmp=problem.getVars().get(0);
		for (int i=1;i<problem.getVars().size();i++){
			if(problem.getVars().get(i).getDomain().size()<tmp.getDomain().size()){
				tmp=problem.getVars().get(i);
			}
		}
		return tmp;
	}
}
