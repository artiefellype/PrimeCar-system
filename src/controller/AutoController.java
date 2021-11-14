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
import model.bo.AutoBO;
import model.vo.AutoVO;
import view.Telas;

public class AutoController {
	
	
	// --------------- Automoveis functions ------------------------------
	@FXML
    private TableColumn<AutoVO, String> autoColumnAno;

    @FXML
    private TableColumn<AutoVO, String> autoColumnCliente;

    @FXML
    private TableColumn<AutoVO, String> autoColumnCor;

    @FXML
    private TableColumn<AutoVO, String> autoColumnKm;

    @FXML
    private TableColumn<AutoVO, String> autoColumnMarca;

    @FXML
    private TableColumn<AutoVO, String> autoColumnPlaca;

    @FXML
    private TableView<AutoVO> autoTableView;

    @FXML
    private TextField clienteInput;
    
    ObservableList<AutoVO> obsAutoList = FXCollections.observableArrayList();
	 AutoBO<AutoVO> automoveis = new AutoBO<AutoVO>();
	 
	 @FXML
	    public void loadDataAuto() {
			obsAutoList.clear();
			
	    	autoColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
	    	autoColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
	    	autoColumnCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
	    	autoColumnAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
	    	autoColumnKm.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
	    	autoColumnCliente.setCellValueFactory(
	    		new Callback<TableColumn.CellDataFeatures<AutoVO, String>, ObservableValue<String>>(){
	    			
	    		@Override    
	    	    public ObservableValue<String> call(CellDataFeatures<AutoVO, String> c) {
	    	        return new SimpleStringProperty(c.getValue().getProprietario().getCPF());
	    	    		}
	    		
	    		}
	    	);
	    	
	    	List<AutoVO> auto = automoveis.listarBO();
	    	
	    	for(AutoVO autoShow : auto) {
	    		System.out.println(autoShow.getMarca());
	    		
	    		AutoVO autoList = new AutoVO();
	    		autoList.setMarca(autoShow.getMarca());
	    		autoList.setPlaca(autoShow.getPlaca());
	    		autoList.setCor(autoShow.getCor());
	    		autoList.setAno(autoShow.getAno());
	    		autoList.setQuilometragem(autoShow.getQuilometragem());
	    		autoList.setProprietario(autoShow.getProprietario());
	    		
	    		obsAutoList.add(autoList);
	    		autoTableView.setItems(obsAutoList);
	    		
	 		}
	 }
	    	 
 // --------------- END Automoveis functions ------------------------------    	 
	 
	 
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
