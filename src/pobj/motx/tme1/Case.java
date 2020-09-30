package pobj.motx.tme1;


public class Case {
	
	private int lig;
    private int col;
    private char ch;
    
    public Case(int lig,int col,char c){
        this.lig=lig;
        this.col=col;
        ch=c;
    }
    public int getLig(){
        return lig;
    }
    public int getCol(){
        return col;
    }
    public char getChar(){
        return ch;
    }
    public void setChar(char c){
        ch=c;
    }
    public boolean isVide(){
        return ch ==' ';
    }
    public boolean isPleine(){
        return ch=='*';

    }
    
    public String toString() {
    	String s =""+ch;
    	return s;
    }
}
