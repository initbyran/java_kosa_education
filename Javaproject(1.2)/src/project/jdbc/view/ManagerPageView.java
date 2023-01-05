package project.jdbc.view;

import java.sql.Date;
import java.time.LocalDate;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.BookEditController;

public class ManagerPageView {

	Scene scene = null;
	Stage primaryStage = null;
    BorderPane login = null;
   
    Button bookListBtn;
    Button overdueBtn;
    Button membershipBtn;
    
	public ManagerPageView(Stage primaryStage,Scene scene ,BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.scene=scene;
		this.login = root;
	}
	

	public BorderPane getmanagerPage() {
		
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setPrefSize(1000, 500);
		flowpane.setVgap(20);
		
		bookListBtn = new Button("도서관리");
		bookListBtn.setPrefSize(300, 40);
		bookListBtn.setOnAction(e->{
			ManagerBookListView managerBookListView = new ManagerBookListView(scene,primaryStage,root,login);
			scene = new Scene(managerBookListView.getBookList());
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 도서 관리");
		});
		overdueBtn = new Button("미납 현황");
		overdueBtn.setPrefSize(300, 40);
		overdueBtn.setOnAction(e->{ 
	
			ManagerOverdueView managerOverdueView = new ManagerOverdueView(scene,primaryStage,root,login);
			scene = new Scene(managerOverdueView.getOverdueList());
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 미납 현황");
			
		});
		membershipBtn = new Button("회원관리");
		membershipBtn.setPrefSize(300, 40);
		membershipBtn.setOnAction(e->{
			ManagerMembershipView managerMembershipView = new ManagerMembershipView(scene,primaryStage,root,login);
			scene = new Scene(managerMembershipView.getMemberList());
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 회원 관리");
		});
		
		flowpane.getChildren().add(bookListBtn);
		flowpane.getChildren().add(overdueBtn);
		flowpane.getChildren().add(membershipBtn);
		
		root.setCenter(flowpane);
		
		return root;
	}
    
	
}
