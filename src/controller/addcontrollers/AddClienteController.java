package controller.addcontrollers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.bo.ClienteBO;
import model.vo.ClienteVO;

public class AddClienteController {
	
	@FXML
    private TextField clienteCpfField;

    @FXML
    private TextField clienteEnderecoField;

    @FXML
    private TextField clienteNameField;
    
    private boolean update = false;
    Integer clienteId = 0;
    ClienteBO<ClienteVO> cliente = new ClienteBO<ClienteVO>();
    
    @FXML
    public void adicionar(MouseEvent event) {

        String nome = clienteNameField.getText();
        String cpf = clienteCpfField.getText();
        String endereco = clienteEnderecoField.getText();
        
        ClienteVO clientev = new ClienteVO();
        clientev.search(true);
        clientev.setCPF(cpf);
        clientev.setName(nome);
        clientev.setEndereco(endereco);
        if(update== true) {
        	clientev.setId(cliente.findByCPF(clientev).get(0).getId());
        }

        if (nome.isEmpty() || cpf.isEmpty() || endereco.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Por favor preencha todos os campos");
            alert.showAndWait();

        } else {
        	getCommand(clientev);
            clean();

        }

    }
 
 	private void getCommand(ClienteVO clientev) {

        if (update == false) {
            
            insert(clientev);

        }else{
            update(clientev);
        }

    }
 	private void insert(ClienteVO clientev) {

        try {
            cliente.inserirBO(clientev);

        } catch (Exception ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 	
 	private void update(ClienteVO clientev) {

        try {
            cliente.editarBO(clientev);

        } catch (Exception ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 	public void setTextField(String nome, String cpf, String endereco) {

        
        clienteNameField.setText(nome);
        clienteCpfField.setText(cpf);
        clienteEnderecoField.setText(endereco);
        
    }
 	
 	public void setUpdate(boolean value) {
        this.update = value;

    }
 	
 	@FXML
 	private void clean() {
 		clienteNameField.setText(null);
        clienteCpfField.setText(null);
        clienteEnderecoField.setText(null);
 	        
 	}
 	
 	@FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
