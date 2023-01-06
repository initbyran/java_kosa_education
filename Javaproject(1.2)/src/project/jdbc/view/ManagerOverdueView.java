package project.jdbc.view;

import java.sql.Date;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.BookSearchByKeywordController;
import project.jdbc.vo.BookVO;

public class ManagerOverdueView {
	Scene scene = null;
	Stage primaryStage = null;
    BorderPane login = null;
    BorderPane manager = null;
    Button logOutBtn;
    TableView<BookVO> tableView;
    
	public ManagerOverdueView(Scene scene, Stage primaryStage,BorderPane root, BorderPane login) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.login = login;
		this.manager = root;
	}

	public BorderPane getOverdueList() {
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(1000, 50);
		flowpane.setHgap(10);
		
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
	        
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(100);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("risbn"));
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("도서제목");
		titleColumn.setMinWidth(180);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("rtitle"));
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("작가");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("rauthor"));
		TableColumn<BookVO, String> publisherColumn = new TableColumn<>("출판사");
		publisherColumn.setMinWidth(100);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("rpublisher"));
		TableColumn<BookVO, String> ridColumn = new TableColumn<>("대여자");
		ridColumn.setMinWidth(100);
		ridColumn.setCellValueFactory(new PropertyValueFactory<>("rid"));
		TableColumn<BookVO, Date> rdateColumn = new TableColumn<>("대여일");
		rdateColumn.setMinWidth(120);
		rdateColumn.setCellValueFactory(new PropertyValueFactory<>("rdate"));
		TableColumn<BookVO, Date> duedateColumn = new TableColumn<>("대여예정일");
		duedateColumn.setMinWidth(120);
		duedateColumn.setCellValueFactory(new PropertyValueFactory<>("rduedate"));
		TableColumn<BookVO, String> overdueColumn = new TableColumn<>("");
		overdueColumn.setMinWidth(120);
		overdueColumn.setCellValueFactory(new PropertyValueFactory<>("roverdue"));
			
		tableView = new TableView<BookVO>();
		
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,publisherColumn,ridColumn,rdateColumn,duedateColumn,overdueColumn);
		
		BookSearchByKeywordController controller = new BookSearchByKeywordController();
		ObservableList<BookVO> list = controller.getResult5();
		tableView.setItems(list);
		
		flowpane.getChildren().add(logOutBtn);
		root.setCenter(tableView);
		root.setBottom(flowpane);
		return root;
	}

}
