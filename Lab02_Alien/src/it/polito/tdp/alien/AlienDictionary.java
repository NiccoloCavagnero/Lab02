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
			
			LinkedList<Word> lista = new LinkedList<Word>();
			String[] sp = alienWord.split("[?]");
			
			if ( sp.length == 2 ) {
			  String s1 = sp[0];
			  String s2 = sp[1];
			
			  for ( String s3 : mappa.keySet() ) 
			  	  if ( s3.contains(s1) && s2.contains(s2) )
					   lista.add(mappa.get(s3));
			  
			}
			else {
				  for ( String s3 : mappa.keySet() ) 
				  	  if ( s3.contains(sp[0]) )
						   lista.add(mappa.get(s3));
			}
			
			if ( lista.size() == 0 )
			    return null;
			else if ( lista.size() == 1 )
				 return lista.get(0).getTranslation();
			else {
				String s = "Possibili matches multipli:";
				for ( Word w : lista )
					s += "\n"+w.getTranslation();
				return s;
			}
		}
		else
			return null;
	}

}
