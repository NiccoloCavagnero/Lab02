package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    AlienDictionary A = new AlienDictionary();
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	if ( txtWord.getText().contains(" ")  ) {
    		StringTokenizer st = new StringTokenizer(txtWord.getText()," ");
    		String alienWord = st.nextToken();
    		String translation = st.nextToken();
    		
    		if ( alienWord.matches("[a-zA-Z]+") && translation.matches("[a-zA-Z]+") ) {
    		   A.addWord(alienWord, translation);
    		   txtResult.appendText("\nParola e traduzione aggiunte con successo al dizionario!");
    		}
    		else
    			txtResult.appendText("\nCarattere non valido: sono possibili solo caratteri alfabetici!");
    	}
    	else {
    		if ( !txtWord.getText().matches("[a-zA-Z]+") )
    		    txtResult.appendText("\nCarattere non valido: Sono possibili solo caratteri alfabetici!");
    		else if ( A.translateWord(txtWord.getText()) == null ) 
    			txtResult.appendText("\nTraduzione non trovata.");	
    		else
    			txtResult.appendText("\n"+A.translateWord(txtWord.getText()));
    	}
	   txtWord.clear();	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
            txtResult.clear();
            
    }
    
}
