package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controller.addcontrollers.AddClienteController;
import controller.addcontrollers.addBudgetController;
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
import javafx.scene.control.DatePicker;
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
import model.bo.OrcamentoBO;
import model.bo.ServicoBO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
import model.vo.OrcamentoVO;
import model.vo.ServicosVO;
import view.Telas;

public class BudgetController {
	// -------------------- Orcamento functions -----------------------------
	@FXML
    private TextField clienteInput;
	 
    @FXML
    private DatePicker ormDataEnd;

    @FXML
    private DatePicker ormDataStart;


    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnCusto;

    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnDetalhes;

    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnVeiculo;
    
    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnServicos;


    @FXML
    private TableColumn<OrcamentoVO, String> orcamentosColumnCliente;
    
    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnIcons;
    
    @FXML
    private TableColumn<OrcamentoVO, String> orcamentoColumnData;
   
    @FXML
    private TableView<OrcamentoVO> orcamentosTableView;
    
    ObservableList<OrcamentoVO> obsOrmList = FXCollections.observableArrayList();
	 OrcamentoBO<OrcamentoVO> orcamentos = new OrcamentoBO<OrcamentoVO>();
	 AutoBO<AutoVO> auto = new AutoBO<AutoVO>();
	 OrcamentoVO ormIcon = null;

    @FXML
    void addDataOrcamentos(MouseEvent event) {
    	System.out.println("A ser implementado");
    	
    }
    
