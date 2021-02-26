package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	SQLcoms coms = new SQLcoms();

	@Override
	public void start(Stage primaryStage) {
		// Vérifie si on a bien le driver JDBC MySQL dans classpath //
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver trouvé");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non présent dans classpath");
		}
		try {
			StackPane root = (StackPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		coms.close();
		super.stop();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
