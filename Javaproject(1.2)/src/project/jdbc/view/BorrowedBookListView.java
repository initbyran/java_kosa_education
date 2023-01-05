package project.jdbc.view;

import java.sql.Date;
import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.BookDeleteByISBNController;
import project.jdbc.controller.BookSearchByKeywordController;
import project.jdbc.controller.BorrowedBookListController;
import project.jdbc.vo.BookVO;

public class BorrowedBookListView {
	Scene scene = null;
	Stage primaryStage = null;
    BorderPane mypage = null;
    BorderPane login = null;
    TableView<BookVO> tableView;

    Button logoutBtn;
    Button returnBtn;
    
    String loginId;
    String risbn;
    
	public BorrowedBookListView(Scene scene, Stage primaryStage, BorderPane mypage, BorderPane login, String loginId) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.mypage = mypage;
		this.login = login;
		this.loginId = loginId;
	}

	public BorderPane getBookList(String loginId) {
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(1000, 50);
		flowpane.setHgap(10);
		
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(180);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("risbn"));
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("도서제목");
		titleColumn.setMinWidth(180);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("rtitle"));
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("작가");
		authorColumn.setMinWidth(180);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("rauthor"));
		TableColumn<BookVO, String> publisherColumn = new TableColumn<>("출판사");
		publisherColumn.setMinWidth(180);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("rpublisher"));
		TableColumn<BookVO, Date> duedateColumn = new TableColumn<>("반납예정날짜");
		duedateColumn.setMinWidth(180);
		duedateColumn.setCellValueFactory(new PropertyValueFactory<>("rduedate"));
			
		tableView = new TableView<BookVO>();
		
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,publisherColumn,duedateColumn);
		
		BorrowedBookListController controller = new BorrowedBookListController();
		ObservableList<BookVO> list = controller.getResult(loginId);
		tableView.setItems(list);
		
		logoutBtn = new Button("로그아웃");
		logoutBtn.setPrefSize(150, 50);
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
		
		returnBtn = new Button("반납하기");
		returnBtn.setPrefSize(150, 50);
		returnBtn.setDisable(true);
		returnBtn.setOnAction(e->{
			LocalDate now = LocalDate.now();
			Date date = java.sql.Date.valueOf(now);
			BookSearchByKeywordController tcontroller = new BookSearchByKeywordController();
			BookVO book = tcontroller.getResult4(risbn);
			int compare = book.getRduedate().compareTo(date);
			
			BookDeleteByISBNController controller2 = new BookDeleteByISBNController();
        	ObservableList<BookVO> list2 = controller2.getResult2(loginId);
			tableView.setItems(list2);
			BookSearchByKeywordController controller3 = new BookSearchByKeywordController();
			ObservableList<BookVO> list3 = controller3.getResult2(risbn);
			
			if (compare >= 0) {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("도서 반납 완료");
				ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
				String str = "도서 반납이 완료되었습니다!";
				dialog.setContentText(str);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinHeight(300);
				dialog.showAndWait();
			} else {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("도서 반납 완료");
				ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
				String str = "도서 반납이 완료되었습니다!"+"(도서가 연체되어 포인트가 차감되었습니다.)";
				dialog.setContentText(str);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinHeight(300);
				dialog.showAndWait();
			}
			
			});
		
		tableView.setRowFactory(e->{               
			TableRow<BookVO> row = new TableRow<>();
			row.setOnMouseClicked(event->{
				returnBtn.setDisable(false);
				BookVO book = row.getItem();
				risbn = book.getRisbn();
				
			}); return row;
		});
		
		flowpane.getChildren().add(returnBtn);
		flowpane.getChildren().add(logoutBtn);
		root.setCenter(tableView);
		root.setBottom(flowpane);
		return root;
	}

}
