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
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import model.bo.OrcamentoBO;
import model.bo.ServicoBO;
import model.vo.OrcamentoVO;
import model.vo.ServicosVO;
import view.Telas;

public class BudgetController {
	// -------------------- Orcamento functions -----------------------------
	@FXML
    private TextField clienteInput;

    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnCusto;

    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnDetalhes;

    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnVeiculo;

    @FXML
    private TableColumn<OrcamentoVO, String> orcamentosColumnCliente;

    @FXML
    private TableView<OrcamentoVO> orcamentosTableView;
    
    ObservableList<OrcamentoVO> obsOrmList = FXCollections.observableArrayList();
	 OrcamentoBO<OrcamentoVO> orcamentos = new OrcamentoBO<OrcamentoVO>();

    @FXML
    void addOrcamentos() {
    	System.out.println("A ser implementado");
    }

    @FXML
    void findOrcamentos() {
    	System.out.println("A ser implementado");
    }

    @FXML
    void loadDataOrcamentos(MouseEvent event) {
    	obsOrmList.clear();
		
    	orcamentosColumnCliente.setCellValueFactory(
    			new Callback<TableColumn.CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>(){
    		@Override    
    	    public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
    	        return new SimpleStringProperty(c.getValue().getClientName().getName());
    	    }
    	});
    	orcamentoColumnVeiculo.setCellValueFactory(
    			new Callback<TableColumn.CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>(){
    		@Override    
    	    public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
    	        return new SimpleStringProperty(c.getValue().getAuto().getPlaca());
    	    }
    	});
    	orcamentosColumnCliente.setCellValueFactory(
    			new Callback<TableColumn.CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>(){
    		@Override    
    	    public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
    			
    			ServicoBO<ServicosVO> servCusto = new ServicoBO<ServicosVO>();
    			Double value = 0.0;
    			try {
    				List<ServicosVO> servs = servCusto.findByAuto(c.getValue().getAuto());
    				ServicosVO servList = new ServicosVO();
        			
        	    	for(ServicosVO servShow : servs) {
        	    		System.out.println(servShow.getValor());
        	    		
        	    		
        	    		servList.setValor(servShow.getValor());
        	    		value += servShow.getValor();
        	    		
        	 		}
    			}catch(Exception e ) {
    				System.out.println("ERRO: " + e);
    				
    			}
    			
    			
    	        return new SimpleStringProperty("R$ " + value);
    	    }
    	});
    	
    	List<OrcamentoVO> orms = orcamentos.listarBO();
    	
    	for(OrcamentoVO ormShow : orms) {
    		System.out.println(ormShow.getAuto().getPlaca());
    		
    		OrcamentoVO ormList = new OrcamentoVO();
    		ormList.setServicos(ormShow.getServicos());
    		ormList.setData(ormShow.getData());
    		ormList.setCusto(ormShow.getCusto());
    		ormList.setClientName(ormShow.getClientName());
    		ormList.setAuto(ormShow.getAuto());
    		
    		obsOrmList.add(ormList);
    		orcamentosTableView.setItems(obsOrmList);
    		
 		}

    }
	// -------------------- END Orcamento functions -------------------------
	// -------------------- Funções comuns ----------------------------------
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
	// -------------------- END funções comuns ------------------------------
}
