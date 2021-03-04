/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package year2coursework;


import Classes.Player;
import Classes.Team;
import Classes.Fixture;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLAdminController implements Initializable {

    @FXML
    private Button add_team_button;
    @FXML
    private Button register_player_button;
    @FXML
    private TextField tf_team_name;
    @FXML
    private TextField tf_player_name;
    @FXML
    private SplitMenuButton team_list_smb;
    @FXML
    private Button login_screen_button;
    
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private Fixture fixture;
    
    
    private Stage loginStage;
    private Stage scoreStage;
    private FXMLScoreSheetController scoreController;
    
    public ArrayList<Team> getTeamList(){
        return teams;
    }
    
    public ArrayList<Player> getPlayerList(){
        return players;
    }
    
    public Fixture getFixtures(){
        if(fixture == null){
            System.out.println("Havent generate any Fixture yet");
        }else{
            return fixture;
        }
        return fixture;
    }
    
    @FXML
    private void gotoLoginScreen(ActionEvent event)throws Exception{
        Stage current = (Stage)add_team_button.getScene().getWindow();
        current.close();
        
        loginStage.show();
  
    }

    @FXML
    private void gotoScoreSheet(ActionEvent event)throws Exception{
        if(fixture == null){
            Alert a = new Alert(AlertType.ERROR);
            a.show();
        }else{
            Stage current = (Stage)add_team_button.getScene().getWindow();
            current.close();
            scoreController.setAdminStage(current);
            scoreController.setAdminController(this);
            scoreStage.show();
        }
    }
    @FXML
    private void addTeam(ActionEvent event) {
        System.out.println("Added TEAM!");
        Team team = new Team(tf_team_name.getText());
        System.out.println("TEAM NAME : "+ tf_team_name.getText());
        teams.add(team);
        MenuItem team_menu = new MenuItem(team.getTeamName());
        team_list_smb.getItems().add(team_menu);
        team_menu.setOnAction(a->{
            team_list_smb.setText(team_menu.getText());
        });
        tf_team_name.setText("");
    }
    

    @FXML
    private void registerPlayer(ActionEvent event){
        System.out.println(tf_player_name.getText());
        Team team_to_join = null;
        if("Team List".equals(team_list_smb.getText())){
            System.out.println("NO TEAM SELECTED");
        }else if("".equals(tf_player_name.getText())){
            System.out.println("NO PLAYER NAME IS ENTER");
        }else{
            
            for(Team team:teams){
                if (team.getTeamName() == team_list_smb.getText()){
                    team_to_join = team;
                    break;
                }
            }
            try{
                Player player = new Player(tf_player_name.getText(),team_to_join);
                team_to_join.addPlayer(player);
            }catch(Exception e){
                System.out.println("MAYBE TEAM IS NULL");
            }
            
        }
        tf_player_name.setText("");
    }
    @FXML
    private void generateFixture(ActionEvent event){
        ArrayList<Team> fix_team = new ArrayList<>();
        for(Team team:teams){
            if(team.getNumPlayer() >= 2){
                fix_team.add(team);
            }
        }
        System.out.println(fix_team.size());
        if(fix_team.size() < 2){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Not enough Team");
            a.show();
        }else{
            fixture = new Fixture(fix_team);
            scoreController.setFixture(fixture);
        }
    }
    
    public void setLoginStage(Stage loginStage){
        this.loginStage = loginStage;
    }
    
    public void setScoreStage(Stage scoreStage){
        this.scoreStage = scoreStage;
    }
    
    public void setScoreController(FXMLScoreSheetController scoreController){
        this.scoreController = scoreController;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Team team = new Team("Zheng Team");
        Player player1 = new Player("Zheng",team);
        Player player2 = new Player("Zong",team);
        team.addPlayer(player1);
        team.addPlayer(player2);
        Team team1 = new Team("Chuan Team");
        Player player3 = new Player("Chuan",team1);
        Player player4 = new Player("ChuChu",team1);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        teams.add(team);
        teams.add(team1);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        
    }    
    
}
