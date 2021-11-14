package controller;


import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.ClienteBO;
import model.vo.ClienteVO;
import view.Telas;

public class ClientController {
	
	// ---------------- Clientes functions --------------------------
    
	 @FXML
	    private TextField clienteInput;

	    @FXML
	    private TableView<ClienteVO> clienteTableView;

	    @FXML
	    private TableColumn<ClienteVO, String> clientesCpfColumn;

	    @FXML
	    private TableColumn<ClienteVO, String> clientesEnderecoColumn;

	    @FXML
	    private TableColumn<ClienteVO, String> clientesIconColumn;

	    @FXML
	    private TableColumn<ClienteVO, String> clientesNomeColumn;
	    
	    
	    ObservableList<ClienteVO> obsClienteList = FXCollections.observableArrayList();
		 ClienteBO<ClienteVO> clientes = new ClienteBO<ClienteVO>();
		 
		 @FXML
		   	public void loadDataClientes() {
				obsClienteList.clear();
				
		    	clientesNomeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		    	clientesEnderecoColumn.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		    	clientesCpfColumn.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		    	
		    	
		    	List<ClienteVO> cli = clientes.listarBO();
		    	
		    	for(ClienteVO cliShow : cli) {
		    		System.out.println(cliShow.getCPF());
		    		
		    		ClienteVO cliList = new ClienteVO();
		    		cliList.setName(cliShow.getName());
		    		cliList.setEndereco(cliShow.getEndereco());
		    		cliList.setCPF(cliShow.getCPF());
		    		
		    		obsClienteList.add(cliList);
		    		clienteTableView.setItems(obsClienteList);
		    		
		 		}
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
