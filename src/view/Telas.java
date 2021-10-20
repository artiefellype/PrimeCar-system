package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {

	private static Stage primaryStage;
	
	public static void main(String ... args) {
		launch();
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Sistema de Oficina");
		primaryStage.show();
		telaDeLogin();
	}
	
	
	public static void telaDeLogin() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		
	}
	
	public static void telaDeSplash() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaSplashScreen.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaDeClientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClientes.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaDeAutomoveis() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAutomóveis.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	
}
