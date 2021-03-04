/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Fixture {
    private ArrayList<Team> teams;
    
    public Fixture(ArrayList<Team> fix_team){
        teams = fix_team;
    }
    
    public ArrayList<Team> getTeams(){
        return teams;
    }
    
}
