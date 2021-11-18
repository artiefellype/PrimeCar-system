package controller;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.AdminBO;
import model.vo.AdminVO;
import view.Telas;

public class LoginController{
	
	// ---------------- Admin functions --------------------------
		
		
		@FXML
	    private TextField loginText;
	    @FXML
	    private PasswordField passText;
	    @FXML
	    private Label warningTextField;
	    
	    AdminBO<AdminVO> admin = new AdminBO<AdminVO>();
	    private Boolean exist = false;
	    // Realizar login com admin cadastrado
	    
	    public void autenticate(ActionEvent event) {
	    	AdminVO adm = new AdminVO();
	    	adm.setName(loginText.getText());
	    	adm.setSenha(passText.getText());
	    	System.out.println("Foi");
	    	
	    	//Abrir splashScreen
	    	if(admin.login(adm)) {
	    		try {
	    			Telas.telaDeSplash();
	    		}catch(Exception e) {
	    			System.out.println("ERRO@>> " + e);
	    		}
	    		
	    	}else{
	    		warningTextField.setText("NOME OU SENHA INCORRETOS");
	    	}
	    } 
	 // ---------------- END Admin functions --------------------------
	  /*   
	 // ---------------- Clientes functions --------------------------
	    
	    @FXML
	    private ListView<String> clienteListCpf;

	    @FXML
	    private ListView<String> clienteListEndereco;

	    @FXML
	    private ListView<String> clienteListNome;
	 
	    private ObservableList<String> obsClientNames;
	    private ObservableList<String> obsClientEnder;
	    private ObservableList<String> obsClientCpf;
	    
	    private List<String> clientNames = new ArrayList<>();
	    private List<String> clientEnderecos = new ArrayList<>();
	    private List<String> clientCpfs = new ArrayList<>();
	    
	    ClienteBO<ClienteVO> client = new ClienteBO<ClienteVO>();
	    
	    // Carregar clientes cadastrados
	    
	     public void loadDataClientes() {
	    	 //removendo caso já esteja na tela
	    	 if(obsClientNames != null) {
	    		clientNames.removeAll(clientNames);
	    		clientEnderecos.removeAll(clientEnderecos);
	    		clientCpfs.removeAll(clientCpfs);
	    	 }
	    	 
	    	 clienteListNome.refresh();
	    	 clienteListEndereco.refresh();
	    	 clienteListCpf.refresh();
	    	 
	    	 List<ClienteVO> clientes = client.listarBO();
	    	 
	    	 // Adicionando propriedades selecionadas da lista ClienteVO a cada lista de strings
	    	 for(ClienteVO clientesShow : clientes) {
	 			clientNames.add(clientesShow.getName());
	 			clientEnderecos.add(clientesShow.getEndereco());
	 			clientCpfs.add(clientesShow.getCPF());
	 		}
	    	 
	    	 // Transformando as listas de strings já preenchidas em listas observáveis
	    	 obsClientNames = FXCollections.observableArrayList(clientNames);
	    	 obsClientEnder = FXCollections.observableArrayList(clientEnderecos);
	    	 obsClientCpf = FXCollections.observableArrayList(clientCpfs);
	    	 
	    	 System.out.println(clientNames);
	    	 // Pondo as listas observáveis dentro do listview da tela para visualização
	    	 clienteListNome.setItems(obsClientNames);
	    	 clienteListEndereco.setItems(obsClientEnder);
	    	 clienteListCpf.setItems(obsClientCpf);
	    	 
	    	 
	    	 
	    	 Fazendo com que cada listview 'escute' o scroll do outro
	    	  para que possam realizar a ação do scroll em conjunto
	    	 
	    	 Node n1 = clienteListNome.lookup(".scroll-bar");
	         if (n1 instanceof ScrollBar) {
	             final ScrollBar bar1 = (ScrollBar) n1;
	             Node n2 = clienteListEndereco.lookup(".scroll-bar");
	             if (n2 instanceof ScrollBar) {
	                 final ScrollBar bar2 = (ScrollBar) n2;
	                 Node n3 = clienteListCpf.lookup(".scroll-bar");
	                 if (n3 instanceof ScrollBar) {
		                 final ScrollBar bar3 = (ScrollBar) n3;
		                 bar1.valueProperty().bindBidirectional(bar2.valueProperty());
		                 bar1.valueProperty().bindBidirectional(bar3.valueProperty());
	                 }    
	             }
	         }
	    	 
	    	 
	     
	     }
	     */
	 // ---------------- END Clientes functions --------------------------
     
	 // ---------------- Automovel functions --------------------------
	   
