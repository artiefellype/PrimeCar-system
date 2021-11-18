package controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.addcontrollers.AddClienteController;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
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
	    
	    @FXML
	    private ImageView addItemsButton;
	    
	    
	    ObservableList<ClienteVO> obsClienteList = FXCollections.observableArrayList();
		 ClienteBO<ClienteVO> clientes = new ClienteBO<ClienteVO>();
		 ClienteVO clienteIcon = null;
		 
		 @FXML
		 public void addDataClientes(MouseEvent event) {
			 
			 FXMLLoader loader = new FXMLLoader ();
             loader.setLocation(getClass().getResource("../view/VE/addFXML/addCliente.fxml"));
             try {
                 loader.load();
             } catch (IOException ex) {
                 Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             AddClienteController addClienteController = loader.getController();
             addClienteController.setUpdate(false);
             Parent parent = loader.getRoot();
             Stage stage = new Stage();
             stage.setScene(new Scene(parent));
             stage.initStyle(StageStyle.UTILITY);
             stage.show();
             
             
		 }
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
		    		
		    		clientesIconColumn.setCellFactory(cellFoctory);
		    		obsClienteList.add(cliList);
		    		clienteTableView.setItems(obsClienteList);
		    		
		 		}
		 }
		 public void searchCliente() {
			 	obsClienteList.clear();
			 	
		    	ClienteVO cli = new ClienteVO();
		    	
		    	cli.setName(clienteInput.getText());
		    	cli.setEndereco(clienteInput.getText());
		    	cli.search(true);
		    	cli.setCPF(clienteInput.getText());
		    	
		    	List<ClienteVO> clienteFindNameList = clientes.listarByNome(cli);
	 	    	List<ClienteVO> clienteFindCPFList = clientes.findByCPF(cli);
	 	    	List<ClienteVO> clienteFindEndereco = clientes.listarByEndereco(cli);
	 	    	
	 	    	if(!clienteFindNameList.isEmpty()) {
	 	    		obsClienteList.clear();
	 	    		for(ClienteVO cliShow : clienteFindNameList) {
	 	    			
			    		
			    		cliShow.search(true);
			    		
			    		clientesIconColumn.setCellFactory(cellFoctory);
			    		obsClienteList.add(cliShow);
			    		clienteTableView.setItems(obsClienteList);
			    		
			 		}
	 	    	}else if(!clienteFindCPFList.isEmpty()){
	 	    		
	 	    		for(ClienteVO cliShow : clienteFindCPFList) {
	 	    			
			    		ClienteVO cliList = new ClienteVO();
			    		
			    		cliList.setName(cliShow.getName());
			    		cliList.setEndereco(cliShow.getEndereco());
			    		cliList.search(true);
			    		cliList.setCPF(cliShow.getCPF());
			    		
			    		clientesIconColumn.setCellFactory(cellFoctory);
			    		obsClienteList.add(cliList);
			    		clienteTableView.setItems(obsClienteList);
			    		
			 		}
	 	    		
	 	    	}else if(!clienteFindEndereco.isEmpty()) {
	 	    		obsClienteList.clear();
	 	    		for(ClienteVO cliShow : clienteFindEndereco) {
	 	    			
			    		System.out.println(cliShow.getCPF());
			    		
			    		ClienteVO cliList = new ClienteVO();
			    		cliList.setName(cliShow.getName());
			    		cliList.setEndereco(cliShow.getEndereco());
			    		cliList.search(true);
			    		cliList.setCPF(cliShow.getCPF());
			    		loadDataClientes();
			    		
			    		clientesIconColumn.setCellFactory(cellFoctory);
			    		obsClienteList.add(cliList);
			    		clienteTableView.setItems(obsClienteList);
			    		
			 		}
	 	    		
	 	    	}else {
	 	    		System.out.println("probs");
	 	    	}
	 	    	
		    }
     // ---------------- END Clientes functions --------------------------
	// ------------------- CREATE CELL FACTORY -------------------------------------
	    	
	    	Callback<TableColumn<ClienteVO, String>, TableCell<ClienteVO, String>> cellFoctory = (TableColumn<ClienteVO, String> param) -> {
	            // make cell containing buttons
	            final TableCell<ClienteVO, String> cell = new TableCell<ClienteVO, String>() {
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
	                                clienteIcon = clienteTableView.getSelectionModel().getSelectedItem();
	                                clientes.removerBO(clienteIcon);
	                                
	                                loadDataClientes();
	                                

	                        });
	                        editIconImg.setOnMouseClicked((MouseEvent event) -> {
	                            clienteIcon = clienteTableView.getSelectionModel().getSelectedItem();
	                            System.out.println(clienteIcon);
	                            FXMLLoader loader = new FXMLLoader ();
	                            loader.setLocation(getClass().getResource("../view/VE/addFXML/addCliente.fxml"));
	                            try {
	                                loader.load();
	                            } catch (IOException ex) {
	                                Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
	                            }
	                            
	                            AddClienteController addClienteController = loader.getController();
	                            addClienteController.setUpdate(true);
	                            addClienteController.setTextField(clienteIcon.getName(), clienteIcon.getCPF(), 
	                                    clienteIcon.getEndereco());
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
