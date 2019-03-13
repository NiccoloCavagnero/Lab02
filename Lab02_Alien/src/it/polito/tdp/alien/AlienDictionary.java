package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	protected LinkedList<Word> dictionary;
	protected Map<String,Word> mappa;
	
	public AlienDictionary() {
		dictionary = new LinkedList<Word>();
		mappa = new TreeMap<String,Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		Word w = new Word(alienWord.toLowerCase(),translation.toLowerCase());
		
		if ( mappa.containsKey(alienWord.toLowerCase()) ) {
			Word oldWord = mappa.get(alienWord.toLowerCase());
			dictionary.remove(oldWord);
			dictionary.add(w);
			mappa.replace(alienWord.toLowerCase(), w);
		}
		else {
			dictionary.add(w);
			mappa.put(alienWord.toLowerCase(), w);
		}
		   
	}
	
	public String translateWord(String alienWord) {
		
		if ( mappa.containsKey(alienWord.toLowerCase() )) {
			return mappa.get(alienWord).getTranslation().toLowerCase();
		}
		else if ( alienWord.contains("?") ) {
			StringTokenizer st = new StringTokenizer(alienWord,"?");
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			for ( String s3 : mappa.keySet() ) {
				if ( s3.contains(s1) && s2.contains(s2) )
					return mappa.get(s3).getTranslation().toLowerCase();
			}
			return null;
		}
		else
			return null;
	}

}
