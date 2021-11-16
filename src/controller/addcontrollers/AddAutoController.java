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
import model.bo.ClienteBO;
import model.vo.AutoVO;
import model.vo.ClienteVO;

public class AddAutoController {
	

    @FXML
    private TextField autoAnoField;

    @FXML
    private TextField autoCorField;

    @FXML
    private TextField autoKmField;

    @FXML
    private TextField autoMarcaField;

    @FXML
    private TextField autoPlacaField;

    @FXML
    private TextField autoProprietarioField;

    private boolean update = false;
    Integer clienteId = 0;
    AutoBO<AutoVO> auto = new AutoBO<AutoVO>();
    ClienteBO<ClienteVO> cli = new ClienteBO<ClienteVO>();
	
	 @FXML
	    private void adicionar(MouseEvent event) {

	        String marca = autoMarcaField.getText();
	        String placa = autoPlacaField.getText();
	        String proprietario = autoProprietarioField.getText();
	        String cor = autoCorField.getText();
	        String km = autoKmField.getText();
	        String ano = autoAnoField.getText();
	        
	        AutoVO autov = new AutoVO();
            ClienteVO clientev = new ClienteVO();
            
            clientev.setCPF(autoProprietarioField.getText());
            
            // -------- get id from cliente --------------------
            clientev.setId(cli.listarByCPF(clientev).getId());
            // -------- END get id from cliente --------------------
            autov.setId(auto.getIdFromBD());
            autov.setMarca(autoMarcaField.getText());
            autov.setAno(Integer.parseInt(autoAnoField.getText()));
            autov.setCor(autoCorField.getText());
            autov.setPlaca(autoPlacaField.getText());
            autov.setQuilometragem(Double.parseDouble(autoKmField.getText()));
            autov.setProprietario(clientev);

	        if (marca.isEmpty() || placa.isEmpty() || proprietario.isEmpty() || cor.isEmpty() || km.isEmpty() || ano.isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Por favor preencha todos os campos");
	            alert.showAndWait();

	        } else {
	        	getCommand(autov);
	            clean();

	        }

	    }
	 
	 	private void getCommand(AutoVO autov) {

	        if (update == false) {
	            
	            insert(autov);

	        }else{
	            update(autov);
	        }

	    }
	 	private void insert(AutoVO autov) {

	        try {
	            auto.inserirBO(autov);

	        } catch (Exception ex) {
	            Logger.getLogger(AddAutoController.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	 	
	 	private void update(AutoVO autov) {

	        try {
	            auto.editarBO(autov);

	        } catch (Exception ex) {
	            Logger.getLogger(AddAutoController.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	 	public void setTextField(String marca, Integer ano, String cor, String placa, Double km, String cliente) {

	        
	        autoMarcaField.setText(marca);
	        autoAnoField.setText(String.valueOf(ano));
	        autoCorField.setText(cor);
	        autoPlacaField.setText(placa);
	        autoKmField.setText(String.valueOf(km));
	        autoProprietarioField.setText(cliente);
	        
	    }
	 	
	 	public void setUpdate(boolean value) {
	        this.update = value;

	    }
	 	
	 	@FXML
	 	private void clean() {
	 		autoMarcaField.setText(null);
	        autoAnoField.setText(null);
	        autoCorField.setText(null);
	        autoPlacaField.setText(null);
	        autoKmField.setText(null);
	        autoProprietarioField.setText(null);
	 	        
	 	}
	 	
	 	@FXML
	    private void close(MouseEvent event) {
	        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        stage.close();
	    }


}
