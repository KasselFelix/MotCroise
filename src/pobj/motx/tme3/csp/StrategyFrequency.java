package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StrategyFrequency implements IChoixValeur {
			
	public List<String> orderValues (ICSP problem, IVariable v){
		HashMap<Character, Integer> lettreFreq = heuristique (v.getDomain());
		HashMap<String, Integer> motScore= new HashMap<String, Integer>();
		for(String mot : v.getDomain()) {
			motScore.put(mot, 0);
			for(int i = 0; i < mot.length(); i++){
					motScore.put(mot,motScore.get(mot)+lettreFreq.get(mot.charAt(i)));
			}
		}
		return sortList(motScore,v.getDomain());
	}
	
	private HashMap<Character, Integer> heuristique (List<String> liste) {
		HashMap<Character, Integer> dictionnaire = new HashMap<Character, Integer>();
		for(String mot : liste) {
			for(int i = 0; i < mot.length(); i++) {
				if (!dictionnaire.containsKey(mot.charAt(i)))
					dictionnaire.put(mot.charAt(i), 1);
				else
					dictionnaire.put(mot.charAt(i),dictionnaire.get(mot.charAt(i))+1);
			}
		}
		return dictionnaire;
	}
	
	private List<String> sortList(HashMap<String, Integer> motScore, List<String> list){
		List<String> newList = new ArrayList<String>(); 
		String tmp;
		while(list.size()>0) {
			tmp= list.get(0);
			for(int i=1; i< list.size();i++ ) {
				if(motScore.get(list.get(i))<motScore.get(tmp)) {
					tmp=list.get(i);
				}
			}
			newList.add(tmp);
			motScore.remove(tmp);
			list.remove(tmp);
		}
		return newList;
	}
}
