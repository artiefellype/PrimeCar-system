package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.AdminBO;
import model.vo.AdminVO;
import view.Telas;

public class LoginController {
	
	 	@FXML
	    // The reference of inputText will be injected by the FXML loader
	    private TextField loginText;
	    @FXML
	    private PasswordField passText;
	    
	    
	    AdminBO<AdminVO> admin = new AdminBO<AdminVO>();
	    public void autenticate(ActionEvent event) {
	    	AdminVO adm = new AdminVO();
	    	adm.setName(loginText.getText());
	    	adm.setSenha(passText.getText());
	    	System.out.println("Foi");
	    	
	    	try {
	    		AdminVO AdminAutenticado = new AdminVO();
	    		if(AdminAutenticado instanceof AdminVO) {
	    			System.out.println("Foi no instance");
	    			Telas.telaDeSplash();
	    			//Abrir splashScreen
	    		}else {
	    			System.out.println("Foi não");
	    		}
	    	}catch(Exception e) {
	    		System.out.print(e);
	    	}
	    	
	    }

}
