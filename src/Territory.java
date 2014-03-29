/**
 * Project: RiskAttackSequence
 * File: Territory.java
 *
 * Author: Ming-Cee Yee
 *
 * Date Created: 2014-03-11
 * Last Modified: 2014-03-11
 * Description: Territories on the Risk map.
 */

import java.util.List;

public class Territory
{
    //--VARIABLES---------------------------------------------------------------
    
    private List<String> adjacent;  // adjacent Territories that can be attacked
                                    // or defended from
    private int          armies;    // number of armies currently occupying
    private String       name;      // name of this Territory
    private String       occPlayer; // currently occupying Player
    //--CONSTRUCTORS------------------------------------------------------------
    
    public Territory(List<String> t, int a, String n, String o)
    {
        adjacent = t;
        armies = a;
        name = n;
        occPlayer = o;
    }
    
    //--METHODS-----------------------------------------------------------------
    
    //--getters--
    
    /**
     * getAdjacent() returns the list of adjacent Territories
     * PRE: true
     * POST: returns list of adjacent Territories
     */
    
    List<String> getAdjacent()
    {
        return adjacent;
    }
    
    /**
     * getArmies() returns the number of armies occupying the Territory
     * PRE: true
     * POST: returns number of armies occupying Territory
     */
    int getArmies()
    {
        return armies;
    }
    
    /**
     * getName() returns the name of the Territory
     * PRE: true
     * POST: returns name of Territory
     */
    String getName()
    {
        return name;
    }
    
    /**
     * getOccPlayer() returns the name of the occupying Player
     * PRE: true
     * POST: returns name of occupying Player
     */
    String getOccPlayer()
    {
        return occPlayer;
    }
    
    //-setters--
    
    /**
     * addArmies(n) adds `n` more occupying armies to the Territory
     * PRE: n >= 0
     * POST: adds `n` more armies
     */
    void addArmies(int n)
    {
        armies += n;
    }
    
    /**
     * attack(t, d) attacks `t` with `d` armies
     * PRE: 0 < d <= 3, d < armies
     * POST: returns array of sorted Dice values  
     */
    int[] attack(Territory t, int d)
    {
        int[] diceRolls = new int[d]; // array of rolled values
        Die die1 = new Die();
        
        for (int i = 0; i < d; i++)
        {
            die1.rollDie();
            diceRolls[i] = die1.getValue();
        }
        
        return diceRolls;
    }
    
    /**
     * changeOccPlayer(p) changes the occupying Player of the Territory to `p`
     * PRE: `p` is name of Player in `activePlayers`
     * POST: changes occupying Player name to `p`
     */
    void changeOccPlayer(String p)
    {
        occPlayer = p;
    }
    
    /**
     * defend(d) defends this Territory with `d` armies
     * PRE: 0 < d <= 2, d < armies
     * POST: returns array of sorted Dice values
     */
    

}
