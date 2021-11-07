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
import model.bo.AutoBO;
import model.vo.AutoVO;
import view.Telas;

public class AutoController {
	
	 @FXML
     private ListView<String> AutoListAno;

     @FXML
     private ListView<String> AutoListCliente;

     @FXML
     private ListView<String> AutoListCor;

     @FXML
     private ListView<String> AutoListKm;

     @FXML
     private ListView<String> AutoListMarca;

     @FXML
     private ListView<String> AutoListPlaca;

    // @FXML
     //private TextField clienteInput;
     
     private ObservableList<String> obsAutoListAno;
	 private ObservableList<String> obsAutoListCliente;
	 private ObservableList<String> obsAutoListCor;
	 private ObservableList<String> obsAutoListKm;
	 private ObservableList<String> obsAutoListMarca;
	 private ObservableList<String> obsAutoListPlaca;
	 
	 
	 private List<String> autoAno = new ArrayList<>();
	 private List<String> autoCliente = new ArrayList<>();
	 private List<String> autoCor = new ArrayList<>();
	 private List<String> autoKm = new ArrayList<>();
	 private List<String> autoMarca = new ArrayList<>();
	 private List<String> autoPlaca = new ArrayList<>();
     
	 AutoBO<AutoVO> automo = new AutoBO<AutoVO>();
	 
	// Carregar Automoveis cadastrados
	 
	 public void loadDataAuto() {
		//removendo caso já esteja na tela
		 if(obsAutoListMarca != null) {
	    		autoAno.removeAll(autoAno);
	    		autoCliente.removeAll(autoCliente);
	    		autoCor.removeAll(autoCor);
	    		autoKm.removeAll(autoKm);
	    		autoMarca.removeAll(autoMarca);
	    		autoPlaca.removeAll(autoPlaca);
	    	 }
	    	 
	    	 AutoListAno.refresh();
	    	 AutoListCliente.refresh();
	    	 AutoListCor.refresh();
	    	 AutoListKm.refresh();
	    	 AutoListMarca.refresh();
	    	 AutoListPlaca.refresh();
	    	 
	    	 
	    	 List<AutoVO> automoveis = automo.listarBO();
	    	 //Adicionando propriedades selecionadas da lista AutoVO a cada lista de strings
	    	 for(AutoVO autoShow : automoveis) {
		 			autoAno.add((autoShow.getAno()).toString());
		 			autoCliente.add(autoShow.getProprietario().getCPF());
		 			autoCor.add(autoShow.getCor());
		 			autoKm.add((autoShow.getQuilometragem()).toString());
		 			autoMarca.add(autoShow.getMarca());
		 			autoPlaca.add(autoShow.getPlaca());
		 		}
	    	 
	    	 // Transformando as listas de strings já preenchidas em listas observáveis
	    	 obsAutoListAno = FXCollections.observableArrayList(autoAno);
	    	 obsAutoListCliente = FXCollections.observableArrayList(autoCliente);
	    	 obsAutoListCor = FXCollections.observableArrayList(autoCor);
	    	 obsAutoListKm = FXCollections.observableArrayList(autoKm);
	    	 obsAutoListMarca = FXCollections.observableArrayList(autoMarca);
	    	 obsAutoListPlaca = FXCollections.observableArrayList(autoPlaca);
	    	 
	    	 System.out.println(autoCliente);
	    	 // Pondo as listas observáveis dentro do listview da tela para visualização
	    	 AutoListAno.setItems(obsAutoListAno);
	    	 AutoListCliente.setItems(obsAutoListCliente);
	    	 AutoListCor.setItems(obsAutoListCor);
	    	 AutoListKm.setItems(obsAutoListKm);
	    	 AutoListMarca.setItems(obsAutoListMarca);
	    	 AutoListPlaca.setItems(obsAutoListPlaca);
	    	 
	    	 
	    	 /* Fazendo com que cada listview 'escute' o scroll do outro
	    	  para que possam realizar a ação do scroll em conjunto
	    	 */
	    	 Node n1 = AutoListMarca.lookup(".scroll-bar");
	         if (n1 instanceof ScrollBar) {
	             final ScrollBar bar1 = (ScrollBar) n1;
	             Node n2 = AutoListCor.lookup(".scroll-bar");
	             if (n2 instanceof ScrollBar) {
	                 final ScrollBar bar2 = (ScrollBar) n2;
	                 Node n3 = AutoListPlaca.lookup(".scroll-bar");
	                 if (n3 instanceof ScrollBar) {
		                 final ScrollBar bar3 = (ScrollBar) n3;
		                 Node n4 = AutoListAno.lookup(".scroll-bar");
		                 if (n4 instanceof ScrollBar) {
			                 final ScrollBar bar4 = (ScrollBar) n4;
			                 Node n5 = AutoListKm.lookup(".scroll-bar");
			                 if (n5 instanceof ScrollBar) {
				                 final ScrollBar bar5 = (ScrollBar) n5;
				                 Node n6 = AutoListCliente.lookup(".scroll-bar");
				                 if (n6 instanceof ScrollBar) {
					                 final ScrollBar bar6 = (ScrollBar) n6;
					                 bar1.valueProperty().bindBidirectional(bar2.valueProperty());
					                 bar2.valueProperty().bindBidirectional(bar3.valueProperty());
					                 bar3.valueProperty().bindBidirectional(bar4.valueProperty());
					                 bar4.valueProperty().bindBidirectional(bar5.valueProperty());
					                 bar5.valueProperty().bindBidirectional(bar6.valueProperty());
				                 }
				                 
			                 }
		                 }
		                 
	                 }    
	             }
	         }
	    	 
	    	 
	 }
	 
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
