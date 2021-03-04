/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package year2coursework;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class FXMLLoginController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button admin_button;
    @FXML
    private Button viewer_button;
    
    private FXMLAdminController admin;
    private FXMLViewerController viewer;
    private FXMLScoreSheetController score;
    private Stage adminStage;
    private Stage viewerStage;
    private Stage scoreStage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void gotoSceneViewer(ActionEvent event)throws Exception{        
        Stage current = (Stage)admin_button.getScene().getWindow();
        current.close();
        viewer.setLoginStage(current);
        viewerStage.show();
    }
    @FXML
    private void gotoSceneAdmin(ActionEvent event)throws Exception{
        Stage current = (Stage)admin_button.getScene().getWindow();
        current.close();
        admin.setLoginStage(current);
        admin.setScoreStage(scoreStage);
        admin.setScoreController(score);
        adminStage.show();
    }
    
    public void setAdminStage(FXMLAdminController admin){
        this.admin = admin;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            FXMLLoader adminfxmlloader = new FXMLLoader(getClass().getResource("FXMLAdmin.fxml"));
            Parent adminroot = (Parent)adminfxmlloader.load();
            admin = adminfxmlloader.<FXMLAdminController>getController();
            
            Scene adminScene = new Scene(adminroot);
            adminStage = new Stage();
            adminStage.setScene(adminScene);
            adminStage.setTitle("Admin Window");
            
            FXMLLoader viewerfxmlloader = new FXMLLoader(getClass().getResource("FXMLViewer.fxml"));
            Parent viewerroot = (Parent)viewerfxmlloader.load();
            viewer = viewerfxmlloader.<FXMLViewerController>getController();
            
            Scene viewerScene = new Scene(viewerroot);
            viewerStage = new Stage();
            viewerStage.setScene(viewerScene);
            viewerStage.setTitle("Viewer Window");
            
            FXMLLoader scorefxmlloader = new FXMLLoader(getClass().getResource("FXMLScoreSheet.fxml"));
            Parent scoreroot = (Parent)scorefxmlloader.load();
            score = scorefxmlloader.<FXMLScoreSheetController>getController();
            
            Scene scoreScene = new Scene(scoreroot);
            scoreStage = new Stage();
            scoreStage.setScene(scoreScene);
            scoreStage.setTitle("Score Sheet Window");
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
}
