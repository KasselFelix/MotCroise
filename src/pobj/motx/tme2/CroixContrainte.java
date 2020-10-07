package pobj.motx.tme2;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;

import java.util.ArrayList;

public class CroixContrainte implements IContrainte {
	
	private int m1;
	private int c1;
	private int m2;
	private int c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1=m1;
		this.c1=c1;
		this.m2=m2;
		this.c2=c2;
	}
	
	public int reduce(GrillePotentiel gp) {
		Emplacement Em1 = gp.getGp().getPlaces().get(m1);
		Case caseC1 = Em1.getLettres().get(c1);
		Dictionnaire dE1=gp.getMotsPot().get(m1);
		int nbLPC1=0;
		
		Emplacement Em2 = gp.getGp().getPlaces().get(m2);
		Case caseC2 = Em2.getLettres().get(c2);
		Dictionnaire dE2=gp.getMotsPot().get(m2);
		
		int nbLPC2=0;
		EnsembleLettre lettresPotentielC1=new EnsembleLettre();
		for(String mot : dE1.getMots()) {
			lettresPotentielC1.add(mot.charAt(c1));
		}
		nbLPC1=lettresPotentielC1.size();
		
		EnsembleLettre lettresPotentielC2=new EnsembleLettre();
		for(String mot : dE2.getMots()) {
			lettresPotentielC2.add(mot.charAt(c2));
		}
		nbLPC2=lettresPotentielC2.size();
		
		EnsembleLettre s = lettresPotentielC1.intersection(lettresPotentielC2);
		int nbLPinter=s.size();
		int nbMotsFiltre=0;
		
		if(nbLPC1>nbLPinter)
				nbMotsFiltre+=dE1.filtrageParIndice(c1,s);
		if(nbLPC2>nbLPinter) 
				nbMotsFiltre+=dE2.filtrageParIndice(c2, s);
		
		return nbMotsFiltre;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CroixContrainte))
			return false;
		CroixContrainte other = (CroixContrainte) o;
		if (c1 != other.c1)
			return false;
		if (c2 != other.c2)
			return false;
		if (m1 != other.m1)
			return false;
		if (m2 != other.m2)
			return false;
		return true;
	}

	public int getM1() {
		return m1;
	}

	public int getC1() {
		return c1;
	}

	public int getM2() {
		return m2;
	}

	public int getC2() {
		return c2;
	}
	

}
