package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {
	
	TextArea textarea;
	Button connBtn;
	TextField textField;
	TextField idField;
	
	
	Socket s;
	
	PrintWriter pr; //입력
	BufferedReader br; //출력
	
	private void printMsg(String msg) {
		Platform.runLater(()->{ textarea.appendText(msg + "\n");
        });
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			// 창 화면 구성
			BorderPane root = new BorderPane();
			root.setPrefSize(700,500); // Layout 가로세로 크기
			
			// 입력 창 
			textarea = new TextArea();
			root.setCenter(textarea); // BorderPane에서 위치 잡기
			
			connBtn = new Button("서버접속");
			connBtn.setPrefSize(150, 40);
			connBtn.setOnAction(e->{
				try {
					s = new Socket("127.0.0.1", 5000);
					printMsg("서버에 연결 성공했습니다!");
					
					textField.setDisable(false);
					
					pr = new PrintWriter(s.getOutputStream());
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			idField = new TextField();
			idField.setPrefSize(200, 40);
			
			textField = new TextField();
			textField.setPrefSize(200, 40);
			textField.setDisable(true);
			textField.setOnAction(e->{
			    String msg = textField.getText();
			    String id = idField.getText();
			    
			    if(!msg.equals("/exit")) {
			    	 try { // 기다림.
							printMsg(br.readLine());
						} catch (IOException e1) {				
							e1.printStackTrace();
						}
			    } else { 
			    	printMsg("클라이언트가 서버와 연결이 종료되었어요!");
			    }
			    pr.println(id + "> " + msg);
			    pr.flush();
	    
				textField.clear();
			});
			
			
			// button을 넣을 pane 생성
			FlowPane flowpane = new FlowPane();
			flowpane.setPadding(new Insets(10,10,10,10)); //안쪽여백
			flowpane.setColumnHalignment(HPos.CENTER); // 가로 정렬
			flowpane.setHgap(10); //버튼 사이 간격
		
			// 버튼 넣기
			flowpane.getChildren().add(connBtn);
		    flowpane.getChildren().add(idField);
		    flowpane.getChildren().add(textField);
		    
		    
		    // 밑에 flowpane넣기
			root.setBottom(flowpane);
			
			// scene 생성
			 Scene scene = new Scene(root);
		     
	     	 primaryStage.setScene(scene);
	         primaryStage.setTitle("Echo Client Program");
	         primaryStage.show();
		
		} 
	
		
	 public static void main(String[] args) {
		    launch(); // GUI Thread가 생성되서 우리 창이 실행돼요!
	      }	

}