	    /*
	     @FXML
	     private ListView<String> AutoListAno;

	     @FXML
	     private ListView<String> AutoListCliente;

	     @FXML
	     private ListView<String> AutoListCor;

	     @FXML
	     private ListView<String> AutoListKm;

	     @FXML
	     private ListView<String> AutoListMarca;

	     @FXML
	     private ListView<String> AutoListPlaca;

	    // @FXML
	     //private TextField clienteInput;
	     
	     private ObservableList<String> obsAutoListAno;
		 private ObservableList<String> obsAutoListCliente;
		 private ObservableList<String> obsAutoListCor;
		 private ObservableList<String> obsAutoListKm;
		 private ObservableList<String> obsAutoListMarca;
		 private ObservableList<String> obsAutoListPlaca;
		 
		 
		 private List<String> autoAno = new ArrayList<>();
		 private List<String> autoCliente = new ArrayList<>();
		 private List<String> autoCor = new ArrayList<>();
		 private List<String> autoKm = new ArrayList<>();
		 private List<String> autoMarca = new ArrayList<>();
		 private List<String> autoPlaca = new ArrayList<>();
	     
		 AutoBO<AutoVO> automo = new AutoBO<AutoVO>();
		 
		// Carregar Automoveis cadastrados
		 
		 public void loadDataAuto() {
			//removendo caso já esteja na tela
			 if(obsAutoListMarca != null) {
		    		autoAno.removeAll(autoAno);
		    		autoCliente.removeAll(autoCliente);
		    		autoCor.removeAll(autoCor);
		    		autoKm.removeAll(autoKm);
		    		autoMarca.removeAll(autoMarca);
		    		autoPlaca.removeAll(autoPlaca);
		    	 }
		    	 
		    	 AutoListAno.refresh();
		    	 AutoListCliente.refresh();
		    	 AutoListCor.refresh();
		    	 AutoListKm.refresh();
		    	 AutoListMarca.refresh();
		    	 AutoListPlaca.refresh();
		    	 
		    	 
		    	 List<AutoVO> automoveis = automo.listarBO();
		    	 //Adicionando propriedades selecionadas da lista AutoVO a cada lista de strings
		    	 for(AutoVO autoShow : automoveis) {
			 			autoAno.add((autoShow.getAno()).toString());
			 			autoCliente.add(autoShow.getProprietario().getCPF());
			 			autoCor.add(autoShow.getCor());
			 			autoKm.add((autoShow.getQuilometragem()).toString());
			 			autoMarca.add(autoShow.getMarca());
			 			autoPlaca.add(autoShow.getPlaca());
			 		}
		    	 
		    	 // Transformando as listas de strings já preenchidas em listas observáveis
		    	 obsAutoListAno = FXCollections.observableArrayList(autoAno);
		    	 obsAutoListCliente = FXCollections.observableArrayList(autoCliente);
		    	 obsAutoListCor = FXCollections.observableArrayList(autoCor);
		    	 obsAutoListKm = FXCollections.observableArrayList(autoKm);
		    	 obsAutoListMarca = FXCollections.observableArrayList(autoMarca);
		    	 obsAutoListPlaca = FXCollections.observableArrayList(autoPlaca);
		    	 
		    	 System.out.println(autoCliente);
		    	 // Pondo as listas observáveis dentro do listview da tela para visualização
		    	 AutoListAno.setItems(obsAutoListAno);
		    	 AutoListCliente.setItems(obsAutoListCliente);
		    	 AutoListCor.setItems(obsAutoListCor);
		    	 AutoListKm.setItems(obsAutoListKm);
		    	 AutoListMarca.setItems(obsAutoListMarca);
		    	 AutoListPlaca.setItems(obsAutoListPlaca);
		    	 
		    	 
		    	  Fazendo com que cada listview 'escute' o scroll do outro
		    	  para que possam realizar a ação do scroll em conjunto
		    	 
		    	 Node n1 = AutoListMarca.lookup(".scroll-bar");
		         if (n1 instanceof ScrollBar) {
		             final ScrollBar bar1 = (ScrollBar) n1;
		             Node n2 = AutoListCor.lookup(".scroll-bar");
		             if (n2 instanceof ScrollBar) {
		                 final ScrollBar bar2 = (ScrollBar) n2;
		                 Node n3 = AutoListPlaca.lookup(".scroll-bar");
		                 if (n3 instanceof ScrollBar) {
			                 final ScrollBar bar3 = (ScrollBar) n3;
			                 Node n4 = AutoListAno.lookup(".scroll-bar");
			                 if (n4 instanceof ScrollBar) {
				                 final ScrollBar bar4 = (ScrollBar) n4;
				                 Node n5 = AutoListKm.lookup(".scroll-bar");
				                 if (n5 instanceof ScrollBar) {
					                 final ScrollBar bar5 = (ScrollBar) n5;
					                 Node n6 = AutoListCliente.lookup(".scroll-bar");
					                 if (n6 instanceof ScrollBar) {
						                 final ScrollBar bar6 = (ScrollBar) n6;
						                 bar1.valueProperty().bindBidirectional(bar2.valueProperty());
						                 bar2.valueProperty().bindBidirectional(bar3.valueProperty());
						                 bar3.valueProperty().bindBidirectional(bar4.valueProperty());
						                 bar4.valueProperty().bindBidirectional(bar5.valueProperty());
						                 bar5.valueProperty().bindBidirectional(bar6.valueProperty());
					                 }
					                 
				                 }
			                 }
			                 
		                 }    
		             }
		         }
		    	 
		    	 
		    	 
		    	 
		 }

			*/
	  // ---------------- END Automovel functions --------------------------
	  // ---------------- Servicos functions --------------------------	 
		 
