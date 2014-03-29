/**
 * Project: RiskAttackSequence
 * File: Player.java
 *
 * Author: Ming-Cee Yee
 *
 * Date Created: 2014-03-07
 * Last Modified: 2014-03-09
 * Description: Player class, includes information about Cards held and
 *              Territories occupied.
 */

import java.util.ArrayList;
import java.util.List;

public class Player
{
    //--VARIABLES---------------------------------------------------------------
    
    private ArrayList<Card> cards;          // Cards held
    private int             occTerritories; // number of Territories occupied
    
    
    //--CONSTRUCTORS-----------------------------------------------------------
    
    public Player(ArrayList<Card> c, int o)
    {
        cards = c;
        occTerritories = o;
    }
    
    
    //--METHODS-----------------------------------------------------------------
    
    //--getters--
    
    /**
     * getCards() returns `cards`
     * PRE: true
     * POST: returns `cards`
     */
    List<Card> getCards()
    {
        return cards;
    }
    
    /**
     * getOccTerritories() returns `occTerritories`
     * PRE: true
     * POST: returns `occTerritories`
     */
    int getOccTerritories()
    {
        return occTerritories;
    }
    
    /**
     * isEliminated() checks if this Player has been eliminated from the game
     * PRE: true
     * POST: returns true if eliminated, false otherwise
     */
    Boolean isEliminated()
    {
        return occTerritories <= 0;
    }
    
    
    //--setters--
    
    /**
     * addCard(c) adds `c` to this Player's stack of Cards
     * PRE: true
     * POST: `cards` includes `c`
     */
    void addCard(Card c)
    {
        cards.add(c);
    }
    
    /**
     * addTerritory() increments this Player's number of occupied Territories
     * PRE: true
     * POST: adds 1 to number of occupied Territories
     */
    void addTerritory()
    {
        occTerritories++;
    }
    
    /**
     * removeCards(c) removes each Card in c from this Player's stack of Cards
     * PRE: true
     * POST: each Card in c is removed from `cards`
     */
    void removeCards(List<Card> c)
    {
        if (!c.isEmpty())
        {
            for (Card item : c)
            {
                cards.remove(item);
            }
        }
    }
    
    /**
     * removeTerritory() decrements this Player's number of occupied Territories
     * PRE: true
     * POST: subtracts 1 from number of occupied Territories
     */
    void removeTerritory()
    {
        occTerritories--;
    }
    

}
