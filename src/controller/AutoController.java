package controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.addcontrollers.AddAutoController;
import controller.addcontrollers.AddClienteController;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import model.bo.AutoBO;
import model.bo.ClienteBO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
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
    private TableColumn<AutoVO, String> autoColumnIcons;


    @FXML
    private TableView<AutoVO> autoTableView;

    @FXML
    private TextField clienteInput;
    
    ObservableList<AutoVO> obsAutoList = FXCollections.observableArrayList();
	 AutoBO<AutoVO> automoveis = new AutoBO<AutoVO>();
	 AutoVO autoIcon = null;
	 
	// ------------------- CREATE CELL FACTORY -------------------------------------
 	
 	Callback<TableColumn<AutoVO, String>, TableCell<AutoVO, String>> cellFoctory = (TableColumn<AutoVO, String> param) -> {
         // make cell containing buttons
         final TableCell<AutoVO, String> cell = new TableCell<AutoVO, String>() {
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
                             autoIcon = autoTableView.getSelectionModel().getSelectedItem();
                             automoveis.removerBO(autoIcon);
                             
                             loadDataAuto();
                             

                     });
                     editIconImg.setOnMouseClicked((MouseEvent event) -> {
                         autoIcon = autoTableView.getSelectionModel().getSelectedItem();
                         System.out.println(autoIcon);
                         FXMLLoader loader = new FXMLLoader ();
                         loader.setLocation(getClass().getResource("../view/VE/addFXML/addAuto.fxml"));
                         try {
                             loader.load();
                         } catch (IOException ex) {
                             Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         
                         AddAutoController addAutoController = loader.getController();
                         addAutoController.setUpdate(true);
                         addAutoController.setTextField(autoIcon.getMarca(), autoIcon.getAno(), 
                                 autoIcon.getCor(), autoIcon.getPlaca(), autoIcon.getQuilometragem(),
                                 autoIcon.getProprietario().getCPF());
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
     public void searchAuto() {
	    	AutoVO auto = new AutoVO();
	    	ClienteVO cliente = new ClienteVO();
	    	ClienteBO<ClienteVO> clienteBO = new ClienteBO<>();
	    	
	    	auto.setAno(Integer.parseInt(clienteInput.getText()));
	    	auto.setMarca(clienteInput.getText());
	    	auto.setCor(clienteInput.getText());
	    	auto.setPlaca(clienteInput.getText());
	    	auto.setQuilometragem(Double.parseDouble(clienteInput.getText()));
	    	
	    	AutoVO searchPlaca = automoveis.findByPlacaBO(auto);
	    	List<AutoVO> listaAuto1 = automoveis.listarByAnoBO(auto);
	    	List<AutoVO> listaAuto2 = automoveis.listarByMarcaBO(auto);
	    	List<AutoVO> listaAuto3 = automoveis.listarByCorBO(auto);
	    	List<AutoVO> listaAuto4 = automoveis.listarByKmBO(auto);
	    	
	    	cliente.setName(clienteInput.getText());
	    	List<ClienteVO> listaCliente = clienteBO.listarByNome(cliente);
	    	
	    	if(!listaCliente.isEmpty()) {
	    		List<AutoVO> listaAuto = new ArrayList<>();
	    		for(ClienteVO cliShow : listaCliente) {
	    			auto.setProprietario(cliShow);
	    			List<AutoVO> listaAuto2 = new ArrayList<>();
	    			for(AutoVO autoShow : listaAuto2) {
	    				listaAuto.add(autoShow);
	    			}
	    		}
	    		for(AutoVO autoShow : listaAuto) {
		    		System.out.println(autoShow.getMarca());
		    		
		    		autoColumnIcons.setCellFactory(cellFoctory);
		    		obsAutoList.add(autoShow);
		    		autoTableView.setItems(obsAutoList);
		    		
		 		}
	    	}
	    	
	    	if(!(searchPlaca == null)) {
	    		obsAutoList.clear();
	    		
	    		
	    		autoColumnIcons.setCellFactory(cellFoctory);
	    		obsAutoList.add(searchPlaca);
	    		autoTableView.setItems(obsAutoList);
	    	}
     }
     @FXML
	 public void addDataAuto() {
		 
		 FXMLLoader loader = new FXMLLoader ();
         loader.setLocation(getClass().getResource("../view/VE/addFXML/addAuto.fxml"));
         try {
             loader.load();
         } catch (IOException ex) {
             Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         AddAutoController addAutoController = loader.getController();
         addAutoController.setUpdate(false);
         Parent parent = loader.getRoot();
         Stage stage = new Stage();
         stage.setScene(new Scene(parent));
         stage.initStyle(StageStyle.UTILITY);
         stage.show();
         
         
	 }
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
	    		
	    		autoColumnIcons.setCellFactory(cellFoctory);
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
