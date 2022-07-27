package pobj.motx.tme3.csp;

import java.util.Collections;
import java.util.List;

public class StrategyRandom implements IChoixValeur {
	
	public List<String> orderValues (ICSP problem, IVariable v){
		Collections.shuffle(v.getDomain());
		return v.getDomain();
	}
}
