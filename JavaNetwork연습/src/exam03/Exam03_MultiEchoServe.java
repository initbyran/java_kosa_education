package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class MyRunnable implements Runnable{
   
	Socket socket;
    PrintWriter pr;
    BufferedReader br;
    
    public MyRunnable() {
    	
    }
    
    public MyRunnable(Socket socket) {
    	super();
    	this.socket = socket;
    	try {
    		this.pr = new PrintWriter(socket.getOutputStream());
    		this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @Override
    public void run() {
    	try {
    		while(true) {
    			String msg = br.readLine();
    			
    			pr.println(msg);
    			pr.flush();   			
		}} catch (IOException e) {
			e.printStackTrace();
    }
}}

public class Exam03_MultiEchoServe extends Application {

	TextArea textArea;
    Button startBtn;
    Button stopBtn;
    
    ServerSocket server;
    
    private void printMsg(String msg) {
    	Platform.runLater(()->{
    		textArea.appendText(msg+"\n");
    	});
    }
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textArea = new TextArea();
		root.setCenter(textArea);
		
		startBtn = new Button("서버기동!");
	    startBtn.setPrefSize(150, 40);
	    startBtn.setOnAction(e-> {
	    	(new Thread(()-> {
	    		try { server = new ServerSocket(7777);
	    		
	    		while(true) {
	    			Socket socket = server.accept();
	    			printMsg("새로운 클라이언트 접속!!");
	    			
	    			MyRunnable r = new MyRunnable(socket);
	    			Thread t = new Thread(r);
	    			t.start();
	    			
	    		}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		
	    	})).start();
	    });
		
		stopBtn = new Button("서버중지!!");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(e->{
			
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
        
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show();
	}

public static void main(String[] args) {
	launch();
	
}}



