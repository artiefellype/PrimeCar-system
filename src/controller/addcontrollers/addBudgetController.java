package controller.addcontrollers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.bo.AutoBO;
import model.bo.ClienteBO;
import model.bo.OrcamentoBO;
import model.bo.PecaBO;
import model.bo.ServicoBO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
import model.vo.OrcamentoVO;
import model.vo.PecasVO;
import model.vo.ServicosVO;

public class addBudgetController {
	
	@FXML
    private TextField orcamentosClienteField;

    @FXML
    private DatePicker orcamentosDatepickerStart;

    @FXML
    private TextField orcamentosPlacaField;

    @FXML
    private TextField orcamentosServicoField;

    @FXML
    private TextField orcamentosValorField;
    
    private boolean update = false;
    Integer ormId = 0;
    OrcamentoBO<OrcamentoVO> orm = new OrcamentoBO<OrcamentoVO>();
    ClienteBO<ClienteVO> cli = new ClienteBO<ClienteVO>();
    AutoBO<AutoVO> auto = new AutoBO<AutoVO>();
    ServicoBO<ServicosVO> servico = new ServicoBO<ServicosVO>();
    PecaBO<PecasVO> peca = new PecaBO<PecasVO>();
    
    @FXML
    private void adicionar(MouseEvent event) throws ParseException {

        String cliente = orcamentosClienteField.getText();
        String placa = orcamentosPlacaField.getText();
        String servicoText = orcamentosServicoField.getText();
        String valor = orcamentosValorField.getText();
        String data = orcamentosDatepickerStart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(data);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        
        AutoVO autov = new AutoVO();
        ClienteVO clientev = new ClienteVO();
        ServicosVO servicov = new ServicosVO();
        PecasVO pecasv = new PecasVO();
        OrcamentoVO orcamentov = new OrcamentoVO();
        
        clientev.setCPF(cliente);
        autov.setPlaca(placa);
        servicov.setTipo(servicoText);
        // -------- get id from objects --------------------
        clientev.setId(cli.listarByCPF(clientev).getId());
        
        auto.listarByPlacaBO(autov).forEach(element ->{
        	autov.setId(element.getId());
        	autov.setPlaca(element.getPlaca());
        });
        
        servico.findByTipo(servicov).forEach(element->{
        	servicov.setId(element.getId());
        	servicov.setTipo(element.getTipo());
        	servicov.setValor(element.getValor());
        });;
        
        peca.findByAutopl(autov).forEach(element ->{
        	pecasv.setId(element.getId());
        	pecasv.setName(element.getName());
        	pecasv.setPreco(element.getPreco());
        });;
        
        // -------- END get id from objects --------------------
        
        orcamentov.setClientName(clientev);
        orcamentov.setAuto(autov);
        orcamentov.setCusto(servicov.getValor());
        orcamentov.setServicos(servicov);
        orcamentov.setData(cal);
        
        if(update== true) {
        	orcamentov.setId(orm.findByClient(orcamentov).get(0).getId());
        }
       

        if (cliente.isEmpty() || placa.isEmpty() || valor.isEmpty() || servicoText.isEmpty() || data.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Por favor preencha todos os campos");
            alert.showAndWait();

        } else {
        	getCommand(orcamentov);
            clean();

        }

    }
 
 	private void getCommand(OrcamentoVO ormv) {

        if (update == false) {
            
            insert(ormv);

        }else{
            update(ormv);
        }

    }
 	private void insert(OrcamentoVO ormv) {

        try {
            orm.cadastrar(ormv);

        } catch (Exception ex) {
            Logger.getLogger(AddAutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 	
 	public void update(OrcamentoVO ormv) {

        try {
            orm.editar(ormv);

        } catch (Exception ex) {
            Logger.getLogger(AddAutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 	public void setTextField(ClienteVO cliente, AutoVO placa, Double valor, ServicosVO servico, Calendar data) {
 		TimeZone tz = data.getTimeZone();
 		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
 		LocalDate localDate = LocalDateTime.ofInstant(data.toInstant(), zid).toLocalDate();
        
 		orcamentosClienteField.setText(cliente.getCPF());
 		orcamentosPlacaField.setText(placa.getPlaca());
        orcamentosValorField.setText(String.valueOf(valor));
        orcamentosServicoField.setText(servico.getTipo());
        orcamentosDatepickerStart.setValue(localDate);
        
    }
 	
 	public void setUpdate(boolean value) {
        this.update = value;

    }
 	
 	@FXML
 	private void clean() {
 		orcamentosClienteField.setText(null);
 		orcamentosPlacaField.setText(null);
        orcamentosValorField.setText(null);
        orcamentosServicoField.setText(null);
 	        
 	}
 	
 	@FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    
    
    


}
