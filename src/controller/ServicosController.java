package controller;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.addcontrollers.AddClienteController;
import controller.addcontrollers.AddServicosController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import model.bo.AutoBO;
import model.bo.ServicoBO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
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
    private TableColumn<ServicosVO, String> servicosIcons;
    
    @FXML
    private TextField clienteInput;
    
	 ObservableList<ServicosVO> obsServicosList = FXCollections.observableArrayList();
	 ServicoBO<ServicosVO> servicos = new ServicoBO<ServicosVO>();
	 ServicosVO servIcon = null;
	 
	 
	 @FXML
	 public void addDataServicos() {
		 
		 FXMLLoader loader = new FXMLLoader ();
         loader.setLocation(getClass().getResource("../view/VE/addFXML/addServicos.fxml"));
         try {
             loader.load();
         } catch (IOException ex) {
             Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         AddServicosController addServicosController = loader.getController();
         addServicosController.setUpdate(false);
         Parent parent = loader.getRoot();
         Stage stage = new Stage();
         stage.setScene(new Scene(parent));
         stage.initStyle(StageStyle.UTILITY);
         stage.show();
         
         
	 }
	 
	@FXML
    public void loadDataServicos() {
		obsServicosList.clear();
		
    	servicosColumnNome.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	servicosColumnFinalizado.setCellValueFactory(new 
    			Callback<TableColumn.CellDataFeatures<ServicosVO, String>, ObservableValue<String>>(){
			@Override
			public ObservableValue<String> call(CellDataFeatures<ServicosVO, String> c){
				if(c.getValue().getFinalizado()) {
					return new SimpleStringProperty("SIM");
				}else {
					return new SimpleStringProperty("NÃO");
				}
				
			}
    	});;
    	servicosColumnValor.setCellValueFactory(new 
    			Callback<TableColumn.CellDataFeatures<ServicosVO, String>, ObservableValue<String>>(){
    			@Override
    			public ObservableValue<String> call(CellDataFeatures<ServicosVO, String> c){
    				return new SimpleStringProperty("R$ " + c.getValue().getValor());
    			}
    	});
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
    		
    		servicosIcons.setCellFactory(cellFoctory);
    		obsServicosList.add(servList);
    		servicosTableView.setItems(obsServicosList);
    		
 		}
    }
	
	public void refreshTable() {
		obsServicosList.clear();
		loadDataServicos();
	}
    
	// ------------------- CREATE CELL FACTORY -------------------------------------
	
	Callback<TableColumn<ServicosVO, String>, TableCell<ServicosVO, String>> cellFoctory = (TableColumn<ServicosVO, String> param) -> {
        // make cell containing buttons
        final TableCell<ServicosVO, String> cell = new TableCell<ServicosVO, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                //that cell created only on non-empty rows
                if (empty) {
                    setGraphic(null);
                    setText(null);

                } else {
                	
                	try {
                		
                		FileInputStream input = new FileInputStream("src/view/VE/img/edit-2-outline.png");
                        Image editIcon = new Image(input);
                        ImageView editIconImg = new ImageView(editIcon); // Objeto para uso
                        
                        FileInputStream input2 = new FileInputStream("src/view/VE/img/trash-2-outline.png");
                        Image removeIcon = new Image(input2);
                        ImageView removeIconImg = new ImageView(removeIcon); // Objeto para uso
                		
                	editIconImg.setFitHeight(20);
                	editIconImg.setFitWidth(20);
                	editIconImg.setPreserveRatio(true);

                    editIconImg.setStyle(
                            " -fx-cursor: hand ;"
                    );
                    
                    removeIconImg.setFitHeight(20);
                	removeIconImg.setFitWidth(20);
                	removeIconImg.setPreserveRatio(true);
                	
                    removeIconImg.setStyle(
                            " -fx-cursor: hand ;"
                    );
                    removeIconImg.setOnMouseClicked((MouseEvent event) -> {
                            servIcon = servicosTableView.getSelectionModel().getSelectedItem();
                            servicos.remover(servIcon);
                            
                            loadDataServicos();
                            

                    });
                    editIconImg.setOnMouseClicked((MouseEvent event) -> {
                        servIcon = servicosTableView.getSelectionModel().getSelectedItem();
                        System.out.println(servIcon);
                        FXMLLoader loader = new FXMLLoader ();
                        loader.setLocation(getClass().getResource("../view/VE/addFXML/addServicos.fxml"));
                        try {
                            loader.load();
                        } catch (IOException ex) {
                            Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        AddServicosController addServicosController = loader.getController();
                        addServicosController.setUpdate(true);
                        addServicosController.setTextField(servIcon.getTipo(), servIcon.getAuto().getPlaca(), 
                                servIcon.getValor(), servIcon.getFinalizado());
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.initStyle(StageStyle.UTILITY);
                        stage.show();
                        

                       

                    });

                    HBox managebtn = new HBox(editIconImg, removeIconImg);
                    managebtn.setStyle("-fx-alignment:center");
                    HBox.setMargin(removeIconImg, new Insets(2, 2, 0, 3));
                    HBox.setMargin(editIconImg, new Insets(2, 3, 0, 2));

                    setGraphic(managebtn);

                    setText(null);
                		
                	}catch(Exception e) {
                		System.out.println("ERRO:" + e);
                	}
               
                }
            }

        };

        return cell;
    };
	
	// ----------------------- END CREATE CELL FACTORY---------------------------------
    
    public void searchServico() throws Exception {
    	ServicosVO serv = new ServicosVO();
    	AutoVO auto = new AutoVO();
    	
    	AutoBO<AutoVO> autob = new AutoBO<AutoVO>();
    	
    	serv.setTipo(clienteInput.getText());
    	auto.setMarca(clienteInput.getText());
    	
    	
    	List<ServicosVO> serviceAutoList = servicos.findByAuto(auto);
    	List<ServicosVO> serviceTipoList = servicos.findByTipo(serv);
    	System.out.println("@>> "+serviceAutoList);
    	System.out.println("@>> "+serviceTipoList);
    	
    	if(!serviceTipoList.isEmpty()) {
    		for(ServicosVO servShow : serviceTipoList) {
    			obsServicosList.clear();
    			
        		System.out.println(servShow.getTipo());
        		ServicosVO servList = new ServicosVO();
        		servList.setTipo(servShow.getTipo());
        		servList.setValor(servShow.getValor());
        		servList.setFinalizado(servShow.getFinalizado());
        		servList.setAuto(servShow.getAuto());
        		
        		servicosIcons.setCellFactory(cellFoctory);
        		obsServicosList.add(servList);
        		servicosTableView.setItems(obsServicosList);
        		
     		}
    		
    	}else if(!serviceAutoList.isEmpty()) {
    		for(ServicosVO servShow : serviceAutoList) {
    			obsServicosList.clear();
    			
        		System.out.println(servShow.getTipo());
        		ServicosVO servList = new ServicosVO();
        		servList.setTipo(servShow.getTipo());
        		servList.setValor(servShow.getValor());
        		servList.setFinalizado(servShow.getFinalizado());
        		servList.setAuto(servShow.getAuto());
        		
        		servicosIcons.setCellFactory(cellFoctory);
        		obsServicosList.add(servList);
        		servicosTableView.setItems(obsServicosList);
        		
     		}
    	}
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
