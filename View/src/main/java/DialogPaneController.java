import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class DialogPaneController {

    @FXML
    private ColorPicker colorPicker;
    
    @FXML
    String CPicker(ActionEvent event) {  	
    	
    	//Color c = this.colorPicker.getValue();
    	//return c;
    	int color=colorPicker.getValue().hashCode();
    	String c2=Integer.toHexString(color);
    	return c2;
    	//d.backgroundcolor.setStyle(v"-fx-background-color: #"+c2);
    	//DashboardController colorbg = new DashboardController();
    	//colorbg.backgroundcolor.setStyle("-fx-background-color: #"+c2);
    }

}
