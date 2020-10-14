package pobj.motx.tme3.csp;
import java.util.List;

public  interface ICSP {
	
	/**
	 * accéde aux variables du problème
	 * @return
	 */
	public List<IVariable> getVars();
	/**
	 * teste si un problème est encore satisfiable
	 * @return
	 */
	public boolean isConsistent();
	/**
	 *  nouveau problème CSP, de même nature que le précédent, 
	 *  mais qui compte une variable de moins 
	 * @return
	 */
	public ICSP assign(IVariable vi, String val);
	
}
