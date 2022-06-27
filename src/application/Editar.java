package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Editar extends Application {
	
	private static Stage stage;
	
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Editar.stage = stage;
	}

	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/view/Editar.FXML"));
		Scene scene = new Scene(root);
		stage.setTitle("Editar");
		stage.setScene(scene);
		stage.show();
		setStage(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
