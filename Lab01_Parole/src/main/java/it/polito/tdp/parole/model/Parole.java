package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Parole {
	
	ArrayList<String> mappaParole;
	
	public Parole() {
		mappaParole= new ArrayList<String>();
	}
	
	public void addParola(String p) {
		mappaParole.add(p);
	}
	
	public void removeParola(String p) {
		mappaParole.remove(p);
	}
	
	public List<String> getElenco() {
		mappaParole.sort(new paroleComparator());
		return mappaParole;
	}
	
	public void reset() {
		mappaParole.clear();;
	}

}
