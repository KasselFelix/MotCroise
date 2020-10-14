package pobj.motx.tme2;
/**
 * classe representant la contrainte de croisement entre deux mots
 */
public class CroixContrainte implements IContrainte {
	/**m1 l'indice du premier emplacement dans la liste d'emplacement */
	private int m1;
	/**c1 l'indice de la case de l'emplacement m1 ou il ya croisement avec m2*/
	private int c1;
	/**m2 l'indice du second emplacement dans la liste d'emplacement*/
	private int m2;
	/**c2 l'indice de la case de l'emplacement m2 ou il ya croisement avec m1*/
	private int c2;
	/**
	 * construit une contrainte de croisement a  partir des parametres m1,c1,m2,c2
	 * @param m1 indice du premier emplacement
	 * @param c1 indice de la case de l'emplacement m1 ou il ya croisement avec m2
	 * @param m2 indice du second emplacement
	 * @param c2 indice de la case de l'emplacement m2 ou il ya croisement avec m1
	 */
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1=m1;
		this.c1=c1;
		this.m2=m2;
		this.c2=c2;
	}
	/**
	 * modifie la grille passee en argument
	 * @param gp grille potentiel 
	 * @return le nombre total de mots filtres par son action
	 */
	public int reduce(GrillePotentiel gp) {
		
		Dictionnaire dE1=gp.getMotsPot().get(m1);//Domaine potentiel de l'emplacement m1
		Dictionnaire dE2=gp.getMotsPot().get(m2);//Domaine potentiel de l'emplacement m2
		
		//ensemble des lettres potentiel de la case c1 de l’emplacement m1 d’après les mots de dE1
		/*EnsembleLettre lettresPotentiel1=new EnsembleLettre();
		for(String mot : dE1.getMots()) 
			lettresPotentiel1.add(mot.charAt(c1));*/
		EnsembleLettre lettresPotentiel1=dE1.charAt(c1);
		
		//ensemble des lettres potentiel de la case c2 de l’emplacement m2 d’après les mots de dE2
		/*EnsembleLettre lettresPotentiel2=new EnsembleLettre();
		for(String mot : dE2.getMots())
			lettresPotentiel2.add(mot.charAt(c2));*/
		EnsembleLettre lettresPotentiel2=dE2.charAt(c2);
		
		EnsembleLettre s = lettresPotentiel1.intersection(lettresPotentiel2);//intersection de lettresPotentiel1 et lettresPotentiel2
		int nbMotsFiltre=0;//nombre de mots filtres par reduce() 
		//Si lettresPotentiel1 > s
		if(lettresPotentiel1.size()>s.size())
				nbMotsFiltre+=dE1.filtrageParLettre(c1,s);//filtrage des mots potentiels de l’emplacement m1 ,conservation uniquement des mots avec la c1-ième lettre dans s
		 //Si lettresPotentiel2 > s
		if(lettresPotentiel2.size()>s.size())
				nbMotsFiltre+=dE2.filtrageParLettre(c2, s);//filtrage des mots potentiels de l’emplacement m2 ,conservation uniquement des mots avec la c1-ième lettre dans s
		
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
	/**
	 * Accede a l'indice du premier emplacement dans la liste d'emplacement
	 * @return m1
	 */
	public int getM1() {
		return m1;
	}
	/**
	 * Accede a l'indice de la case de l'emplacement m1 ou il ya croisement avec m2
	 * @return c1
	 */
	public int getC1() {
		return c1;
	}
	/**
	 * Accede a l'indice du second emplacement dans la liste d'emplacement
	 * @return m2
	 */
	public int getM2() {
		return m2;
	}
	/**
	 * Accede a l'indice de la case de l'emplacement m2 ou il ya croisement avec m1
	 * @return c2
	 */
	public int getC2() {
		return c2;
	}
	

}
