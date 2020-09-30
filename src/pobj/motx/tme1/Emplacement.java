package pobj.motx.tme1;

import java.util.ArrayList;

public class Emplacement{
    
	private ArrayList<Case>lettres;
    
    public Emplacement(){
        lettres=new ArrayList<Case>();

    }
    
    public String toString(){
    	String s="";
    	for(int i=0;i<lettres.size();i++) {
    		s+=lettres.get(i).toString();
    	}
    	s+="\n";
        return s;
    }
    
    public int size(){
        return lettres.size();

    }
    
    public void add(Case c) {
    	lettres.add(c);
    }
    
}