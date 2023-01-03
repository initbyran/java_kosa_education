package project.jdbc.view;

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
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import project.jdbc.controller.BookDeleteByISBNController;
import project.jdbc.controller.BookDetailByISBNController;
import project.jdbc.controller.BookSearchByKeywordController;
import project.jdbc.vo.BookVO;

public class ManagerBookListView {
	Scene scene = null;
	Stage primaryStage = null;
    BorderPane root = null;
    Button searchBtn;
    Button addBtn;
    Button deleteBtn;
    Button changeBtn;
    Button logOutBtn;
    
    String deleteISBN;
    String searchKeyword;
    String rowData;

    TableView<BookVO> tableView;
    TextField textField;
    
	public ManagerBookListView(Scene scene, Stage primaryStage, BorderPane root) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.root = root;
	}

	public BorderPane getBookList() {

		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 700);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(1000, 50);
		flowpane.setHgap(10);
		
		textField = new TextField();
		textField.setPrefSize(250, 50);
		
		searchBtn = new Button("도서검색");
		searchBtn.setPrefSize(150, 50);
		searchBtn.setOnAction(e->{
			BookSearchByKeywordController controller = new BookSearchByKeywordController();
			searchKeyword = textField.getText();
			ObservableList<BookVO> list = controller.getResult(textField.getText());
			tableView.setItems(list);
			textField.clear();
		});
		
		addBtn = new Button("도서추가");
		addBtn.setPrefSize(130, 50);
//        addBtn.setOnAction(e-> {
//        	
//        });
        
        deleteBtn = new Button("도서삭제");
		deleteBtn.setPrefSize(130, 50);
		deleteBtn.setDisable(true);
        deleteBtn.setOnAction(e-> {
        	BookDeleteByISBNController controller = new BookDeleteByISBNController();
        	ObservableList<BookVO> list = controller.getResult(deleteISBN, searchKeyword);
			
			tableView.setItems(list);
        });
        
        changeBtn = new Button("도서수정");
		changeBtn.setPrefSize(130, 50);
//        changeBtn.setOnAction(e-> {
//        	
//        });
        
        logOutBtn = new Button("로그아웃");
		logOutBtn.setPrefSize(130, 50);
//        logOutBtn.setOnAction(e-> {
//        	
//        });
        
		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(searchBtn);
		flowpane.getChildren().add(addBtn);
		flowpane.getChildren().add(deleteBtn);
		flowpane.getChildren().add(changeBtn);
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
						deleteBtn.setDisable(false);
						BookVO book = row.getItem();
						deleteISBN = book.getBisbn();
					}
				});	 return row;
			});
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
	
		
		return root;
	}

}
