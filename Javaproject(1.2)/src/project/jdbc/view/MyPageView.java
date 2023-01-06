package project.jdbc.view;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.PointController;
import project.jdbc.controller.UnregisterController;
import project.jdbc.vo.BookVO;
import project.jdbc.vo.MembershipVO;

public class MyPageView {

	Scene scene = null;
	Stage primaryStage = null;
	BorderPane login = null;
	TableView<BookVO> tableView;
	Button myInfoBtn;
	Button bookListBtn;
	Button pointBtn;
	Button dropBtn;
	
	String loginId;

	public MyPageView(Scene scene, Stage primaryStage, BorderPane login, String loginId) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.login = login;
		this.loginId = loginId;
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
			MyInfoView myInfoView = new MyInfoView(scene, primaryStage, root, login, loginId);
			
			scene.setRoot(myInfoView.getMyInfo());
			primaryStage.setScene(scene);
			primaryStage.setTitle("내 정보 수정");
		});
		
		pointBtn = new Button("포인트 내역");
		pointBtn.setPrefSize(300, 40);
		pointBtn.setOnAction(e->{
			PointController pcontroller = new PointController();
			
			Dialog<String> dialog = new Dialog<String>();
			dialog.setTitle("포인트 조회");
			ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
			String str = "현재 잔여 포인트 : " + pcontroller.getResult3(loginId);
			dialog.setContentText(str);
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.getDialogPane().setMinHeight(300);
			dialog.showAndWait();
        	
		});
		
		bookListBtn = new Button("도서대여현황 & 반납하기");
		bookListBtn.setPrefSize(300, 40);
		bookListBtn.setOnAction(e->{
			BorrowedBookListView borrowedBookListView = new BorrowedBookListView(scene,primaryStage,root,login,loginId);
			
			scene.setRoot(borrowedBookListView.getBookList(loginId));
			primaryStage.setScene(scene);
			primaryStage.setTitle("도서 대여 목록");
		});
		
		dropBtn = new Button("회원 탈퇴");
		dropBtn.setPrefSize(300, 40);
		dropBtn.setOnAction(e->{
			UnregisterController unregisterController = new UnregisterController();
			
			if(unregisterController.getResult2(loginId) == null) {
		    ObservableList<MembershipVO> list = unregisterController.getResult(loginId);
		    
			Dialog<String> dialog = new Dialog<String>();
			dialog.setTitle("회원탈퇴");
			ButtonType type = new ButtonType("탈퇴하기", ButtonData.OK_DONE);
			String str = "회원정보가 모두 삭제되었습니다.";
			dialog.setContentText(str);
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.getDialogPane().setMinHeight(300);
			dialog.showAndWait();
        	scene.setRoot(login);
			primaryStage.setScene(scene);
			} else {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("회원탈퇴");
				ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
				String str = "미납도서가 있어 탈퇴가 불가능합니다." + "\n" + "도서를 먼저 반납해주세요.";
				dialog.setContentText(str);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinHeight(300);
				dialog.showAndWait();
	        	scene.setRoot(login);
				primaryStage.setScene(scene);
			}
		});
		
		flowpane.getChildren().add(myInfoBtn);
		flowpane.getChildren().add(bookListBtn);
		flowpane.getChildren().add(pointBtn);
		flowpane.getChildren().add(dropBtn);
		
		root.setCenter(flowpane);
		
		
		return root;
	}

	
	
}
