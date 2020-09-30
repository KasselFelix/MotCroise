package pobj.motx.tme1;

public class Grille {
	
	private int hauteur;
    private int largeur;
    private Case[][] m;
   
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
    public String toString(){
    	return GrilleLoader.serialize(this,false);
    	
    }

    public int nbLig(){
        return hauteur;
    }
    
    public int nbCol(){
        return largeur;
    }
    
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
}
