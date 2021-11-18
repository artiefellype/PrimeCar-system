package controller.addcontrollers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.bo.AutoBO;
import model.bo.ClienteBO;
import model.bo.PecaBO;
import model.bo.ServicoBO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
import model.vo.PecasVO;
import model.vo.ServicosVO;

public class AddServicosController {
	    @FXML
	    private CheckBox servicosCheckBox;

	    @FXML
	    private TextField servicosNameField;

	    @FXML
	    private TextField servicosPlacaField;

	    @FXML
	    private TextField servicosValorField;
	    
	    private boolean update = false;
	    Integer serviceId = 0;
	    ServicoBO<ServicosVO> servicos = new ServicoBO<ServicosVO>();
	    AutoBO<AutoVO> auto = new AutoBO<AutoVO>();
	    
	    @FXML
	    public void adicionar(MouseEvent event) {

	        String nome = servicosNameField.getText();
	        String placa = servicosPlacaField.getText();
	        String valor = servicosValorField.getText();
	        Boolean check = servicosCheckBox.isSelected();
	        
	        AutoVO autov = new AutoVO(); 
	        ServicosVO servicosv = new ServicosVO();
	        
	        autov.setPlaca(placa);
	        auto.listarByPlacaBO(autov).forEach(element ->{
	        	
	        	autov.setId(element.getId());
	        	autov.setPlaca(element.getPlaca());
	        });
	        
	        servicosv.setTipo(nome);
	        servicosv.setValor(Double.parseDouble(valor));
	        servicosv.setFinalizado(check);
	        servicosv.setAuto(autov);
	        
	        
	        if(update== true) {
	        	servicosv.setId(servicos.findByTipo(servicosv).get(0).getId());
	        }
			
	        if (nome.isEmpty() || valor.isEmpty() || placa.isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setContentText("Por favor preencha todos os campos");
	            alert.showAndWait();

	        } else {
	        	getCommand(servicosv);
	            clean();

	        }

	    }
	 
	 	private void getCommand(ServicosVO serv) {

	        if (update == false) {
	            
	            insert(serv);

	        }else{
	            update(serv);
	        }

	    }
	 	private void insert(ServicosVO serv) {

	        try {
	            servicos.inserir(serv);

	        } catch (Exception ex) {
	            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	 	
	 	private void update(ServicosVO serv) {

	        try {
	            servicos.editar(serv);

	        } catch (Exception ex) {
	            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	 	public void setTextField(String nome, String Placa, Double valor, Boolean check) {

	        
	 		servicosNameField.setText(nome);
	        servicosPlacaField.setText(Placa);
	        servicosValorField.setText(String.valueOf(valor));
	        servicosCheckBox.setSelected(check);
	        
	    }
	 	
	 	public void setUpdate(boolean value) {
	        this.update = value;

	    }
	 	
	 	@FXML
	 	private void clean() {
	 		servicosNameField.setText(null);
	        servicosPlacaField.setText(null);
	        servicosValorField.setText(null);
	        servicosCheckBox.setText(null);
	 	        
	 	}
	 	
	 	@FXML
	    private void close(MouseEvent event) {
	        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        stage.close();
	    }
}
