package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaDeLogin extends Application {
	
	public static void main (String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent root = FXMLLoader.load(getClass().getResource("VE/telaLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("Sistema de oficina");
		primaryStage.setScene(cena);
		primaryStage.show();
		
		
	}

}
