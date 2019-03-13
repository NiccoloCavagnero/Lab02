package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {
	
	private String alienWord;
	protected LinkedList<String> translations;
	
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
		translations = new LinkedList<String>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public LinkedList<String> getTranslations() {
		return translations;
	}

	public void setTranslations(LinkedList<String> translations) {
		this.translations = translations;
	}

	public boolean equals( Object obj) {
		
		if ( this.alienWord.compareTo(obj.toString().toLowerCase()) == 0 )
			return true;
		else 
		    return false;
	}

}
