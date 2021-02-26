package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Window;

public class SampleController {

	@FXML
	private AnchorPane center;
	@FXML
	private StackPane innercenter;
	@FXML
	private TextField idtxt;
	@FXML
	private Label idLabel;
	

	@FXML
	public void initialize() {
		idtxt.setFocusTraversable(false);
	}

}
