package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Flow;

import org.xml.sax.InputSource;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoServer extends Application {

	// field로 잡아야 class내에서 자유롭게 사용 가능
	//(지역변수로 잡으면 start method가 끝나면 날아가버림)
	TextArea textarea;
	Button startBtn;
	Button stopBtn;
	
	Socket s;
	ServerSocket server;
	
	PrintWriter pr; //입력
	BufferedReader br; //출력
	
	
//	Platform.runLater(new Runnable() {
//	    @Override
//       public void run() {}}
// java fx가 제공하는 static method -> thread 생성
// runnable interface -> run overriding
// 괄호 안에 run method 넣는다
	
	// 인자로 들어온 msg를 출력해준다
	private void printMsg(String msg) {
		Platform.runLater(()->{ textarea.appendText(msg + "\n");
        });
	}
	
	@Override // 화면에 띄울 창 ; primaryStage
	public void start(Stage primaryStage) throws Exception {
		// 창 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700,500); // Layout 가로세로 크기
		
		textarea = new TextArea();
		root.setCenter(textarea); // BorderPane에서 위치 잡기
		
		startBtn = new Button("서버시작");
		startBtn.setPrefSize(150, 40);
		stopBtn = new Button("서버중지");
		stopBtn.setPrefSize(150, 40);
		
		// button을 눌렀을 때 발생하는 일 ; event 처리
		// Listener instance(Handler instance - interface type - overriding)가 담당 
		// ; delegation model
		startBtn.setOnAction(e -> {
			// handler : blocking method
	        // 실행되는 동안 (return될때까지) 모든 다른 수행이 중단됨.
			// 순차처리 대신 Thread를 돌려야한다.
			// Thread 파생 (new Thread 대신)
			
			printMsg("서버가 시작되었어요!");
			
            try {
              	server = new ServerSocket(5000);
                printMsg("클라이언트 접속 대기 중!");
                // server.accept();  -> hold 걸림 -> thread로 빼보기
                (new Thread( () -> { 
                	try {
						s = server.accept();
						printMsg("클라이언트 접속 성공!");
						
						pr = new PrintWriter(s.getOutputStream());
						br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					
						while(true){
						String msg = br.readLine();
						printMsg("클라이언트의 메세지 : " + msg);
						
						if(msg.equals("/exit")) {
							break; // 가장 인접한 반복문 벗어남.
						}
						pr.println(msg);
						pr.flush();
						
					} printMsg("클라이언트 종료! & 서버 process 종료!");
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}
                	})).start();
            } catch(IOException e1) {
            	e1.printStackTrace();
            }
                
		}); // arrow function ; 축약형
 	        
		stopBtn.setOnAction(null);
		
		// button을 넣을 pane 생성
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10)); //안쪽여백
		flowpane.setColumnHalignment(HPos.CENTER); // 가로 정렬
		flowpane.setHgap(10); //버튼 사이 간격
	
		// 버튼 넣기
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
	    // 밑에 flowpane넣기
		root.setBottom(flowpane);
		
		// scene 생성
		Scene scene = new Scene(root);
	     
     	 primaryStage.setScene(scene);
         primaryStage.setTitle("Echo Server Program");
         primaryStage.show();
	
	} 
	 

	public static void main(String[] args) {
	    launch(); // GUI Thread가 생성되서 우리 창이 실행돼요!
      }	
}
