package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import model.bo.ClienteBO;
import model.vo.ClienteVO;
import view.Telas;

public class ClientController {
	
	// ---------------- Clientes functions --------------------------
    
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
    
    ClienteBO<ClienteVO> client = new ClienteBO<ClienteVO>();
    
    // Carregar clientes cadastrados
    
     public void loadDataClientes() {
    	 //removendo caso já esteja na tela
    	 if(obsClientNames != null) {
    		clientNames.removeAll(clientNames);
    		clientEnderecos.removeAll(clientEnderecos);
    		clientCpfs.removeAll(clientCpfs);
    	 }
    	 
    	 clienteListNome.refresh();
    	 clienteListEndereco.refresh();
    	 clienteListCpf.refresh();
    	 
    	 List<ClienteVO> clientes = client.listarBO();
    	 
    	 // Adicionando propriedades selecionadas da lista ClienteVO a cada lista de strings
    	 for(ClienteVO clientesShow : clientes) {
 			clientNames.add(clientesShow.getName());
 			clientEnderecos.add(clientesShow.getEndereco());
 			clientCpfs.add(clientesShow.getCPF());
 		}
    	 
    	 // Transformando as listas de strings já preenchidas em listas observáveis
    	 obsClientNames = FXCollections.observableArrayList(clientNames);
    	 obsClientEnder = FXCollections.observableArrayList(clientEnderecos);
    	 obsClientCpf = FXCollections.observableArrayList(clientCpfs);
    	 
    	 System.out.println(clientNames);
    	 // Pondo as listas observáveis dentro do listview da tela para visualização
    	 clienteListNome.setItems(obsClientNames);
    	 clienteListEndereco.setItems(obsClientEnder);
    	 clienteListCpf.setItems(obsClientCpf);
    	 
    	 
    	 
    	 /* Fazendo com que cada listview 'escute' o scroll do outro
    	  para que possam realizar a ação do scroll em conjunto
    	 */
    	 Node n1 = clienteListNome.lookup(".scroll-bar");
         if (n1 instanceof ScrollBar) {
             final ScrollBar bar1 = (ScrollBar) n1;
             Node n2 = clienteListEndereco.lookup(".scroll-bar");
             if (n2 instanceof ScrollBar) {
                 final ScrollBar bar2 = (ScrollBar) n2;
                 Node n3 = clienteListCpf.lookup(".scroll-bar");
                 if (n3 instanceof ScrollBar) {
	                 final ScrollBar bar3 = (ScrollBar) n3;
	                 bar1.valueProperty().bindBidirectional(bar2.valueProperty());
	                 bar1.valueProperty().bindBidirectional(bar3.valueProperty());
                 }    
             }
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
