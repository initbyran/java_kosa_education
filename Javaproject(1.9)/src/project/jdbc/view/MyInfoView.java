package project.jdbc.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import project.jdbc.controller.MemberSearchByKeywordController;
import project.jdbc.controller.MyInfoEditController;
import project.jdbc.vo.MembershipVO;

public class MyInfoView {

	Scene scene = null;
	Stage primaryStage = null;
    BorderPane login = null;
    BorderPane mypage = null;
    String loginId;
    String text;
    Button editBtn;
    Button logoutBtn;
	
	public MyInfoView(Scene scene, Stage primaryStage, BorderPane root, BorderPane login, String loginId) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.login = login;
		this.mypage = root;
		this.loginId = loginId;
	}

	public BorderPane getMyInfo() {
		
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(20);
		gridPane.setHgap(30);
		
		Label id = new Label("아이디");
		id.setPrefSize(100, 40);
		id.setAlignment(Pos.CENTER_RIGHT);
		GridPane.setConstraints(id, 0, 0);
		TextField idField = new TextField();
		idField.setPrefSize(250, 40);
		GridPane.setConstraints(idField, 1, 0);
		
		Label pw = new Label("비밀번호");
		pw.setPrefSize(100, 40);
		pw.setAlignment(Pos.CENTER_RIGHT);
		GridPane.setConstraints(pw, 0, 1);
		TextField pwField = new TextField();
		pwField.setPrefSize(250, 40);
		GridPane.setConstraints(pwField, 1, 1);
		
		Label name = new Label("이름");
		name.setPrefSize(100, 40);
		name.setAlignment(Pos.CENTER_RIGHT);
		GridPane.setConstraints(name, 0, 2);
		TextField nameField = new TextField();
		nameField.setPrefSize(250, 40);
		GridPane.setConstraints(nameField, 1, 2);
		
		Label birth = new Label("생년월일(6자리)");
		birth.setPrefSize(100, 40);
		birth.setAlignment(Pos.CENTER_RIGHT);
		GridPane.setConstraints(birth, 0, 3);
		TextField birthField = new TextField();
		birthField.setPrefSize(250, 40);
		GridPane.setConstraints(birthField, 1, 3);
		
		Label phone = new Label("휴대전화");
		phone.setPrefSize(100, 40);
		phone.setAlignment(Pos.CENTER_RIGHT);
		GridPane.setConstraints(phone, 0, 4);
		TextField phoneField = new TextField();
		phoneField.setPrefSize(250, 40);
		GridPane.setConstraints(phoneField, 1, 4);
		
		Label email = new Label("이메일");
		email.setPrefSize(100, 40);
		email.setAlignment(Pos.CENTER_RIGHT);
		GridPane.setConstraints(email, 0, 5);
		TextField emailField = new TextField();
		emailField.setPrefSize(250, 40);
		GridPane.setConstraints(emailField, 1, 5);
		
		idField.setText(loginId);
		MemberSearchByKeywordController mcontroller = new MemberSearchByKeywordController();
		MembershipVO membership = mcontroller.getResult2(loginId);
		pwField.setText(membership.getMpw());
		nameField.setText(membership.getMname());
		birthField.setText(membership.getMbirth());
		phoneField.setText(membership.getMphonenumber());
		emailField.setText(membership.getMemail());
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPrefSize(1000, 50);
		flowPane.setPadding(new Insets(50));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setHgap(10);
		flowPane.setAlignment(Pos.CENTER);
		
		editBtn = new Button("수정");
		editBtn.setPrefSize(130, 50);
		editBtn.setOnAction(e->{
			MyInfoEditController controller = new MyInfoEditController();
			controller.getResult(idField.getText(),pwField.getText(),nameField.getText(),birthField.getText(),phoneField.getText(),emailField.getText(),loginId);
		});
		
		logoutBtn = new Button("로그아웃");
		logoutBtn.setPrefSize(130, 50);
		logoutBtn.setOnAction(e->{
			Dialog<String> dialog = new Dialog<String>();
			dialog.setTitle("로그아웃");
			ButtonType type = new ButtonType("로그아웃", ButtonData.OK_DONE);
			String str = "로그아웃하시겠습니까?";
			dialog.setContentText(str);
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.getDialogPane().setMinHeight(300);
			dialog.showAndWait();
        	scene.setRoot(login);
			primaryStage.setScene(scene);
		});
		
		gridPane.getChildren().addAll(id,idField,pw,pwField,name,nameField,birth,birthField,phone,phoneField,email,emailField);
		flowPane.getChildren().add(editBtn);
		flowPane.getChildren().add(logoutBtn);
		gridPane.setAlignment(Pos.CENTER);
		root.setCenter(gridPane);
		root.setBottom(flowPane);
		
		return root;
	}

}
