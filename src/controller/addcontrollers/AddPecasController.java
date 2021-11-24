package controller.addcontrollers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.bo.AutoBO;
import model.bo.PecaBO;
import model.vo.AutoVO;
import model.vo.PecasVO;

public class AddPecasController {
	    @FXML
	    private TextField pecasFabricanteField;

	    @FXML
	    private TextField pecasNameField;

	    @FXML
	    private TextField pecasPlacaField;

	    @FXML
	    private TextField pecasPrecoField;
	    
	    private boolean update = false;
	    Integer autoId = 0;
	    PecaBO<PecasVO> parts = new PecaBO<PecasVO>();
	    AutoBO<AutoVO> auto = new AutoBO<AutoVO>();
	    
	    @FXML
	    private void adicionar(MouseEvent event) {

	        String nome = pecasNameField.getText();
	        String fabricante = pecasFabricanteField.getText();
	        String preco = pecasPrecoField.getText();
	        String placa = pecasPlacaField.getText();
	        
	        PecasVO pecasv = new PecasVO();
            AutoVO autov = new AutoVO();
            
            autov.setPlaca(placa);
            // -------- get id from cliente --------------------
            autov.setId(auto.findByPlacaBO(autov).getId());
            
            // -------- END get id from cliente --------------------
            
            pecasv.setName(nome);
            pecasv.setFabricante(fabricante);
            pecasv.setPreco(Double.parseDouble(preco));
            pecasv.setAuto(autov);
            if(update == true) {
            	parts.findByPreco(pecasv).forEach(element ->{
            		pecasv.setId(element.getId());
            	});
            	
            }

	        if (nome.isEmpty() || fabricante.isEmpty() || preco.isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Por favor preencha todos os campos");
	            alert.showAndWait();

	        } else {
	        	getCommand(pecasv);
	            clean();

	        }

	    }
	    
	    private void getCommand(PecasVO pecasv) {

	        if (update == false) {
	            
	            insert(pecasv);

	        }else{
	            update(pecasv);
	        }

	    }
	    
	    private void insert(PecasVO pecasv) {

	        try {
	            parts.inserir(pecasv);

	        } catch (Exception ex) {
	            Logger.getLogger(AddAutoController.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	    
	    private void update(PecasVO pecasv) {

	        try {
	            parts.editar(pecasv);

	        } catch (Exception ex) {
	            Logger.getLogger(AddAutoController.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	    
	    public void setTextField(String nome, String fabricante, Double preco, String placa) {

	        
	        pecasNameField.setText(nome);
	        pecasFabricanteField.setText(fabricante);
	        pecasPrecoField.setText(String.valueOf(preco));
	        pecasPlacaField.setText(placa);
	        
	    }
	 	
	 	public void setUpdate(boolean value) {
	        this.update = value;

	    }
	 	
	 	@FXML
	 	private void clean() {
	 		pecasNameField.setText(null);
	        pecasFabricanteField.setText(null);
	        pecasPrecoField.setText(null);
	        pecasPlacaField.setText(null);
	 	        
	 	}
	 	
	 	@FXML
	    private void close(MouseEvent event) {
	        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        stage.close();
	    }


}
