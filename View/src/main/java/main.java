import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class main extends Application {

	public static void main(String[] args) {
		launch(args);
		
		
        
        //DashboardController dc = new DashboardController();
        //dc.setBoard(board);
	}
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//DashboardController dc = new DashboardController();
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Dashboard.fxml"));
		
		Pane pane = loader.load();
		
		Scene scene = new Scene(pane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dashboard");
		primaryStage.show();
	}

}
