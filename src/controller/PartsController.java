package controller;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.bo.PecaBO;
import model.vo.PecasVO;
import view.Telas;

public class PartsController {
	// ---------------- pecas functions -------------------------
	 	@FXML
	    private TextField clienteInput;

	    @FXML
	    private TableColumn<PecasVO, String> pecasColumnCarro;

	    @FXML
	    private TableColumn<PecasVO, String> pecasColumnFabricante;

	    @FXML
	    private TableColumn<PecasVO, String> pecasColumnNome;

	    @FXML
	    private TableColumn<PecasVO, String> pecasColumnPreco;

	    @FXML
	    private TableView<PecasVO> pecasTableView;
	    
	    ObservableList<PecasVO> obsPecasList = FXCollections.observableArrayList();
		 PecaBO<PecasVO> parts = new PecaBO<PecasVO>();
		 
		 @FXML
		    public void loadDataPecas() {
				obsPecasList.clear();
				// pecasColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
		    	pecasColumnNome.setCellValueFactory(new PropertyValueFactory<>("name"));
		    	pecasColumnFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
		    	pecasColumnPreco.setCellValueFactory(new 
		    			Callback<TableColumn.CellDataFeatures<PecasVO, String>, ObservableValue<String>>(){
		    			@Override
		    			public ObservableValue<String> call(CellDataFeatures<PecasVO, String> c){
		    				return new SimpleStringProperty("R$ " + c.getValue().getPreco());
		    			}
		    	});
		    	pecasColumnCarro.setCellValueFactory(new
		    			Callback<TableColumn.CellDataFeatures<PecasVO, String>, ObservableValue<String>>(){
		    		@Override    
		    	    public ObservableValue<String> call(CellDataFeatures<PecasVO, String> c) {
		    	        return new SimpleStringProperty(c.getValue().getAuto().getPlaca());
		    	    }
		    	});
		    	
		    	List<PecasVO> pecas = parts.listarBO();
		    	
		    	for(PecasVO partShow : pecas) {
		    		System.out.println(partShow.getAuto().getPlaca());
		    		
		    		PecasVO partList = new PecasVO();
		    		partList.setName(partShow.getName());
		    		partList.setFabricante(partShow.getFabricante());
		    		partList.setPreco(partShow.getPreco());
		    		partList.setAuto(partShow.getAuto());
		    		
		    		obsPecasList.add(partList);
		    		pecasTableView.setItems(obsPecasList);
		    		
		 		}
		    	
		 }	
	// ---------------- END pecas functions -------------------------
	// --------------------------- Funções comuns ---------------------------------------
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
 // -------------------- END functions comuns ----------------------------
}
