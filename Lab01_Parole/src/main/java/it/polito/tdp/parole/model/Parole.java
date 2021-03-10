package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> parole;
		
	public Parole() {
		parole = new LinkedList <>();
	}
	
	private class OrdinaParoleAlfabeticamente implements Comparator <String>{

		@Override
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	}
	
	public void addParola(String p) {
		parole.add(p);
		Collections.sort(parole, new OrdinaParoleAlfabeticamente());
	}

	public List<String> getElenco() {
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

	
	public void cancella (String s) {
		parole.remove((String)s);
	}

}
