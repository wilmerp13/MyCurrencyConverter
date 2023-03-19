package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	private Converter converter = new Converter();

	@FXML
	private ChoiceBox<Moneda> myChoiceBox;

//	private String[] Currencies = {"HNL", "USD", "YEN"};
	
	@FXML
	private TextField cantidadTextField;
	
	@FXML
	private TextArea resultTextArea;

	@FXML
	private ChoiceBox<Moneda> mySecondChoiceBox;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		myChoiceBox.getItems().addAll(converter.getMonedas());
		mySecondChoiceBox.getItems().addAll(converter.getMonedas());
	}
	
	public void convertir() {
		resultTextArea.clear();
		Moneda coin1 = myChoiceBox.getValue();
		Moneda coin2 = mySecondChoiceBox.getValue();
		double amount= Double.parseDouble((cantidadTextField.getText()));
		String result;
		
		result = converter.convertAndPrint(coin1.getId(), amount, coin2.getId());
		resultTextArea.appendText(result);
		
		
	}
	
	

}
