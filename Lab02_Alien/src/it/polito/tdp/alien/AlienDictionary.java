package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	protected LinkedList<WordEnhanced> dictionary;
	protected Map<String,WordEnhanced> mappa;
	
	public AlienDictionary() {
		dictionary = new LinkedList<WordEnhanced>();
		mappa = new TreeMap<String,WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		WordEnhanced w = new WordEnhanced(alienWord.toLowerCase());
		
		if ( mappa.containsKey(alienWord.toLowerCase()) ) {
			WordEnhanced oldWord = mappa.get(alienWord.toLowerCase());
			
	        if ( !oldWord.translations.contains(translation) )
	        	oldWord.translations.add(translation);
		}
		else {
			dictionary.add(w);
			mappa.put(alienWord.toLowerCase(), w);
			w.translations.add(translation);
		}
		   
	}
	
	public String translateWord(String alienWord) {
		
		String s = "";
		
		if ( mappa.containsKey(alienWord.toLowerCase() )) {
			for ( String st : mappa.get(alienWord).getTranslations() ) {
				s += st+", ";
			}
			return s.substring(0, s.length()-2)+".";
		}
		else
			return null;
	}

}
