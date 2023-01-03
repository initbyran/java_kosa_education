package project.jdbc.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ManagerOverdueView {
	Scene scene = null;
	Stage primaryStage = null;
    BorderPane root = null;
    Button signUpBtn;

	public ManagerOverdueView(Scene scene, Stage primaryStage, BorderPane root) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.root = root;
	}

	public BorderPane getOverdueList() {
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		return null;
	}

}
