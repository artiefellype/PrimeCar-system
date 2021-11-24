package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.AdminBO;
import model.vo.AdminVO;
import view.Telas;

public class CadastroController {

	 	@FXML
	    private TextField cadastroEmailField;

	    @FXML
	    private TextField cadastroNomeField;

	    @FXML
	    private PasswordField cadastroSenhaField;
	    
	    @FXML
	    private Label warningTextField;
	    
	    AdminBO<AdminVO> admin = new AdminBO<AdminVO>();
	    
	    public void register() {
	    	AdminVO adm = new AdminVO();
	    	adm.setName(cadastroNomeField.getText());
	    	adm.setEmail(cadastroEmailField.getText());
	    	adm.setSenha(cadastroSenhaField.getText());
	    	try {
	    		if(admin.findByName(adm).isEmpty()) {
	    			admin.cadastrar(adm);
	    			warningTextField.setText("CADASTRO FEITO COM SUCESSO");
	    		}else{
	    			warningTextField.setText("NICKNAME JÁ ESTÁ SENDO USADO");
	    			throw new Exception("O sistema já possui um administrador com esse nickname");
	    		};
	    	}catch(Exception e) {
	    		System.out.println("ERROR: @>>" + e);
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
