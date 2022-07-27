package pobj.motx.tme3.csp;
import java.util.List;


public interface IVariable {

	/**
	 *  domaine d’une IVariable 
	 *  ensemble des valeurs qu’elle peut prendre
	 * @return
	 */
	public List<String> getDomain();
	
	public void setDomain(List<String> list);
	
	public int getNbContraintes();
}
