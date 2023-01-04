package project.jdbc.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MyPageView {

	Scene scene = null;
	Stage primaryStage = null;
	BorderPane login = null;
	
	Button myInfoBtn;
	Button bookListBtn;
	Button pointBtn;
	Button dropBtn;

	public MyPageView(Scene scene, Stage primaryStage, BorderPane login) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.login = login;
	}

	public BorderPane getMyPage() {
		
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setPrefSize(1000, 500);
		flowpane.setVgap(20);
		
		myInfoBtn = new Button("내 정보 수정");
		myInfoBtn.setPrefSize(300, 40);
		myInfoBtn.setOnAction(e->{
			MyInfoView myInfoView = new MyInfoView();
			scene = new Scene(MyInfoView.getMyInfo(scene,primaryStage,root,login));
			primaryStage.setScene(scene);
			primaryStage.setTitle("내 정보 수정");
		});
		
		pointBtn = new Button("포인트 내역");
		pointBtn.setPrefSize(300, 40);
		pointBtn.setOnAction(e->{
			ManagerMembershipView managerMembershipView = new ManagerMembershipView(scene,primaryStage,root,login);
			scene = new Scene(managerMembershipView.getMemberList());
			primaryStage.setScene(scene);
			primaryStage.setTitle("포인트 내역");
		});
		
		bookListBtn = new Button("도서대여현황 & 반납하기");
		bookListBtn.setPrefSize(300, 40);
		bookListBtn.setOnAction(e->{
			ManagerBookListView managerBookListView = new ManagerBookListView(scene,primaryStage,root,login);
			scene = new Scene(managerBookListView.getBookList());
			primaryStage.setScene(scene);
			primaryStage.setTitle("도서 대여 목록");
		});
		
		dropBtn = new Button("회원 탈퇴");
		dropBtn.setPrefSize(300, 40);
		dropBtn.setOnAction(e->{
			
		});
		
		flowpane.getChildren().add(myInfoBtn);
		flowpane.getChildren().add(bookListBtn);
		flowpane.getChildren().add(pointBtn);
		flowpane.getChildren().add(dropBtn);
		
		root.setCenter(flowpane);
		
		
		return root;
	}

	
	
}
