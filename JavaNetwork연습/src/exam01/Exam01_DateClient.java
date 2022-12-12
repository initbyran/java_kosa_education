package exam01;

import javafx.event.EventHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DateClient extends Application  {
   
   //field
   TextArea textarea; 
   Button connBtn;
   
   public void start(Stage primaryStage) throws Exception {
      //화면 구성을 해봅시다
      //일단 에이아웃부터 하나 만들어 보아요
      BorderPane root = new BorderPane();
      root.setPrefSize(700, 500);  
      //component 생성
      textarea = new TextArea();
      root.setCenter(textarea);
      
      connBtn = new Button("Date 서버 접속"); // 버튼을 만들어서 지정
      connBtn.setPrefSize(150,40);
      connBtn.setOnAction(new EventHandler <ActionEvent>() {
           // 버튼을 눌렀을 때 벌어지는 일.
    	  public void handle(ActionEvent arg0) {
            
            	textarea.clear();
            
            	try {
            	Socket s
            	= new Socket("127.0.0.1",3000); // 127.0.0.1
            	System.out.println("서버에 접속 성공");
            	// BufferedReader
            	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            	String msg = br.readLine();
            	System.out.println(msg);
            	
            	br.close();
            	s.close();
            	
            	System.out.println("서버와 연결 종료!");
            	
			} catch(UnknownHostException e) {
				
			}
            catch (IOException e) {
				
			}
            
             }}); 

      FlowPane flowpane = new FlowPane(); //아래쪽 영역에 layout
      //여백을 좀 잡아서 그나마 좀 보기 좋게 만들어보아요.
      flowpane.setPadding(new Insets(10, 10, 10, 10));  
      // unit : pixel
      //위아래 여백잡는거 이따가 붙인 버튼의 공간이 만들어짐 10픽셀만큼
      flowpane.setColumnHalignment(HPos.CENTER);// 가운데 정렬.
      flowpane.setPrefSize(700, 40);  //버튼이 버튼 레이아웃에 고정되는 여백
      flowpane.setHgap(10);
      //버튼을 flow pane에 붙여요
      flowpane.getChildren().add(connBtn);
      //borderpane 밑에 연결
       root.setBottom(flowpane);
       
       Scene scene = new Scene(root); //장면을 만들고
       
       primaryStage.setScene(scene);
       
       primaryStage.show(); //장면 만들고 윈도우에 붙이고 다시 띄우고 
       //서버에 접속하는 거 까지 
       
     
   }
   public static void main(String[] arg0) {
      launch(); // 실행 신호
      
      
   }

}

