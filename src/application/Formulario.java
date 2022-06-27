package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Formulario extends Application {
	
	private static Stage stage;
	
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Formulario.stage = stage;
	}

	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/Formulario.FXML"));
		Scene scene = new Scene(root);
		stage.setTitle("Formulario");
		stage.setScene(scene);
		stage.show();
		setStage(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
