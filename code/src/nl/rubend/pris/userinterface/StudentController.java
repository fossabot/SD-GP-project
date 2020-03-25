package nl.rubend.pris.userinterface;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nl.rubend.pris.model.Gebruiker;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentController implements Initializable, IngelogdGebruiker {
	Gebruiker gebruiker;
	ArrayList<AnchorPane> allPanes = new ArrayList();

	@Override
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker=gebruiker;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		switchToPane(welkomPane);
		welkomLabel.setText("Welkom ");
	}

	@FXML
	private Button ziekMenuButton;

	@FXML
	private Button lesMenuButton;

	@FXML
	private Button langdurigMenuButton;

	@FXML
	private GridPane gridContainer;

	@FXML
	private AnchorPane welkomPane;

	@FXML
	private Label welkomLabel;

	@FXML
	private AnchorPane ziekPane;

	@FXML
	private AnchorPane lesPane;

	@FXML
	private AnchorPane langdurigPane;

	private void switchToPane(AnchorPane targetPane){
		allPanes.add(welkomPane);
		allPanes.add(ziekPane);
		allPanes.add(lesPane);
		allPanes.add(langdurigPane);

		for (AnchorPane pane : allPanes){
			if(pane.equals(targetPane)){
				pane.setVisible(true);
				pane.setDisable(false);
			}
			else{
				pane.setVisible(false);
				pane.setDisable(true);
			}
		}
	}

	@FXML
	void toonLangdurig(ActionEvent event) {
		switchToPane(langdurigPane);
	}

	@FXML
	void toonLesAfmelden(ActionEvent event) {
		switchToPane(lesPane);
	}

	@FXML
	void toonZiekmelden(ActionEvent event) {
		switchToPane(ziekPane);
	}

}
