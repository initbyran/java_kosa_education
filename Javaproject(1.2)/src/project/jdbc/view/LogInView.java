package project.jdbc.view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LogInView extends Application {
 
	Scene scene = null;
	TextField idField;
	TextField passwordField;
	Button logInBtn;
	Button signUpBtn;
	Button managerLogInBtn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane btnFlowPane = new FlowPane();
		btnFlowPane.setPadding(new Insets(10,10,10,10));
		btnFlowPane.setColumnHalignment(HPos.CENTER);
		btnFlowPane.setOrientation(Orientation.VERTICAL);
		btnFlowPane.setAlignment(Pos.CENTER);
		btnFlowPane.setPrefSize(1000, 350);
		btnFlowPane.setVgap(15);
		
		Label id = new Label("  아이디");
		Label pw = new Label("비밀번호");
		idField = new TextField();
		idField.setPrefSize(250, 40);
		passwordField = new TextField();
		passwordField.setPrefSize(250, 40);
		
		FlowPane idFlowPane = new FlowPane();
		idFlowPane.setPadding(new Insets(10,10,10,10));
		idFlowPane.setColumnHalignment(HPos.CENTER);
		idFlowPane.setAlignment(Pos.CENTER);
		idFlowPane.setHgap(10);

		idFlowPane.getChildren().add(id);
		idFlowPane.getChildren().add(idField);
		
		FlowPane passwordFlowPane = new FlowPane();
		passwordFlowPane.setPadding(new Insets(10,10,10,10));
		passwordFlowPane.setColumnHalignment(HPos.CENTER);
		passwordFlowPane.setAlignment(Pos.CENTER);
		passwordFlowPane.setHgap(10);
		
		passwordFlowPane.getChildren().add(pw);
		passwordFlowPane.getChildren().add(passwordField);
		
		FlowPane logInInfoFlowPane = new FlowPane();
		logInInfoFlowPane.setPadding(new Insets(10,10,10,10));
		logInInfoFlowPane.setColumnHalignment(HPos.CENTER);
		logInInfoFlowPane.setAlignment(Pos.CENTER);
		logInInfoFlowPane.setOrientation(Orientation.VERTICAL);
		logInInfoFlowPane.setPrefSize(1000, 100);
		logInInfoFlowPane.setVgap(15);
		
		logInInfoFlowPane.getChildren().add(idFlowPane);
		logInInfoFlowPane.getChildren().add(passwordFlowPane);
		
	    logInBtn = new Button("로그인");
	    logInBtn.setPrefSize(150, 40);
	    logInBtn.setOnAction(e->{
			 BookSearchView bookSearchView = new BookSearchView(primaryStage,root);
	         scene = new Scene(bookSearchView.getBookSearch());
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("도서 검색 & 대여");
	    });
		
	    signUpBtn = new Button("회원가입");
	    signUpBtn.setPrefSize(150, 40);
		signUpBtn.setOnAction(e->{
			
		});
		
		managerLogInBtn = new Button("관리자 로그인");
		managerLogInBtn.setPrefSize(150, 40);
		managerLogInBtn.setOnAction(e->{
			
		});
		
	    btnFlowPane.getChildren().add(logInBtn);
	    btnFlowPane.getChildren().add(signUpBtn);
	    btnFlowPane.getChildren().add(managerLogInBtn);
	    
		root.setCenter(logInInfoFlowPane);
		root.setBottom(btnFlowPane);
		
	    scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("도서관 로그인");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
