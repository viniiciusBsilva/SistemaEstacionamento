package view;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Editar;
import application.Formulario;
import application.Principal;
import application.Saida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Movimentacao;

public class PrincipalController implements Initializable{
	
    @FXML private Button btEditar;
    @FXML private Button btEntrada;

    @FXML private Button btSaida;

    @FXML private ComboBox<?> cbVeiculo;

    @FXML private TableColumn<Movimentacao, Date> clmHoraEn;

    @FXML private TableColumn<Movimentacao, Date> clmHoraSa;

    @FXML private TableColumn<Movimentacao, Long> clmId;

    @FXML private TableColumn<Movimentacao, String> clmModelo;

    @FXML private TableColumn<Movimentacao, String> clmPlaca;

    @FXML private TableColumn<Movimentacao, Time> clmTempo;

    @FXML private TableColumn<Movimentacao, Double> clmValor;

    @FXML private TableView<Movimentacao> lvTabela;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btEntrada.setOnMouseClicked((MouseEvent e)-> {
			Formulario f = new Formulario();
			try {
				f.start(new Stage());
				fecha();
			}catch (Exception ex){
				Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		});	
		btEditar.setOnMouseClicked((MouseEvent e)-> {
			Editar ed = new Editar();
			try {
				ed.start(new Stage());
				fecha();
			}catch (Exception ex){
				Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		});	
		btSaida.setOnMouseClicked((MouseEvent e)-> {
			Saida s = new Saida();
			try {
				s.start(new Stage());
				fecha();
			}catch (Exception ex){
				Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		});	
	}
    
	public void fecha() {
		Principal.getStage().close();
	}
	
	

}
