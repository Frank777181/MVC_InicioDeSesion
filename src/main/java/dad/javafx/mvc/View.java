package dad.javafx.mvc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox {
	
	private Label userLabel,passwordLabel;
	private TextField userText;
	private PasswordField passwordText;
	private Button inicioButton, cancelarButton;
	
	public View() {
	
		userLabel = new Label("Usuario:");
		userLabel.setPrefWidth(80);
		
		passwordLabel = new Label("Contraseña:");
		passwordLabel.setPrefWidth(80);
		
		userText = new TextField();
		userText.setPromptText("Usuario");
		userText.setPrefColumnCount(10);
		
		passwordText = new PasswordField();
		passwordText.setPromptText("Contraseña");
		passwordText.setPrefColumnCount(10);
		
		inicioButton = new Button("Acceder");
		inicioButton.setDefaultButton(true);
		
		cancelarButton = new Button("Cancelar");
		
		HBox userHBox = new HBox(20, userLabel, userText);
		userHBox.setFillHeight(false);
		userLabel.setAlignment(Pos.BASELINE_LEFT);
		
		HBox passHBox = new HBox(20, passwordLabel, passwordText);
		passHBox.setFillHeight(false);
		passHBox.setAlignment(Pos.BASELINE_LEFT);
		
		HBox buttonHBox = new HBox(5, inicioButton, cancelarButton);
		buttonHBox.setFillHeight(false);
		buttonHBox.setAlignment(Pos.BASELINE_CENTER);
		
		getChildren().addAll(userHBox, passHBox, buttonHBox);
		setAlignment(Pos.CENTER);
		setSpacing(10);
		setFillWidth(false);
	}

	public TextField getUserText() {
		return userText;
	}

	public PasswordField getPasswordText() {
		return passwordText;
	}

	public Button getInicioButton() {
		return inicioButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	

}
