/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package year2coursework;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLViewerController implements Initializable {
    private Stage loginStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setLoginStage(Stage loginStage){
        this.loginStage = loginStage;
    }
    
}
