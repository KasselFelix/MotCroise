package pobj.motx.tme3.csp;

import java.util.List;

public class StrategyBasic implements IChoixValeur {
		
		public List<String> orderValues (ICSP problem, IVariable v){
			return v.getDomain();
		}
}
