package project.jdbc.view;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.MemberSearchByKeywordController;
import project.jdbc.vo.MembershipVO;

public class ManagerMembershipView {
	Scene scene = null;
	Stage primaryStage = null;
    BorderPane manager = null;
    BorderPane login = null;
    Button logOutBtn;
    Button searchBtn;
    TableView<MembershipVO> tableView;
    TextField textField;
    String searchKeyword;
    
	public ManagerMembershipView(Scene scene, Stage primaryStage, BorderPane root, BorderPane login) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.manager = root;
		this.login=login;
	}
	
	public BorderPane getMemberList() {
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(1000, 50);
		flowpane.setHgap(10);
		
		TableColumn<MembershipVO, String> idColumn = new TableColumn<>("아이디");
		idColumn.setMinWidth(150);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("mid"));
		TableColumn<MembershipVO, String> nameColumn = new TableColumn<>("이름");
		nameColumn.setMinWidth(150);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("mname"));
		TableColumn<MembershipVO, String> birthColumn = new TableColumn<>("생년월일");
		birthColumn.setMinWidth(150);
		birthColumn.setCellValueFactory(new PropertyValueFactory<>("mbirth"));
		TableColumn<MembershipVO, String> phonenumberColumn = new TableColumn<>("휴대전화");
		phonenumberColumn.setMinWidth(150);
		phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("mphonenumber"));
		TableColumn<MembershipVO, String> emailColumn = new TableColumn<>("이메일");
		emailColumn.setMinWidth(150);
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("memail"));
		TableColumn<MembershipVO, String> regdateColumn = new TableColumn<>("가입날짜");
		regdateColumn.setMinWidth(150);
		regdateColumn.setCellValueFactory(new PropertyValueFactory<>("mregdate"));	
		
		tableView = new TableView<MembershipVO>();
		
		tableView.getColumns().addAll(idColumn,nameColumn,birthColumn,phonenumberColumn,emailColumn,regdateColumn);
		
		textField = new TextField();
		textField.setPrefSize(250, 50);

		searchBtn = new Button("회원검색");
		searchBtn.setPrefSize(150, 50);
		searchBtn.setOnAction(e->{
			MemberSearchByKeywordController controller = new MemberSearchByKeywordController();
			searchKeyword = textField.getText();
			ObservableList<MembershipVO> list = controller.getResult(textField.getText());
			tableView.setItems(list);
			textField.clear();
		});
		
		 logOutBtn = new Button("로그아웃");
			logOutBtn.setPrefSize(130, 50);
	        logOutBtn.setOnAction(e-> {
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
	        
	        flowpane.getChildren().add(textField);
	        flowpane.getChildren().add(searchBtn);
	        flowpane.getChildren().add(logOutBtn);
	        root.setCenter(tableView);
	        root.setBottom(flowpane);
	        
		
		return root;
	}

}