		 	/*
		 
		 	@FXML
		    private TextField clienteInput;

		    @FXML
		    private ListView<String> servicosListCarro;

		    @FXML
		    private ListView<String> servicosListFinalizado;

		    @FXML
		    private ListView<String> servicosListNome;

		    @FXML
		    private ListView<String> servicosListValor;

		    private ObservableList<String> obsServicosListCarro;
			private ObservableList<String> obsServicosListFinalizado;
			private ObservableList<String> obsServicosListNome;
			private ObservableList<String> obsServicosListValor;
		    
			 private List<String> servicosNome = new ArrayList<>();
			 private List<String> servicosCarro = new ArrayList<>();
			 private List<String> servicosFinalizado = new ArrayList<>();
			 private List<String> servicosValor = new ArrayList<>();
			 
			 
		    ServicoBO<ServicosVO> servicos = new ServicoBO<ServicosVO>();
		    
		    public void loadDataServicos() {
		    	if(obsServicosListNome != null) {
		    		servicosNome.removeAll(servicosNome);
		    		servicosCarro.removeAll(servicosCarro);
		    		servicosFinalizado.removeAll(servicosFinalizado);
		    		servicosValor.removeAll(servicosValor);
		    		
		    	 }
		    	
		    	 servicosListNome.refresh();
		    	 servicosListCarro.refresh();
		    	 servicosListFinalizado.refresh();
		    	 servicosListValor.refresh();
		    	
		    	List<ServicosVO> servs = servicos.listarBO();
		    	 //Adicionando propriedades selecionadas da lista AutoVO a cada lista de strings
		    	 for(ServicosVO servShow : servs) {
			 			servicosNome.add(servShow.getTipo());
			 			servicosCarro.add(servShow.getAuto().getPlaca());
			 			servicosFinalizado.add(servShow.getFinalizado().toString());
			 			servicosValor.add((servShow.getValor()).toString());
			 		}
		    	 
		    	 // Transformando as listas de strings já preenchidas em listas observáveis
		    	 obsServicosListNome = FXCollections.observableArrayList(servicosNome);
		    	 obsServicosListCarro = FXCollections.observableArrayList(servicosCarro);
		    	 obsServicosListFinalizado = FXCollections.observableArrayList(servicosFinalizado);
		    	 obsServicosListValor = FXCollections.observableArrayList(servicosValor);
		    	 
		    	 System.out.println(servicosNome);
		    	 // Pondo as listas observáveis dentro do listview da tela para visualização
		    	 servicosListNome.setItems(obsServicosListNome);
		    	 servicosListCarro.setItems(obsServicosListCarro);
		    	 servicosListValor.setItems(obsServicosListValor);
		    	 servicosListFinalizado.setItems(obsServicosListFinalizado);
		    	
		    	
		    }
		    
		   
		    */
		 
	  // ---------------- END Servicos functions --------------------------
	    
		public void exist(Boolean value) {
			this.exist = value;
		}
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
	    public void toCadastro(ActionEvent event){
	    	try {
	    		Telas.telaDeCadastro();
	    	}catch(Exception e) {
	    		System.out.println("ERRO@>" + e);
	    	}
	    	
	    }
	    public void toRecuperacao(ActionEvent event){
	    	try {
	    		Telas.telaDeRecuperacao();
	    	}catch(Exception e) {
	    		System.out.println("ERRO@>" + e);
	    	}
	    	
	    }

}
