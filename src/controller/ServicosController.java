package controller;


import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.bo.ServicoBO;
import model.vo.ServicosVO;
import view.Telas;

public class ServicosController {
	
	@FXML
    private TableView<ServicosVO> servicosTableView;

    @FXML
    private TableColumn<ServicosVO, String> servicosColumnCarro;
    @FXML
    private TableColumn<ServicosVO, String> servicosColumnFinalizado;

    @FXML
    private TableColumn<ServicosVO, String> servicosColumnNome;

    @FXML
    private TableColumn<ServicosVO, String> servicosColumnValor;

    @FXML
    private TableColumn<?, ?> servicosIcons;
    
	 ObservableList<ServicosVO> obsServicosList = FXCollections.observableArrayList();
	 ServicoBO<ServicosVO> servicos = new ServicoBO<ServicosVO>();
	 
	@FXML
    public void loadDataServicos() {
		obsServicosList.clear();
		
    	servicosColumnNome.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	servicosColumnFinalizado.setCellValueFactory(new PropertyValueFactory<>("finalizado"));
    	servicosColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	servicosColumnCarro.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ServicosVO, String>, ObservableValue<String>>(){
    		@Override    
    	    public ObservableValue<String> call(CellDataFeatures<ServicosVO, String> c) {
    	        return new SimpleStringProperty(c.getValue().getAuto().getPlaca());
    	    }
    	});
    	
    	List<ServicosVO> servs = servicos.listarBO();
    	
    	for(ServicosVO servShow : servs) {
    		System.out.println(servShow.getTipo());
    		ServicosVO servList = new ServicosVO();
    		servList.setTipo(servShow.getTipo());
    		servList.setValor(servShow.getValor());
    		servList.setFinalizado(servShow.getFinalizado());
    		servList.setAuto(servShow.getAuto());
    		
    		obsServicosList.add(servList);
    		servicosTableView.setItems(obsServicosList);
    		
 		}
    }
	
	public void refreshTable() {
		obsServicosList.clear();
		loadDataServicos();
	}
    
	
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


}
