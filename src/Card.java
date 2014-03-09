/**
 * Project: RiskAttackSequence
 * File: Card.java
 *
 * Author: Ming-Cee Yee
 *
 * Date Created: 2014-03-09
 * Last Modified: 2014-03-09
 * Description: Risk cards that can be traded in for more armies
 */

public class Card
{
    //--VARIABLES---------------------------------------------------------------

    private String  name;       // name of card
    private int     stars;      // number of stars on card, max 2
    private String  territory;  // Territory depicted on card
    private String  unit;       // unit depicted on card (soldier/cavalry/artillery)
    
    
    //--CONSTRUCTORS------------------------------------------------------------
    
    // Star-type Card
    public Card(String n, int s)
    {
        name = n;
        stars = s;
    }
    
    // Territory-Unit-type Card
    public Card(String n, String t, String u)
    {
        name = n;
        territory = t;
        unit = u;
    }
    
    
    //--METHODS-----------------------------------------------------------------
    
    //--getters--
    
    /**
     * getName() returns `name`
     * PRE: true
     * POST: returns `name`
     */
    String getName()
    {
        return this.name;
    }
    
    /**
     * getStars() returns `stars`
     * PRE: true
     * POST: returns `stars`
     */
    int getStars()
    {
        return this.stars;
    }
    
    /**
     * getTerritory() returns `territory`
     * PRE: true
     * POST: returns `territory`
     */
    String getTerritory()
    {
        return this.territory;
    }
    
    /**
     * getUnit() returns `unit`
     * PRE: true
     * POST: returns `unit`
     */
    String getUnit()
    {
        return this.unit;
    }

}
