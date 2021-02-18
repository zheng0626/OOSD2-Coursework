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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

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
    private Button print_team_button;
    @FXML
    private TextField tf_team_name;
    @FXML
    private TextField tf_player_name;
    @FXML
    private Label team_label;
    @FXML
    private SplitMenuButton team_list_smb;
    
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    
    
    @FXML
    private void addTeam(ActionEvent event) {
        System.out.println("Added TEAM!");
        Team team = new Team(tf_team_name.getText());
        System.out.println("TEAM NAME : "+ tf_team_name.getText());
        teams.add(team);
        MenuItem team_menu = new MenuItem(team.teamName);
        team_list_smb.getItems().add(team_menu);
        team_menu.setOnAction(a->{
            team_list_smb.setText(team_menu.getText());
        });
        tf_team_name.setText("");
    }
    
    @FXML
    private void printTeam(ActionEvent event){
        String word = "";
        for (Team team: teams){
            word = word + team.teamName + "\n";
        }
        team_label.setText(word);
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
                if (team.teamName == team_list_smb.getText()){
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
