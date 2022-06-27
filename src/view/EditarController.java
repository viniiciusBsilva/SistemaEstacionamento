package view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Editar;
import application.Principal;
import dao.DaoFactory;
import dao.MovimentacaoDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Movimentacao;

public class EditarController implements Initializable{
    @FXML
    private Button btCancelar;

    @FXML
    private Button btInserir;

    @FXML
    private ComboBox<?> cbEscolherVeiculo;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfPlaca;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btCancelar.setOnMouseClicked((MouseEvent e)->{
			abrePrincipal();
			fecha();
		});

	}

    public void fecha() {
    	Editar.getStage().close();
    }
    public void abrePrincipal() {
    	Principal p = new Principal();
    	try {
    		p.start(new Stage());
    	}catch(Exception ex) {
    		Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }
    public void editaVeiculo() {
    	String Placa = tfPlaca.getText(), 
    		   modelo = tfModelo.getText(); 
    	Movimentacao m = new Movimentacao(Placa,modelo);
    	MovimentacaoDao mv = DaoFactory.createMovimentacaoDao();
    	try{
    		mv.update(m);
    		Alert a1= new Alert(AlertType.CONFIRMATION);
    		a1.setHeaderText("Veiculo Editado com Sucesso");
    		abrePrincipal();
    		a1.show();
    	}catch(Exception ex){
    		Alert a1= new Alert(AlertType.ERROR);
    		a1.setHeaderText("Erro ou editar veículo");
    		a1.show();
    	}
    }
   
}
