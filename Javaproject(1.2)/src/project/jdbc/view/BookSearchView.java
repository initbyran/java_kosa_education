package project.jdbc.view;

import java.util.Date;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.BookDetailByISBNController;
import project.jdbc.controller.BookSearchByKeywordController;
import project.jdbc.controller.BorrowBookController;
import project.jdbc.vo.BookVO;

public class BookSearchView {

    TableView<BookVO> tableView;
    TextField textField;
    Button searchBtn;
    Button borrowBtn;
   
    Button mypageBtn;
    Button logOutBtn;
    
    String loginId;
    String searchKeyword;
    String rowData;
    Scene scene = null;
    Stage primaryStage = null;
    BorderPane login = null;

	public BookSearchView(Stage primaryStage,BorderPane root,Scene scene,String loginId) {
		super();
		
		this.primaryStage = primaryStage;
		this.login = root;
		this.scene = scene;
		this.loginId = loginId;
	}

	public BorderPane getBookSearch() {

		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(1000, 50);
		flowpane.setHgap(10);
		
		textField = new TextField();
		textField.setPrefSize(250, 50);
		
		searchBtn = new Button("도서 검색");
		searchBtn.setPrefSize(150, 50);
		searchBtn.setOnAction(e->{
			BookSearchByKeywordController controller = new BookSearchByKeywordController();
			searchKeyword = textField.getText();
			ObservableList<BookVO> list = controller.getResult(textField.getText());
			tableView.setItems(list);
			textField.clear();
		});
		
		borrowBtn = new Button("대여");
		borrowBtn.setPrefSize(130, 50);
		borrowBtn.setDisable(true);
		
        
    
        mypageBtn = new Button("마이페이지");
		mypageBtn.setPrefSize(130, 50);
        mypageBtn.setOnAction(e-> {
        	MyPageView myPageView = new MyPageView(scene, primaryStage, login, loginId);
        	scene = new Scene(myPageView.getMyPage());
        	primaryStage.setScene(scene);
        	primaryStage.setTitle("마이페이지");
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
		flowpane.getChildren().add(borrowBtn);
		
		flowpane.getChildren().add(mypageBtn);
		flowpane.getChildren().add(logOutBtn);
		
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(180);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("도서제목");
		titleColumn.setMinWidth(180);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("작가");
		authorColumn.setMinWidth(180);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		TableColumn<BookVO, String> publisherColumn = new TableColumn<>("출판사");
		publisherColumn.setMinWidth(180);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("bpublisher"));
		TableColumn<BookVO, String> statusColumn = new TableColumn<>("대여여부");
		statusColumn.setMinWidth(180);
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("bborrowable"));
			
		tableView = new TableView<BookVO>();
		
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,publisherColumn,statusColumn);
		
		tableView.setRowFactory(e->{
			TableRow<BookVO> row = new TableRow<>();
			row.setOnMouseClicked(event->{
		
					if(event.getClickCount()==2 && (!row.isEmpty())) {
						BookDetailByISBNController controller = new BookDetailByISBNController();
						BookVO book = controller.getResult(row.getItem().getBisbn());
						
						Dialog<String> dialog = new Dialog<String>();
						dialog.setTitle("도서 세부정보");
						ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
						StringBuffer sb = new StringBuffer();
					
						sb.append(book.getBdate()+"\n");
						sb.append(book.getBpage()+"\n");
						sb.append(book.getBtranslator());
						
						dialog.setContentText(sb.toString());
						dialog.getDialogPane().getButtonTypes().add(type);
						dialog.getDialogPane().setMinHeight(300);
						dialog.showAndWait();
						
					} else {
						borrowBtn.setDisable(false);
						borrowBtn.setOnAction(e1-> {
							String str1 = "대여중";
							if(row.getItem().getBborrowable().equals(str1)) {
								borrowBtn.setDisable(true);
								Alert borrowFail = new Alert(AlertType.ERROR);
								borrowFail.setHeaderText("대여 불가능");
								borrowFail.setContentText("이미 대여 중인 도서입니다.");
								borrowFail.showAndWait();
							}else {
				        	BorrowBookController controller = new BorrowBookController();
				        	Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
				            LocalDate now = LocalDate.now();
				        	Date duedate = java.sql.Date.valueOf(now.plusDays(14));
				        	
				        	controller.getResult(row.getItem().getBisbn(),row.getItem().getBtitle(),row.getItem().getBauthor(),row.getItem().getBpublisher(),loginId, date,duedate);
				        	
				        	ObservableList<BookVO> list = controller.getResult2(row.getItem().getBisbn(),searchKeyword);
				        	tableView.setItems(list);
				        	
				        	Dialog<String> dialog = new Dialog<String>();
							dialog.setTitle("도서 대여 완료");
							ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
							String str = "대여가 완료되었습니다."+"\n"+"대여기간은 대여일로부터 14일입니다."+"(700포인트가 적립되었습니다.)";
							dialog.setContentText(str);
							dialog.getDialogPane().getButtonTypes().add(type);
							dialog.getDialogPane().setMinHeight(300);
							dialog.showAndWait();
							}
				        });
					}
				});	 return row;
			});
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
	
		
		return root;
  
		}
	
}
