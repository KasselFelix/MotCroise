package pobj.motx.tme1;
/**
 * Classe de representation d'une grille de mots croises
 */
public class Grille {
	/** hauteur de la grille*/
	private int hauteur;
	/** largeur de la grille*/
    private int largeur;
    /** matrice de representation de la grille*/
    private Case[][] m;
    /**
     * Construit une grille avec hauteur lignes et largeur colonnes
     * @param hauteur nombre de lignes de la grille
     * @param largeur nombre de colonnes de la grille
     */
    public Grille(int hauteur, int largeur){
        this.hauteur=hauteur;
        this.largeur=largeur;
        m=new Case[hauteur][largeur];
        for(int i=0;i<hauteur;i++){
            for(int j=0;j<largeur;j++){
            	m[i][j]=new Case(i,j,' ');
            }
        }
    }
    /**
     * Accede a une case de la grille
     * @param lig numero de ligne de la case
     * @param col numero de colonne de la case
     * @return la case aux coordonnees lig et col
     */
    public Case getCase(int l,int c){
    	try {
    		return m[l][c];
    	}
    	catch(Exception e) {
    		System.out.println("grille "+hauteur+"*"+largeur );
    		System.out.println("ERROR BOUND : ["+l+"] ["+c+"]" );
    		return null;
    	}
    }
    /**
     * Accede au nombre de lignes de la grille
     * @return le nombre de lignes
     */
    public int nbLig(){
        return hauteur;
    }
    /**
     * Accede au nombre de colonnes de la grille
     * @return le nombre de colonnes
     */
    public int nbCol(){
        return largeur;
    }
    /**
     * Accede au nombre de colonnes de la grille
     * @return le nombre de colonnes
     */
    public Grille copy(){
        int l=nbLig();
        int c=nbCol();
        Grille g=new Grille(l,c);
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++){
                g.m[i][j]=new Case(i,j,m[i][j].getChar());
            }
        }
        return g;
    }
    
    public String toString(){
    	return GrilleLoader.serialize(this,false);
    }
}
