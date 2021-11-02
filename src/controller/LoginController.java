package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.AdminBO;
import model.bo.ClienteBO;
import model.vo.AdminVO;
import model.vo.ClienteVO;
import view.Telas;

public class LoginController{
	
		
	
	 	@FXML
	    private TextField loginText;
	    @FXML
	    private PasswordField passText;
	    
	    
	    
	    // ---------------- Admin functions --------------------------
	    AdminBO<AdminVO> admin = new AdminBO<AdminVO>();
	    public void autenticate(ActionEvent event) {
	    	AdminVO adm = new AdminVO();
	    	adm.setName(loginText.getText());
	    	adm.setSenha(passText.getText());
	    	System.out.println("Foi");
	    	
	    	try {
	    		if(admin.login(adm)) {
	    			Telas.telaDeSplash();
	    			//Abrir splashScreen
	    		}else {
	    			throw new Exception("Administrador não encontrado");
	    		}
	    	}catch(Exception e) {
	    		System.out.print(e);
	    	}
	    	
	    }
	    
	 // ---------------- END Admin functions --------------------------
	    @FXML
	    private ListView<String> clienteListCpf;

	    @FXML
	    private ListView<String> clienteListEndereco;

	    @FXML
	    private ListView<String> clienteListNome;
	 
	    private ObservableList<String> obsClientNames;
	    private ObservableList<String> obsClientEnder;
	    private ObservableList<String> obsClientCpf;
	    
	    private List<String> clientNames = new ArrayList<>();
	    private List<String> clientEnderecos = new ArrayList<>();
	    private List<String> clientCpfs = new ArrayList<>();
	    
	    
	 // ---------------- Clientes functions --------------------------
	    ClienteBO<ClienteVO> client = new ClienteBO<ClienteVO>();
	    
	     public void loadDataClientes() {
	    	 //list.removeAll(list);
	    	 List<ClienteVO> clientes = client.listarBO();
	    	 
	    	 for(ClienteVO clientesShow : clientes) {
	 			clientNames.add(clientesShow.getName());
	 			clientEnderecos.add(clientesShow.getEndereco());
	 			clientCpfs.add(clientesShow.getCPF());
	 		}
	    	 
	    	 obsClientNames = FXCollections.observableArrayList(clientNames);
	    	 obsClientEnder = FXCollections.observableArrayList(clientEnderecos);
	    	 obsClientCpf = FXCollections.observableArrayList(clientCpfs);
	    	 
	    	 System.out.println(clientNames);
	    	 
	    	 clienteListNome.setItems(obsClientNames);
	    	 clienteListEndereco.setItems(obsClientEnder);
	    	 clienteListCpf.setItems(obsClientCpf);
	    	 
	    	 
	    	 
	     }
	 // ---------------- END Clientes functions --------------------------
	    
	    
	    
	    
	    public void toClientes(ActionEvent event){
	    	try {
	    		Telas.telaDeClientes();
	    		
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }
	    public void toAutomoveis(ActionEvent event){
	    	try {
	    		Telas.telaDeAutomoveis();
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }  public void toPecas(ActionEvent event){
	    	try {
	    		Telas.telaDePecas();
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }
	    public void toServicos(ActionEvent event){
	    	try {
	    		Telas.telaDeServicos();
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }
	    public void toOrcamentos(ActionEvent event){
	    	try {
	    		Telas.telaDeOrcamentos();
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }
	    
	    public void logout(ActionEvent event){
	    	try {
	    		Telas.telaDeLogin();
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }

}
