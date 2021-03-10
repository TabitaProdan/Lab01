package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTempoEsecuzione;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double start = System.nanoTime();
  
    	elenco.addParola(this.txtParola.getText());
    	
    	String stringaStampa = "";
    	for (String ss: elenco.getElenco()) {
    		stringaStampa += ss +"\n";
    	}
   
    	this.txtResult.setText(stringaStampa);
    	
    	this.txtParola.clear();
    	
    	double stop = System.nanoTime();
    	
    	this.txtTempoEsecuzione.setText("" + (stop - start));
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	double start = System.nanoTime();
    	
    	elenco.reset();
    	this.txtResult.clear();	
    	
    	double stop = System.nanoTime();
    	
    	this.txtTempoEsecuzione.setText("" + (stop - start));
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	double start = System.nanoTime();
    	
    	String s = this.txtResult.getSelectedText();
    	elenco.cancella(s);
    	
    	this.txtResult.clear();

    	String stringaStampa = "";
    	for (String ss: elenco.getElenco()) {
    		stringaStampa += ss +"\n";
    	}
   
    	this.txtResult.setText(stringaStampa);
    	
    	double stop = System.nanoTime();
    	
    	this.txtTempoEsecuzione.setText("" + (stop - start));

    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
