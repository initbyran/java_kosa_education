package project.jdbc.view;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.BookSearchByKeywordController;
import project.jdbc.vo.BookVO;

public class BookSearchView {

    TableView<BookVO> tableView;
    TextField textField;
    Button searchBtn;
    Button rentBtn;
    Button returnBtn;
    Button mypageBtn;
    Button logOutBtn;
    
    String searchKeyword;
    String rowData;
    Stage primaryStage = null;
    BorderPane root = null;

	public BookSearchView(Stage primaryStage, BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.root = root;
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
		
		rentBtn = new Button("대여");
		rentBtn.setPrefSize(130, 50);
        rentBtn.setDisable(true);
        rentBtn.setOnAction(e-> {
        	
        });
        
        returnBtn = new Button("반납");
		returnBtn.setPrefSize(130, 50);
        returnBtn.setOnAction(e-> {
        	
        });
        
        mypageBtn = new Button("마이페이지");
		mypageBtn.setPrefSize(130, 50);
        mypageBtn.setOnAction(e-> {
        	
        });
        
        logOutBtn = new Button("로그아웃");
		logOutBtn.setPrefSize(130, 50);
        logOutBtn.setOnAction(e-> {
        	
        });
        
		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(searchBtn);
		flowpane.getChildren().add(rentBtn);
		flowpane.getChildren().add(returnBtn);
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
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("rduedate"));
			
		tableView = new TableView<BookVO>();
		
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,publisherColumn,statusColumn);
//		
//		tableView.setRowFactory(e->{
//			TableRow<BookVO> row = new TableRow<>();
//			row.setOnMouseClicked(event->{
//		
//					if(event.getClickCount()==2 && (!row.isEmpty())) {
//						BookDetailByISBNController controller = new BookDetailByISBNController();
//						BookVO book = controller.getResult(row.getItem().getBisbn());
//						Dialog<String> dialog = new Dialog<String>();
//						StringBuffer sb = new StringBuffer();
//						sb.append(book.getBisbn()+"\n");
//						sb.append(book.getBtitle()+"\n");
//						sb.append(book.getBauthor()+"\n");
//						sb.append(book.getBpublisher()+"\n");
//						sb.append(book.getBdate()+"\n");
//						sb.append(book.getBpage()+"\n");
//						sb.append(book.getBtranslator()+"\n");
//						
//						dialog.setContentText(sb.toString());
//						dialog.getDialogPane().getButtonTypes().add(type);
//						dialog.getDialogPane().setMinHeight(300);
//						dialog.showAndWait();
//						
//					} else {
//						rentBtn.setDisable(false);
//						BookVO book = row.getItem();
//						rentISBN = book.getBisbn();
//					}
//				});	 return row;
//			});
		
		//Scene scene = new Scene(root);
		root.setCenter(tableView);
		root.setBottom(flowpane);
	
		
		return root;
  
		}
	
}
