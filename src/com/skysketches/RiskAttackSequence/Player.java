/**
 * Author: Ming-Cee Yee
 * Date Created: 2014-03-07
 * Description: Player class, includes information about Cards held and
 *              Territories occupied.
 */

package com.skysketches.RiskAttackSequence;

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
    public List<Card> getCards()
    {
        return cards;
    }
    
    /**
     * getOccTerritories() returns `occTerritories`
     * PRE: true
     * POST: returns `occTerritories`
     */
    public int getOccTerritories()
    {
        return occTerritories;
    }
    
    /**
     * isEliminated() checks if this Player has been eliminated from the game
     * PRE: true
     * POST: returns true if eliminated, false otherwise
     */
    public Boolean isEliminated()
    {
        return occTerritories <= 0;
    }
    
    
    //--setters--
    
    /**
     * addCard(c) adds `c` to this Player's stack of Cards
     * PRE: true
     * POST: `cards` includes `c`
     */
    public void addCard(Card c)
    {
        cards.add(c);
    }
    
    /**
     * addTerritory() increments this Player's number of occupied Territories
     * PRE: true
     * POST: adds 1 to number of occupied Territories
     */
    public void addTerritory()
    {
        occTerritories++;
    }
    
    /**
     * removeCards(c) removes each Card in c from this Player's stack of Cards
     * PRE: true
     * POST: each Card in c is removed from `cards`
     */
    public void removeCards(List<Card> c)
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
    public void removeTerritory()
    {
        occTerritories--;
    }
    

}
