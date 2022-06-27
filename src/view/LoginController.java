package view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Main;
import application.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	
    @FXML
    private Button btEntrar;

    @FXML
    private Button btSair;

    @FXML
    private PasswordField txSenha;

    @FXML
    private TextField txUsuario;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btEntrar.setOnMouseClicked((MouseEvent e)-> {
			if((txUsuario.getText().equals("admin")) && (txSenha.getText().equals("123456"))) {
				Principal p = new Principal();
				try {
					p.start(new Stage());
					fecha();
				}catch (Exception ex){
					Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
				}
			
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Erro");
				alert.setTitle("Erro");
				alert.setContentText(" login inválido!!");
				alert.show();
			}
			
		});
		btSair.setOnMouseClicked((MouseEvent e)-> {
			fecha();
		});	
		
	}
	public void fecha() {
		Main.getStage().close();
	}
	
}
