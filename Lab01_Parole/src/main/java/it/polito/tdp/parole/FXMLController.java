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
	long tempoTot=0;

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
    void doInsert(ActionEvent event) {
    	String parola = txtParola.getText();
    	elenco.addParola(parola);
    	btnCancella.setDisable(false);
    	txtParola.clear();
    	String s="";
    	for (int i=0; i<elenco.getElenco().size(); i++)
    		s+=elenco.getElenco().get(i)+"\n";
    	txtResult.setText(s);
    	calcolaTempo(System.nanoTime());
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    	txtResult.appendText("Lista vuota");
    	calcolaTempo(System.nanoTime());
    }
    

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTime;

    @FXML
    void doCancella(ActionEvent event) {
    	elenco.removeParola(txtResult.getSelectedText());
    	String s="";
    	for (int i=0; i<elenco.getElenco().size(); i++)
    		s+=elenco.getElenco().get(i)+"\n";
    	txtResult.setText(s);
    	
    	if (elenco.getElenco().size()==0)
    		btnCancella.setDisable(true);
    	calcolaTempo(System.nanoTime());
    }

    void calcolaTempo(long t) {
    	tempoTot+=t;
    	System.out.println(tempoTot);
    	txtTime.appendText(Long.toString(t)+"\n");
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
