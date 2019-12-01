package dad.javafx.mvc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	
	private final String usersFile = "users.csv";
	
	private Model model;
	private View view;
	
	public Controller() {
		
		model = new Model();
		view = new View();
		
		model.userProperty().bindBidirectional(view.getUserText().textProperty());
		model.passwordProperty().bindBidirectional(view.getPasswordText().textProperty());
		
		view.getInicioButton().setOnAction( e -> onLoginBtAction(e));
		view.getCancelarButton().setOnAction( e -> Platform.exit() );
	}
	
	private void onLoginBtAction(ActionEvent e) {
		
		String usuario = model.getUser();
		String contrasena = model.getPassword();
		
		if( usuario.isEmpty() || contrasena.isEmpty() || !isUserValid(usuario, contrasena) ) {
			errorDeInicio();
			model.setPassword("");
		}
		
		else {
			
			okDeInicio();
			Platform.exit();
		}
	}
	
	
	private boolean isUserValid(String nombreUsuario, String contrasena) {
		
		FileInputStream fichero = null;
		InputStreamReader inReader = null;
		BufferedReader buffReader = null;
		
		try {
			
			 fichero = new FileInputStream(usersFile);
			 inReader = new InputStreamReader(fichero, StandardCharsets.UTF_8);
			 buffReader = new BufferedReader(inReader);
			 
			 String linea;
			 
			 while( (linea = buffReader.readLine()) != null ) {
				 
				 String[] datos = linea.split(",");
				 if( nombreUsuario.equals(datos[0]) && encriptarPassword(contrasena).equals(datos[1]) ) {
					 return true;
				 }
			 }			
			 
		} catch (IOException e) {
		} finally {
			
			try {
				if( buffReader != null ) {
					buffReader.close();
				}
				
				if( inReader != null ) {
					inReader.close();
				}
				
				if( fichero != null ) {
					fichero.close();
				}
			} catch (IOException e) {
			}
		}
		
		return false;
	}
	
	private String encriptarPassword(String string) { 
		
		return DigestUtils.md5Hex(string).toUpperCase(); 
	}
	
	private void okDeInicio() {
		
		Alert confAlert = new Alert(AlertType.INFORMATION);
		confAlert.setHeaderText("ACCESO PERMITIDO");
		confAlert.setContentText("Las credenciales de acceso son válidas");
		confAlert.showAndWait();
	}

	private void errorDeInicio() {
		
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("ACCESO DENEGADO");
		errorAlert.setContentText("El usuario y/o la contraseña no son válidos");
		errorAlert.showAndWait();
	}
	
	public View getRootView() {
		return view;
	}

}
