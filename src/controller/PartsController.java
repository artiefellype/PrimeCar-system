package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.addcontrollers.AddPecasController;
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
import model.bo.PecaBO;
import model.vo.AutoVO;
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
	    private TableColumn<PecasVO, String> pecasColumnIcons;

	    @FXML
	    private TableView<PecasVO> pecasTableView;
	    
	    ObservableList<PecasVO> obsPecasList = FXCollections.observableArrayList();
		 PecaBO<PecasVO> parts = new PecaBO<PecasVO>();
		 PecasVO pecaIcon = null;
		 
		 @FXML
		 public void addDataPecas(MouseEvent event) {
			 FXMLLoader loader = new FXMLLoader ();
             loader.setLocation(getClass().getResource("../view/VE/addFXML/addPecas.fxml"));
             try {
                 loader.load();
             } catch (IOException ex) {
                 Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             AddPecasController addPecasController = loader.getController();
             addPecasController.setUpdate(false);
             Parent parent = loader.getRoot();
             Stage stage = new Stage();
             stage.setScene(new Scene(parent));
             stage.initStyle(StageStyle.UTILITY);
             stage.show();
		 }
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
		    		partList.setId(partShow.getId());
		    		partList.setName(partShow.getName());
		    		partList.setFabricante(partShow.getFabricante());
		    		partList.setPreco(partShow.getPreco());
		    		partList.setAuto(partShow.getAuto());
		    		
		    		pecasColumnIcons.setCellFactory(cellFoctory);
		    		obsPecasList.add(partList);
		    		pecasTableView.setItems(obsPecasList);
		    		
		 		}
		    	
		 }	
		 public void searchPecas() {
			 
			 	obsPecasList.clear();
		    	PecasVO pecasv = new PecasVO();
		    	AutoVO autov = new AutoVO();
		    	AutoBO<AutoVO> autob = new AutoBO<AutoVO>();
		    	autov.setPlaca(clienteInput.getText());
		    	//autob.listarByPlacaBO(autov);		    	
		    	try {
		    		pecasv.setName(clienteInput.getText());
			    	pecasv.setFabricante(clienteInput.getText());
			    	pecasv.setAuto(autov);
			    	
		    	}catch(Exception e) {
		    		System.out.println("ERROR@>>" + e);
		    	}
		    	
		    	
		    	List<PecasVO> pecasFindPlacaList = parts.findByAutopl(autov);
		    	List<PecasVO> pecasFindNameList = parts.findByName(pecasv);
	 	    	List<PecasVO> pecasFindFabricanteList = parts.findByFab(pecasv);
	 	    	
	 	    	
	 	    	if(!pecasFindNameList.isEmpty()) {
	 	    		obsPecasList.clear();
	 	    		for(PecasVO cliShow : pecasFindNameList) {
	 	    			
			    		PecasVO pecList = new PecasVO();
			    		
			    		pecList.setName(cliShow.getName());
			    		pecList.setFabricante(cliShow.getFabricante());
			    		pecList.setPreco(cliShow.getPreco());
			    		pecList.setAuto(cliShow.getAuto());
			    		
			    		
			    		pecasColumnIcons.setCellFactory(cellFoctory);
			    		obsPecasList.add(pecList);
			    		pecasTableView.setItems(obsPecasList);
			    		
			 		}
	 	    	}else if(!pecasFindFabricanteList.isEmpty()){
	 	    		
	 	    		for(PecasVO pecShow : pecasFindFabricanteList) {
	 	    			
			    		PecasVO pecList = new PecasVO();
			    		
			    		pecList.setName(pecShow.getName());
			    		pecList.setFabricante(pecShow.getFabricante());
			    		pecList.setPreco(pecShow.getPreco());
			    		pecList.setAuto(pecShow.getAuto());
			    		
			    		pecasColumnIcons.setCellFactory(cellFoctory);
			    		obsPecasList.add(pecList);
			    		pecasTableView.setItems(obsPecasList);
			    		
			 		}
	 	    		
	 	    	}else if(!pecasFindPlacaList.isEmpty()) {
	 	    		obsPecasList.clear();
	 	    		for(PecasVO pecShow : pecasFindPlacaList) {
	 	    			
			    		PecasVO pecList = new PecasVO();
			    		
			    		System.out.println(pecShow.getAuto().getPlaca());
			    		pecList.setName(pecShow.getName());
			    		pecList.setFabricante(pecShow.getFabricante());
			    		pecList.setPreco(pecShow.getPreco());
			    		pecList.setAuto(pecShow.getAuto());
			    		
			    		
			    		pecasColumnIcons.setCellFactory(cellFoctory);
			    		obsPecasList.add(pecList);
			    		pecasTableView.setItems(obsPecasList);
			    		
			 		}
	 	    		
	 	    			
			    		
			    		
			    		
			 		
	 	    		
	 	    	}else {
	 	    		System.out.println("probs");
	 	    	}
	 	    	
		    }
	// ---------------- END pecas functions -------------------------
		// ------------------- CREATE CELL FACTORY -------------------------------------
		 	
		 	Callback<TableColumn<PecasVO, String>, TableCell<PecasVO, String>> cellFoctory = (TableColumn<PecasVO, String> param) -> {
		         // make cell containing buttons
		         final TableCell<PecasVO, String> cell = new TableCell<PecasVO, String>() {
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
		                             pecaIcon = pecasTableView.getSelectionModel().getSelectedItem();
		                             parts.remove(pecaIcon);
		                             
		                             loadDataPecas();
		                             

		                     });
		                     editIconImg.setOnMouseClicked((MouseEvent event) -> {
		                         pecaIcon = pecasTableView.getSelectionModel().getSelectedItem();
		                         System.out.println(pecaIcon);
		                         FXMLLoader loader = new FXMLLoader ();
		                         loader.setLocation(getClass().getResource("../view/VE/addFXML/addPecas.fxml"));
		                         try {
		                             loader.load();
		                         } catch (IOException ex) {
		                             Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
		                         }
		                         
		                         AddPecasController addPecasController = loader.getController();
		                         addPecasController.setUpdate(true);
		                         addPecasController.setTextField(pecaIcon.getName(), pecaIcon.getFabricante(), 
		                                 pecaIcon.getPreco(), pecaIcon.getAuto().getPlaca());
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
