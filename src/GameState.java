/**
 * Project: RiskAttackSequence
 * File: GameState.java
 *
 * Author: Ming-Cee Yee
 *
 * Date Created: 2014-03-10
 * Last Modified: 2014-03-11
 * Description: Stores the state of the game: continents, active players,
 *              all players, association of territories to continents, and
 *              bonus amounts for occupying continents. 
 */

import java.util.List;

public class GameState
{
    //--VARIABLES---------------------------------------------------------------
    
    private final int           AFRICA = 0;
    private final int           ASIA = 1;
    private final int           AUSTRALIA = 2;
    private final int           EUROPE = 3;
    private final int           NORTH_AMERICA = 4;
    private final int           SOUTH_AMERICA = 5;
    
    private List<Player>        activePlayers;  // Players still in the game
    private int[]               continentBonus; // bonus from occupying
                                                // continents, index is given
                                                // continent
    private List<List<Territory>> continents;
                                                // Territories in each continent
                                                // index is given continent
    private List<Player>        players;        // Players in the game
    
    
    //--CONSTRUCTORS------------------------------------------------------------
    public GameState(List<Player> ap, int[] cb,
                     List<List<Territory>> c, List<Player> p)
    {
        activePlayers = ap;
        continentBonus = cb;
        continents = c;
        players = p;
    }
    
    
    //--METHODS-----------------------------------------------------------------
    
    //--getters--
    
    /**
     * getActivePlayers() returns the list of players still in the game
     * PRE: true
     * POST: returns `activePlayers`
     */
    List<Player> getActivePlayers()
    {
        return activePlayers;
    }
    
    /**
     * getContinentBonus(c) returns the bonus awarded for occupying `c`
     * PRE: true
     * POST: returns bonus awarded for given continent
     */
    int getContinentBonus(int c)
    {
        return continentBonus[c];
    }
    
    /**
     * getContinents() returns the list of continents and their associated
     *                 Territories
     * PRE: true
     * POST: returns list of continents and associated Territories
     */
    List<List<Territory>> getContinents()
    {
        return continents;
    }
    
    /**
     * getContinentOcc(c) returns the name of the Player who is occupying `c`
     * PRE: true
     * POST: returns name of Player occupying `c`
     */
    String getContinentOcc(int c)
    {
        List<Territory> cont = continents.get(c); // list of Territories in `c`
        String nm = cont.get(0).getOccPlayer();   // name of first Territory's
                                                  // occupying Player
        
        for (t : cont)
        {
            
        }
    }
    
    //--setters--

}