    @FXML
    public void searchBudgetByData() {
    	List<OrcamentoVO> lista = orcamentos.findByData(ormDataStart.getValue(DateTimeFormatter.ofPattern("yyyy-MM-dd"), 
    			ormDataEnd.getValueformat(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	
    	for(OrcamentoVO ormList : lista) {
    		obsOrmList.clear();
    		
    		obsOrmList.add(ormList);
    		orcamentosTableView.setItems(obsOrmList);
    		
    	}
    	
    }
    @FXML
    public void searchBudget() {
    	OrcamentoVO orca = new OrcamentoVO();
    	AutoVO auto = new AutoVO();
    	AutoBO<AutoVO> autoBO = new AutoBO<>();
    	ClienteVO cliente = new ClienteVO();
    	ClienteBO<ClienteVO> clienteBO = new ClienteBO<>();
    	ServicosVO servico = new ServicosVO();
    	ServicoBO<ServicosVO> servicoBO = new ServicoBO<>();
    	auto.setPlaca(clienteInput.getText());
    	cliente.setName(clienteInput.getText());
    	servico.setTipo(clienteInput.getText());
    	
    	orca.setAuto(autoBO.listarByPlacaBO(auto));
    	List<ClienteVO> listaCliente = clienteBO.listarByNome(cliente);
    	List<ServicosVO> listaServico = servicoBO.findByTipo(servico);
    	
    	if(!(orca == null)) {
    		List<OrcamentoVO> listaOrc = orcamentos.findByAuto(orca);
    		for(OrcamentoVO ormShow : listaOrc) {
        		System.out.println(ormShow.getAuto().getPlaca());
        		
        		obsOrmList.add(ormShow);
        		orcamentosTableView.setItems(obsOrmList);
        		
     		}
    	}
    	
    	
    	if (!listaCliente.isEmpty()) {
    		List<OrcamentoVO> listaOrc = new ArrayList<>();
    		for(ClienteVO cliShow : listaCliente) {
    			orca.setClientName(cliShow);
    			List<OrcamentoVO> listaOrc2 = orcamentos.findByClient(orca);
    			for(OrcamentoVO orcShow : listaOrc2) {
    				listaOrc.add(orcShow);
    			}
    		}
    		
    		for(OrcamentoVO ormShow : listaOrc) {
    			obsOrmList.clear();
        		System.out.println(ormShow.getAuto().getPlaca());
        		
        		obsOrmList.add(ormShow);
        		orcamentosTableView.setItems(obsOrmList);
        		
     		}
    	}
    	if (!listaServico.isEmpty()) {
    		List<OrcamentoVO> listaOrc = new ArrayList<>();
    		for(ServicosVO servicoShow : listaServico) {
    			orca.setServicos(servicoShow);
    			List<OrcamentoVO> listaOrc2 = orcamentos.findByServico(orca);
    			for(OrcamentoVO orcShow : listaOrc2) {
    				listaOrc.add(orcShow);
    			}
    			listaOrc.add(orca);
    		}
    		
    		
    		
    		for(OrcamentoVO ormShow : listaOrc) {
    			obsOrmList.clear();
        		System.out.println(ormShow.getAuto().getPlaca());
        		
        		obsOrmList.add(ormShow);
        		orcamentosTableView.setItems(obsOrmList);
        		
     		}
    	}
    	
    	
    	
    	
    }


    @FXML
    void loadDataOrcamentos() {
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
    	orcamentoColumnCusto.setCellValueFactory(
    			new Callback<TableColumn.CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>(){
    		@Override    
    	    public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
    			
    	        return new SimpleStringProperty("R$ " + c.getValue().getCusto());
    	    }
    	});
    	
    	orcamentoColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
    	
    	List<OrcamentoVO> orms = orcamentos.listarBO();
    	
    	for(OrcamentoVO ormShow : orms) {
    		System.out.println(ormShow.getAuto().getPlaca());
    		
    		orcamentoColumnIcons.setCellFactory(cellFoctory);
    		obsOrmList.add(ormShow);
    		orcamentosTableView.setItems(obsOrmList);
    		
 		}

    }
	// -------------------- END Orcamento functions -------------------------
 // ------------------- CREATE CELL FACTORY -------------------------------------
	
	Callback<TableColumn<OrcamentoVO, String>, TableCell<OrcamentoVO, String>> cellFoctory = (TableColumn<OrcamentoVO, String> param) -> {
        // make cell containing buttons
        final TableCell<OrcamentoVO, String> cell = new TableCell<OrcamentoVO, String>() {
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
                            ormIcon = orcamentosTableView.getSelectionModel().getSelectedItem();
                            orcamentos.remover(ormIcon);
                            
                            loadDataOrcamentos();
                            

                    });
                    editIconImg.setOnMouseClicked((MouseEvent event) -> {
                        ormIcon = orcamentosTableView.getSelectionModel().getSelectedItem();
                        System.out.println(ormIcon);
                        FXMLLoader loader = new FXMLLoader ();
                        loader.setLocation(getClass().getResource("../view/VE/addFXML/addOrcamento.fxml"));
                        try {
                            loader.load();
                        } catch (IOException ex) {
                            Logger.getLogger(Telas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        addBudgetController addOrcamentosController = loader.getController();
                        addOrcamentosController.setUpdate(true);
                        addOrcamentosController.setTextField(ormIcon.getClientName(), ormIcon.getAuto(), 
                                ormIcon.getCusto(), ormIcon.getServicos(), ormIcon.getData());
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
    public void gerarPFD(List<OrcamentoVO> lista) throws Exception {
		Double total = 0.0;
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream("relatorio.pdf"));
		doc.open();
		Paragraph rel = new Paragraph("Relatorio");
		rel.setAlignment(1);
		doc.add(new Paragraph(rel));
		doc.add(new Paragraph(""));

		
		PdfPTable tabela = new PdfPTable(5);
		
		PdfPCell cliente = new PdfPCell(new Paragraph("Cliente"));
		PdfPCell carro = new PdfPCell(new Paragraph("carro"));
		PdfPCell servico = new PdfPCell(new Paragraph("Servico"));
		PdfPCell valor = new PdfPCell(new Paragraph("Valor"));
		PdfPCell data = new PdfPCell(new Paragraph("Data"));
		
		tabela.addCell(cliente);
		tabela.addCell(carro);
		tabela.addCell(servico);
		tabela.addCell(valor);
		tabela.addCell(data);
		
		for(OrcamentoVO orc : lista) {
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
			String datapdf = date.format(orc.getData());
			total += orc.getCusto();
			
			cliente = new PdfPCell(new Paragraph(orc.getClientName().getName()));
			carro = new PdfPCell(new Paragraph(orc.getAuto().getPlaca()));
			servico = new PdfPCell(new Paragraph(orc.getServicos().getTipo()));
			valor = new PdfPCell(new Paragraph("R$" + String.valueOf(orc.getCusto())));
			data = new PdfPCell(new Paragraph(datapdf));
			
			tabela.addCell(cliente);
			tabela.addCell(carro);
			tabela.addCell(servico);
			tabela.addCell(valor);
			tabela.addCell(data);
		}
		
		PdfPCell vazio1 = new PdfPCell(new Paragraph(""));
		PdfPCell vazio2 = new PdfPCell(new Paragraph(""));
		PdfPCell vazio3 = new PdfPCell(new Paragraph(""));
		PdfPCell totalp = new PdfPCell(new Paragraph("R$" + String.valueOf(total)));
		
		tabela.addCell(vazio1);
		tabela.addCell(vazio2);
		tabela.addCell(vazio3);
		tabela.addCell(totalp);
		
		doc.add(tabela);
		
		

		doc.close();
	}

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
