package pobj.motx.tme1;

/**
 * Classe de representation d'une Case dans une Grille de mot croise
 */
public class Case {
	/**liigne de la case*/
	private int lig;
	/**colonne de la case*/
    private int col;
    /**Character contenu dans la case*/ 
    private char ch;
    
    /**
     * Construit une Case avec une valeur initiale et des coordonnes specifiees 
     * @param lig numero de ligne de la case
     * @param col numero de colonne de la case
     * @param c
     */
    public Case(int lig,int col,char c){
        this.lig=lig;
        this.col=col;
        ch=c;
    }
    /**
     * Accede au numero de ligne de la case
     * @return le numero de la ligne de la case
     */
    public int getLig(){
        return lig;
    }
    /**
     * Accede au numero de colonne de la case
     * @return le numero de colonne de la case
     */
    public int getCol(){
        return col;
    }
    /**
     * Accede au caractere contenu dans la case
     * @return la valeur de la case
     */
    public char getChar(){
        return ch;
    }
    /**
     * met a jour la valeur de la case
     * @param c nouvelle valeur de la case
     */
    public void setChar(char c){
        ch=c;
    }
    /**
     * teste si une case est vide
     * @return True si la case est vide
     */
    public boolean isVide(){
        return ch ==' ';
    }
    /**
     * teste si une case est pleine
     * @return True si la case est pleine
     */
    public boolean isPleine(){
        return ch=='*';

    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.ch );
    	return sb.toString();
    }
}
