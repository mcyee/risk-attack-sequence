/**
 * Project: RiskAttackSequence
 * File: GameState.java
 *
 * Author: Ming-Cee Yee
 *
 * Date Created: 2014-03-10
 * Last Modified: 2014-04-06
 * Description: Stores the state of the game: continents, active players,
 *              all players, association of territories to continents, and
 *              bonus amounts for occupying continents. 
 */

import java.util.List;

public class GameState
{
    //--VARIABLES---------------------------------------------------------------
    
    public final int           AFRICA = 0;
    public final int           ASIA = 1;
    public final int           AUSTRALIA = 2;
    public final int           EUROPE = 3;
    public final int           NORTH_AMERICA = 4;
    public final int           SOUTH_AMERICA = 5;
    
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
     * findPlayer(p) returns the Player whose name is `p`
     * PRE: `p` is name of a Player
     * POST: returns the Player whose name is `p`
     *       returns the first Player in `players` otherwise
     */
    public Player findPlayer(String p)
    {
        for (Player pl : players)
        {
            if (pl.getName() == p)
            {
                return pl;
            }
        }
        
        return players.get(0);
    }
    
    /**
     * getActivePlayers() returns the list of players still in the game
     * PRE: true
     * POST: returns `activePlayers`
     */
    public List<Player> getActivePlayers()
    {
        return activePlayers;
    }
    
    /**
     * getContinentBonus(c) returns the bonus awarded for occupying `c`
     * PRE: true
     * POST: returns bonus awarded for given continent
     */
    public int getContinentBonus(int c)
    {
        return continentBonus[c];
    }
    
    /**
     * getContinents() returns the list of continents and their associated
     *                 Territories
     * PRE: true
     * POST: returns list of continents and associated Territories
     */
    public List<List<Territory>> getContinents()
    {
        return continents;
    }
    
    /**
     * getContinentOcc(c) returns the name of the Player who is occupying `c`
     * PRE: true
     * POST: returns name of Player occupying `c` or "no one" if not occupied
     */
    public String getContinentOcc(int c)
    {
        List<Territory> cont = continents.get(c); // list of Territories in `c`
        String nm = cont.get(0).getOccPlayer();   // name of first Territory's
                                                  // occupying Player
        
        for (Territory t : cont)
        {
            if (!nm.equals(t.getName()))
            {
                return "no one";
            }
        }
        
        return nm;
    }
    
    /**
     * getPlayers() returns the list of Players in the game
     * PRE: true
     * POST: returns `players`
     */
    public List<Player> getPlayers()
    {
        return players;
    }
    
    //--setters--
    
    /**
     * addActivePlayer(p) adds p to list of active Players
     * PRE: true
     * POST: p is added to `activePlayers`
     */
    public void addActivePlayer(Player p)
    {
        activePlayers.add(p);
    }
    
    /**
     * addPlayer(p) adds p to list of Players
     * PRE: true
     * POST: p is added to `players`
     */
    public void addPlayer(Player p)
    {
        players.add(p);
    }
    
    /**
     * removeActivePlayer(p) removes p from list of active Players
     * PRE: true
     * POST: p is removed from `activePlayers`
     */
    public void removeActivePlayer(Player p)
    {
        activePlayers.remove(p);
    }
    
    /**
     * removePlayer(p) removes p from list of Players
     * PRE: true
     * POST: p is removed from `players`
     */
    public void removePlayer(Player p)
    {
        players.remove(p);
    }

}
