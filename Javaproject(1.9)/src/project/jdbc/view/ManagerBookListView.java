package project.jdbc.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.jdbc.controller.AddBookController;
import project.jdbc.controller.BookDeleteByISBNController;
import project.jdbc.controller.BookDetailByISBNController;
import project.jdbc.controller.BookEditController;
import project.jdbc.controller.BookSearchByKeywordController;
import project.jdbc.vo.BookVO;

public class ManagerBookListView {
	Scene scene = null;
	Stage primaryStage = null;
    BorderPane manager = null;
    BorderPane login = null;
  
    Button searchBtn;
    Button addBtn;
    Button deleteBtn;
    Button editBtn;
    Button logOutBtn;
    Button addBookBtn;
    Button cancelBtn;
    Button cancelEditBtn;
    Button editBookBtn;
    
    String deleteISBN;
    String searchKeyword;
    String rowData;
    String updateISBN;

    TableView<BookVO> tableView;
    TextField textField;
    
	public ManagerBookListView(Scene scene, Stage primaryStage, BorderPane root, BorderPane login) {
		super();
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.manager = root;
		this.login=login;
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
			List<BookVO> list = controller.getResult(textField.getText());
			ObservableList<BookVO> bookList = FXCollections.observableArrayList();
			if(list !=null) {
				for(BookVO book : list) {
					bookList.add(book);
				}
			}
			
			tableView.setItems(bookList);
			textField.clear();
		});
		
		addBtn = new Button("도서추가");
		addBtn.setPrefSize(130, 50);
        addBtn.setOnAction(e-> {
        	
        	Stage addBookStage = new Stage(StageStyle.UTILITY);
        	addBookStage.initModality(Modality.WINDOW_MODAL);
        	addBookStage.initOwner(primaryStage);
		
        	addBookStage.setTitle("도서추가");
			
			BorderPane root1 = new BorderPane();
			Scene scene1 = new Scene(root1);
			root1.setPrefSize(700, 900);
			
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(10));
			gridPane.setVgap(15);
			gridPane.setHgap(10);
			
			Label isbn = new Label("ISBN");
			isbn.setPrefSize(100, 40);
			isbn.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(isbn, 0, 0);
			TextField isbnField = new TextField();
			isbnField.setPrefSize(250, 40);
			GridPane.setConstraints(isbnField, 1, 0);
			
			Label title = new Label("도서명");
			title.setPrefSize(100, 40);
			title.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(title, 0, 1);
			TextField titleField = new TextField();
			titleField.setPrefSize(250, 40);
			GridPane.setConstraints(titleField, 1, 1);
			
			Label author = new Label("작가");
			author.setPrefSize(100, 40);
			author.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(author, 0, 2);
			TextField authorField = new TextField();
			authorField.setPrefSize(250, 40);
			GridPane.setConstraints(authorField, 1, 2);
			
			Label publisher = new Label("출판사");
			publisher.setPrefSize(100, 40);
			publisher.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(publisher, 0, 3);
			TextField publisherField = new TextField();
			publisherField.setPrefSize(250, 40);
			GridPane.setConstraints(publisherField, 1, 3);
			
			Label date = new Label("출판일");
			date.setPrefSize(100, 40);
			date.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(date, 0, 4);
			TextField dateField = new TextField();
			dateField.setPrefSize(250, 40);
			GridPane.setConstraints(dateField, 1, 4);
			
			Label page = new Label("페이지수");
			page.setPrefSize(100, 40);
			page.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(page, 0, 5);
			TextField pageField = new TextField();
			pageField.setPrefSize(250, 40);
			GridPane.setConstraints(pageField, 1, 5);
			
			Label translator = new Label("번역가");
			translator.setPrefSize(100, 40);
			translator.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(translator, 0, 6);
			TextField translatorField = new TextField();
			translatorField.setPrefSize(250, 40);
			GridPane.setConstraints(translatorField, 1, 6);
			
			FlowPane flowPane = new FlowPane();
			flowPane.setPrefSize(700, 50);
			flowPane.setPadding(new Insets(10));
			flowPane.setColumnHalignment(HPos.CENTER);
			flowPane.setAlignment(Pos.CENTER);
			flowPane.setHgap(20);
			
			cancelBtn = new Button("취소");
			cancelBtn.setPrefSize(130, 50);
			cancelBtn.setOnAction(e2->{
				addBookStage.close();
			});
			addBookBtn = new Button("추가하기");
			addBookBtn.setPrefSize(130, 50);
			addBookBtn.setOnAction(e1->{
				AddBookController controller = new AddBookController();
				controller.getResult
				(isbnField.getText(),titleField.getText(),authorField.getText(),publisherField.getText(),dateField.getText(),Integer.parseInt(pageField.getText()),translatorField.getText());
		        
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("도서 추가 성공");
				ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
				String str = "도서 추가가 완료되었습니다!";
				dialog.setContentText(str);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinHeight(300);
				dialog.showAndWait();
			});
			
			gridPane.getChildren().addAll(isbn,isbnField,title,titleField,author,authorField,publisher,publisherField,date,dateField,page,pageField,translator,translatorField);
			gridPane.setAlignment(Pos.CENTER);
			flowPane.getChildren().add(cancelBtn);
			flowPane.getChildren().add(addBookBtn);
			
			root1.setCenter(gridPane);
			root1.setBottom(flowPane);
			
			addBookStage.setScene(scene1);
			addBookStage.show();
        });
        
        deleteBtn = new Button("도서삭제");
		deleteBtn.setPrefSize(130, 50);
		deleteBtn.setDisable(true);
        deleteBtn.setOnAction(e-> {
        	BookDeleteByISBNController controller = new BookDeleteByISBNController();
        	List<BookVO> list = controller.getResult(deleteISBN, searchKeyword);
        	ObservableList<BookVO> bookList = FXCollections.observableArrayList();
			if(list !=null) {
				for(BookVO book : list) {
					bookList.add(book);
				}
			}
        	tableView.setItems(bookList);
        });
        
        editBtn = new Button("도서수정");
		editBtn.setPrefSize(130, 50);
		editBtn.setDisable(true);
        editBtn.setOnAction(e-> {
        	Stage editBookStage = new Stage(StageStyle.UTILITY);
        	editBookStage.initModality(Modality.WINDOW_MODAL);
        	editBookStage.initOwner(primaryStage);
		
        	editBookStage.setTitle("도서 정보 수정");
			
			BorderPane root1 = new BorderPane();
			Scene scene1 = new Scene(root1);
			root1.setPrefSize(700, 900);
			
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(10));
			gridPane.setVgap(15);
			gridPane.setHgap(10);
			
			Label isbn = new Label("ISBN");
			isbn.setPrefSize(100, 40);
			isbn.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(isbn, 0, 0);
			TextField isbnField = new TextField();
			isbnField.setPrefSize(250, 40);
			GridPane.setConstraints(isbnField, 1, 0);
			
			Label title = new Label("도서명");
			title.setPrefSize(100, 40);
			title.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(title, 0, 1);
			TextField titleField = new TextField();
			titleField.setPrefSize(250, 40);
			GridPane.setConstraints(titleField, 1, 1);
			
			Label author = new Label("작가");
			author.setPrefSize(100, 40);
			author.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(author, 0, 2);
			TextField authorField = new TextField();
			authorField.setPrefSize(250, 40);
			GridPane.setConstraints(authorField, 1, 2);
			
			Label publisher = new Label("출판사");
			publisher.setPrefSize(100, 40);
			publisher.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(publisher, 0, 3);
			TextField publisherField = new TextField();
			publisherField.setPrefSize(250, 40);
			GridPane.setConstraints(publisherField, 1, 3);
			
			Label date = new Label("출판일");
			date.setPrefSize(100, 40);
			date.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(date, 0, 4);
			TextField dateField = new TextField();
			dateField.setPrefSize(250, 40);
			GridPane.setConstraints(dateField, 1, 4);
			
			Label page = new Label("페이지수");
			page.setPrefSize(100, 40);
			page.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(page, 0, 5);
			TextField pageField = new TextField();
			pageField.setPrefSize(250, 40);
			GridPane.setConstraints(pageField, 1, 5);
			
			Label translator = new Label("번역가");
			translator.setPrefSize(100, 40);
			translator.setAlignment(Pos.CENTER_RIGHT);
			GridPane.setConstraints(translator, 0, 6);
			TextField translatorField = new TextField();
			translatorField.setPrefSize(250, 40);
			GridPane.setConstraints(translatorField, 1, 6);
			
			BookSearchByKeywordController bcontroller = new BookSearchByKeywordController();
			BookVO book = bcontroller.getResult3(updateISBN);
			isbnField.setText(book.getBisbn());
			titleField.setText(book.getBtitle());
			authorField.setText(book.getBauthor());
			publisherField.setText(book.getBpublisher());
			dateField.setText(book.getBdate());
			pageField.setText(book.getBpage().toString());
			translatorField.setText(book.getBtranslator());
			
			FlowPane flowPane = new FlowPane();
			flowPane.setPrefSize(700, 50);
			flowPane.setPadding(new Insets(10));
			flowPane.setColumnHalignment(HPos.CENTER);
			flowPane.setAlignment(Pos.CENTER);
			flowPane.setHgap(20);
			
			cancelEditBtn = new Button("취소");
			cancelEditBtn.setPrefSize(130, 50);
			cancelEditBtn.setOnAction(e2->{
				editBookStage.close();
			});
			
			editBookBtn = new Button("수정");
			editBookBtn.setPrefSize(130, 50);
			editBookBtn.setOnAction(e1->{
				BookEditController controller = new BookEditController();
				controller.getResult
				(isbnField.getText(),titleField.getText(),authorField.getText(),publisherField.getText(),dateField.getText(),Integer.parseInt(pageField.getText()),translatorField.getText(),updateISBN);
		        
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("도서 정보 수정 완료");
				ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
				String str = "도서 정보 수정이 완료되었습니다!";
				dialog.setContentText(str);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinHeight(300);
				dialog.showAndWait();
			});
			
			gridPane.getChildren().addAll(isbn,isbnField,title,titleField,author,authorField,publisher,publisherField,date,dateField,page,pageField,translator,translatorField);
			gridPane.setAlignment(Pos.CENTER);
			flowPane.getChildren().add(cancelEditBtn);
			flowPane.getChildren().add(editBookBtn);
			
			root1.setCenter(gridPane);
			root1.setBottom(flowPane);
			
			editBookStage.setScene(scene1);
			editBookStage.show();
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
		flowpane.getChildren().add(addBtn);
		flowpane.getChildren().add(deleteBtn);
		flowpane.getChildren().add(editBtn);
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
						editBtn.setDisable(false);
						updateISBN = book.getBisbn();
						
					}
				});	 return row;
			});
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
	
		
		return root;
	}

}
