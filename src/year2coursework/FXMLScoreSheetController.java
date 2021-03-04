/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package year2coursework;

import Classes.Fixture;
import Classes.Match;
import Classes.Player;
import Classes.Set;
import Classes.Team;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLScoreSheetController implements Initializable {

    @FXML
    private Button newSheet_btn;
    @FXML
    private Button modifySheet_btn;
    @FXML
    private Button returnToSelectTeam_btn;
    @FXML
    private ChoiceBox homeTeam_cb;
    @FXML
    private ChoiceBox awayTeam_cb;
    @FXML
    private ComboBox homePlayer1_cb;
    @FXML
    private ComboBox homePlayer2_cb;
    @FXML
    private ComboBox awayPlayer1_cb;
    @FXML
    private ComboBox awayPlayer2_cb;
    @FXML
    private Text homeTeam_text;
    @FXML
    private Text awayTeam_text;
    @FXML
    private Pane select_team_pane;
    @FXML
    private Pane scoreSheet_pane;
    @FXML
    private TextField set1_1_1;
    @FXML
    private TextField set1_1_2;
    @FXML
    private TextField set1_1_3;
    @FXML
    private TextField set1_2_1;
    @FXML
    private TextField set1_2_2;
    @FXML
    private TextField set1_2_3;
    @FXML
    private TextField set2_1_1;
    @FXML
    private TextField set2_1_2;
    @FXML
    private TextField set2_1_3;
    @FXML
    private TextField set2_2_1;
    @FXML
    private TextField set2_2_2;
    @FXML
    private TextField set2_2_3;
    @FXML
    private TextField setDouble1;
    @FXML
    private TextField setDouble2;
    @FXML
    private TextField setDouble3;    
  
    
    
    
    private FXMLAdminController adminController;
    private Stage adminStage;
    private Fixture fixture;
    private ArrayList<Match> match = new ArrayList<>();
    
    
    public void setAdminStage(Stage adminStage){
        this.adminStage = adminStage;
    }
    
    public void setFixture(Fixture fix){
        this.fixture = fix;
        homeTeam_cb.getItems().clear();
        awayTeam_cb.getItems().clear();
        match = new ArrayList<>();
        for (Team team:fixture.getTeams()){
            homeTeam_cb.getItems().add(team.getTeamName());
            awayTeam_cb.getItems().add(team.getTeamName());
            System.out.println("ADDED once");
        }
    }
    
    public void setAdminController(FXMLAdminController adminController){
        this.adminController = adminController;
    }

    private void setUpTeamMenuButton(String homeTeam,String awayTeam){
        homeTeam_text.setText(homeTeam);
        awayTeam_text.setText(awayTeam);
        homePlayer1_cb.getItems().clear();
        homePlayer2_cb.getItems().clear();
        awayPlayer1_cb.getItems().clear();
        awayPlayer2_cb.getItems().clear();
        for(Team team:fixture.getTeams()){
            System.out.println(team.getTeamName());
            if(team.getTeamName() == homeTeam){
                for(Player player : team.getPlayer()){
                    homePlayer1_cb.getItems().add(player.getPlayerName());
                    homePlayer2_cb.getItems().add(player.getPlayerName());
                }
            }
            if(team.getTeamName() == awayTeam){
                for(Player player : team.getPlayer()){
                    awayPlayer1_cb.getItems().add(player.getPlayerName());
                    awayPlayer2_cb.getItems().add(player.getPlayerName());
                }
            }
        }
    }
    
    private void setUpSetToScoreSheet(Match match){
        int numSet = 0;
        ArrayList<Set> sets = match.getScoreSheet().getSet();
        set1_1_1.setText(sets.get(numSet).getGame1());
        set1_1_2.setText(sets.get(numSet).getGame2());
        set1_1_3.setText(sets.get(numSet).getGame3());
        numSet++;
        set1_2_1.setText(sets.get(numSet).getGame1());
        set1_2_2.setText(sets.get(numSet).getGame2());
        set1_2_3.setText(sets.get(numSet).getGame3());
        numSet++;
        set2_1_1.setText(sets.get(numSet).getGame1());
        set2_1_2.setText(sets.get(numSet).getGame2());
        set2_1_3.setText(sets.get(numSet).getGame3());
        numSet++;
        set2_2_1.setText(sets.get(numSet).getGame1());
        set2_2_2.setText(sets.get(numSet).getGame2());
        set2_2_3.setText(sets.get(numSet).getGame3());
        numSet++;
        setDouble1.setText(sets.get(numSet).getGame1());
        setDouble2.setText(sets.get(numSet).getGame2());
        setDouble3.setText(sets.get(numSet).getGame3());
    }
    @FXML
    public void handleCalAndSubButton(){
        String homeTeam = homeTeam_text.getText();
        String awayTeam = awayTeam_text.getText();
        for(Match LoopMatch:match){
           if(LoopMatch.getHomeTeam() == homeTeam && LoopMatch.getAwayTeam() == awayTeam){
                Match currentMatch = LoopMatch;
                break;
            }
        }
    }
    
    private boolean checkText(String set){
        if(!set.contains(":")){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Wrong format");
            a.show();
            return false;
        }
        String[] score = set.split(":");
        if(score.length > 2){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Too much :");
            a.show();
            return false;
        }
        
        try{
            int firstScore = Integer.parseInt(score[0]);
            int secondScore = Integer.parseInt(score[1]);
        }catch(NumberFormatException e){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter number not other character!");
            a.showAndWait();
            return false;
        }
    }
    
    private boolean getAllSetForSubmit(Match curMatch){
        ArrayList<String> set = new ArrayList<>();
        boolean checkSet;
        set.add(set1_1_1.getText());
        set.add(set1_1_2.getText());
        set.add(set1_1_3.getText());
        
        set.add(set1_2_1.getText());
        set.add(set1_2_2.getText());
        set.add(set1_2_3.getText());
        
        set.add(set2_1_1.getText());
        set.add(set2_1_2.getText());
        set.add(set2_1_3.getText());
        
        set.add(set2_2_1.getText());
        set.add(set2_2_2.getText());
        set.add(set2_2_3.getText());
        
        set.add(setDouble1.getText());
        set.add(setDouble2.getText());
        set.add(setDouble3.getText());
        
        for(String LoopSet:set){
            if(checkText(LoopSet) == false){
                return false;
            }
        }
        if(homePlayer1_cb.getSelectionModel().isEmpty() || homePlayer2_cb.getSelectionModel().isEmpty() || awayPlayer1_cb.getSelectionModel().isEmpty() || awayPlayer2_cb.getSelectionModel().isEmpty()){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please select all the players");
            a.show();
            return false;
        }
        String homePlayer1 = homePlayer1_cb.getSelectionModel().getSelectedItem().toString();
        String homePlayer2 = homePlayer2_cb.getSelectionModel().getSelectedItem().toString();
        String awayPlayer1 = awayPlayer1_cb.getSelectionModel().getSelectedItem().toString();
        String awayPlayer2 = awayPlayer2_cb.getSelectionModel().getSelectedItem().toString();
        
        if((homePlayer1 == homePlayer2) || (awayPlayer1 == awayPlayer2)){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Cannot select the same player!");
            a.show();
            return false;
        }
        
        int i = 0;
        ArrayList<Set> curMatchSet = new ArrayList<>();
        curMatchSet.add(new Set(homePlayer1,awayPlayer1,set.get(i),set.get(i++),set.get(i++)));
        curMatchSet.add(new Set(homePlayer1,awayPlayer2,set.get(i++),set.get(i++),set.get(i++)));
        curMatchSet.add(new Set(homePlayer2,awayPlayer1,set.get(i++),set.get(i++),set.get(i++)));
        curMatchSet.add(new Set(homePlayer2,awayPlayer2,set.get(i++),set.get(i++),set.get(i++)));
        curMatchSet.add(new Set(set.get(i++),set.get(i++),set.get(i++)));
        
        for(Match LoopMatch:match){
            if(LoopMatch.getHomeTeam() == curMatch.getHomeTeam() && LoopMatch.getAwayTeam() == curMatch.getAwayTeam()){
                        LoopMatch.getScoreSheet().setSet(curMatchSet);
                        break;
                    }
        }
        return true;
    }
    
    @FXML
    public void handleModifySheetButton(ActionEvent event){
        Match currentMatch = null;
        String homeTeam = null;
        String awayTeam = null;
        
        if(homeTeam_cb.getSelectionModel().isEmpty() || awayTeam_cb.getSelectionModel().isEmpty()){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please select both team!");
            a.show();
        }
        else if(homeTeam_cb.getSelectionModel().getSelectedItem() == awayTeam_cb.getSelectionModel().getSelectedItem()){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Cannot select the same team!");
            a.show();
        }else{
            homeTeam = homeTeam_cb.getSelectionModel().getSelectedItem().toString();
            awayTeam = awayTeam_cb.getSelectionModel().getSelectedItem().toString();
            
            if(!match.isEmpty()){
                for(Match LoopMatch:match){
                    if(LoopMatch.getHomeTeam() == homeTeam && LoopMatch.getAwayTeam() == awayTeam){
                        currentMatch = LoopMatch;
                        break;
                    }
                }
            }else{
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Not match is created yet");
                a.show();
            }
            if(currentMatch != null){
                setUpSetToScoreSheet(currentMatch);
                setUpTeamMenuButton(homeTeam,awayTeam);
                select_team_pane.setVisible(false);
                scoreSheet_pane.setVisible(true);
            
            }else{
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("This Match is not exist yet Please create it!");
                a.show();
            }
        }

    }
    
    @FXML
    public void handleNewSheetButton(ActionEvent event){
        Match currentMatch = null;
        String homeTeam;
        String awayTeam;
        
        if(homeTeam_cb.getSelectionModel().isEmpty() || awayTeam_cb.getSelectionModel().isEmpty()){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please select both team!");
            a.show();
        }
        else if(homeTeam_cb.getSelectionModel().getSelectedItem() == awayTeam_cb.getSelectionModel().getSelectedItem()){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Cannot select the same team!");
            a.show();
        }else{
            homeTeam = homeTeam_cb.getSelectionModel().getSelectedItem().toString();
            awayTeam = awayTeam_cb.getSelectionModel().getSelectedItem().toString();
            
            if(!match.isEmpty()){
                for(Match LoopMatch:match){
                    if(LoopMatch.getHomeTeam() == homeTeam && LoopMatch.getAwayTeam() == awayTeam){
                        currentMatch = LoopMatch;
                        Alert a = new Alert(AlertType.ERROR);
                        a.setContentText("This match is already existed");
                        a.show();
                        break;
                    }
                }
            }
            if(currentMatch == null){
                currentMatch = new Match(homeTeam,awayTeam);
                match.add(currentMatch);
                select_team_pane.setVisible(false);
                scoreSheet_pane.setVisible(true);
                setUpSetToScoreSheet(currentMatch);
                setUpTeamMenuButton(homeTeam,awayTeam);
            }else{
                System.out.println("ERROR IN NETsheet");
            }
        }
        
    }
    
    @FXML
    public void handleReturnToSelectTeamButton(ActionEvent event){
        scoreSheet_pane.setVisible(false);
        select_team_pane.setVisible(true);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
