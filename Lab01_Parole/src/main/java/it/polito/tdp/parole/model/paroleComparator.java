package it.polito.tdp.parole.model;

import java.util.Comparator;

public class paroleComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.toUpperCase().compareTo(o2.toUpperCase());
	}

}
