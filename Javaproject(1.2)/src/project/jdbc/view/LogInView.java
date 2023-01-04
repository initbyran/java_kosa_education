package project.jdbc.view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import project.jdbc.controller.LoginController;
import project.jdbc.service.MembershipService;

public class LogInView extends Application {
 
	Scene scene = null;
	TextField idField;
	PasswordField passwordField;
	Button logInBtn;
	Button signUpBtn;
	Button managerLogInBtn;
	
	String loginId;
	String loginPw;
	String searchKeyword;
	Stage primaryStage = null;
    BorderPane root = null;

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
		
		Label id = new Label("아이디");
		id.setPrefSize(80, 40);
		id.setAlignment(Pos.CENTER_RIGHT);
		Label pw = new Label("비밀번호");
		pw.setPrefSize(80, 40);
		pw.setAlignment(Pos.CENTER_RIGHT);
		idField = new TextField();
		idField.setText("test");
		idField.setPrefSize(250, 40);
		passwordField = new PasswordField();
		passwordField.setText("test");
		passwordField.setPrefSize(250, 40);
		
		FlowPane idFlowPane = new FlowPane();
		idFlowPane.setAlignment(Pos.CENTER);
		idFlowPane.setHgap(10);

		idFlowPane.getChildren().add(id);
		idFlowPane.getChildren().add(idField);
		
		FlowPane passwordFlowPane = new FlowPane();
		passwordFlowPane.setAlignment(Pos.CENTER);
		passwordFlowPane.setHgap(10);
		
		passwordFlowPane.getChildren().add(pw);
		passwordFlowPane.getChildren().add(passwordField);
		
		FlowPane logInInfoFlowPane = new FlowPane();
		logInInfoFlowPane.setAlignment(Pos.CENTER);
		logInInfoFlowPane.setOrientation(Orientation.VERTICAL);
		logInInfoFlowPane.setPrefSize(1000, 100);
		logInInfoFlowPane.setVgap(15);
		
		logInInfoFlowPane.getChildren().add(idFlowPane);
		logInInfoFlowPane.getChildren().add(passwordFlowPane);
		
	    logInBtn = new Button("로그인");
	    logInBtn.setPrefSize(150, 40);
	    logInBtn.setOnAction(e->{
	    	LoginController controller = new LoginController();
	    	
	        loginId = idField.getText();
	    	loginPw = passwordField.getText();
	    	
	    	if(controller.getResult(loginId, loginPw)) {
	    		
			 BookSearchView bookSearchView = new BookSearchView(primaryStage,root,scene,loginId);
	         scene = new Scene(bookSearchView.getBookSearch());
	         primaryStage.setScene(scene);
	         primaryStage.setTitle("도서 검색 & 대여");
	    	} else {
	    		Alert loginFail = new Alert(AlertType.ERROR);
	    		loginFail.setHeaderText("로그인 실패");
	    		loginFail.setContentText("아이디 또는 비밀번호가 옳지 않습니다.");
	    		loginFail.showAndWait();
	    	}
	    });
		
		managerLogInBtn = new Button("관리자 로그인");
		managerLogInBtn.setPrefSize(150, 40);
		managerLogInBtn.setOnAction(e->{
			LoginController controller = new LoginController();
			loginId = idField.getText();
		    loginPw = passwordField.getText();
		    
		    if(loginPw.equals(controller.getResult2(loginId).getManagerpw())) {
		    	ManagerPageView managerPageView = new ManagerPageView(primaryStage,scene,root);
		    	scene = new Scene(managerPageView.getmanagerPage());
		    	primaryStage.setScene(scene);
		    	primaryStage.setTitle("관리자 페이지");
		    } else {
		    	Alert loginFail = new Alert(AlertType.ERROR);
	    		loginFail.setHeaderText("관리자 로그인 실패");
	    		loginFail.setContentText("아이디 또는 비밀번호가 옳지 않습니다.");
	    		loginFail.showAndWait();
		    }
		    
		});
		
	    signUpBtn = new Button("회원가입");
	    signUpBtn.setPrefSize(150, 40);
		signUpBtn.setOnAction(e->{
			SignUpView signUpView = new SignUpView(primaryStage,root,scene);
			scene = new Scene(signUpView.getSignUP());
			primaryStage.setScene(scene);
			primaryStage.setTitle("회원가입");
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
