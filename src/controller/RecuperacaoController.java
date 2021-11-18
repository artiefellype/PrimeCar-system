package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bo.AdminBO;
import model.vo.AdminVO;
import view.Telas;

public class RecuperacaoController {
	
	    @FXML
	    private TextField recuperaEmailField;

	    @FXML
	    private Label warningTextField;

	    
	    AdminBO<AdminVO> admin = new AdminBO<AdminVO>();
	    
	    
	    @FXML
	    void sendEmail() {
	    	AdminVO adm = new AdminVO();
	    	adm.setEmail(recuperaEmailField.getText());
	    	
	    	try {
	    		
	    		if(admin.findByEmail(adm).isEmpty()) {
	    			warningTextField.setText("EMAIL NÃO ENCONTRADO");
	    		}else {
	    			warningTextField.setText("ENVIAMOS UMA SENHA TEMPORÁRIA PARA O SEU EMAIL");
	    		}
	    	}catch(Exception e) {
	    		System.out.println("ERROR@>>" + e);
	    	}
	    	
	    }
	    
	    public void toLogin(ActionEvent event){
	    	try {
	    		Telas.telaDeLogin();
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }
}
