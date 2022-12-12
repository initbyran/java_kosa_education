package javafxexam;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성하는 작업을 여기서 해요.
		// stage는 창.
		Button btn = new Button(); // instance
        btn.setText("안녕!!");
        // button event 처리 해야함
        // Java는 delegation model을 이용 -> WEB JavaScript도 이 방식을 사용.
        // button에 Action 이라는 event를 처리할 수 있는 listener 객체를 붙임.
        btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// event가 발생하면 자동으로 호출.
				System.out.println("안녕하세요!");
				
			}
		});
        // Layout 설정 - 컴포넌트가 붙는 방식을 결정하는 객체 ; layout manager
        StackPane root = new StackPane();
        // StackPane ; layout 중 추가되는 순서대로 덧붙여서 시각화하는 layout.
        // 정렬하는 기준.
        
        root.getChildren().add(btn);
      
        // scene 객체를 생성. 
        Scene scene = new Scene(root,300,150);
        
        primaryStage.setTitle("연습입니다.");
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        }

    public static void main(String[] args) {
		// entry point
    	launch(); // static - Application method 
    	// GUI thread가 실행되고 화면에 창이 떠요.
    	// main thread는 종료.
    	
	}
}

