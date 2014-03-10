/**
 * Project: RiskAttackSequence
 * File: Die.java
 *
 * Author: Ming-Cee Yee
 *
 * Date Created: 2014-03-09
 * Last Modified: 2014-03-09
 * Description: Provides Dice to roll.
 */

import java.util.Random;

public class Die
{
    //--VARIABLES---------------------------------------------------------------
    private Random  rand;
    private int     faces; // number of faces
    private int     value; // current rolled value
    
    
    //--CONSTRUCTORS------------------------------------------------------------

    // `f`-faced Die
    public Die(int f)
    {
        faces = f;
        value = 1; // default value
    }
    
    // 6-faced Die
    public Die()
    {
        this(6);
    }
    

    //--METHODS-----------------------------------------------------------------
    
    //--getters--
    
    /**
     * getFaces() returns `faces`
     * PRE: true
     * POST: returns `faces`
     */
    int getFaces()
    {
        return faces;
    }
    
    /**
     * getValue() returns `value`
     * PRE: true
     * POST: returns `value`
     */
    int getValue()
    {
        return value;
    }
    
    
    //--setters--
    
    /**
     * rollDie() rolls Die and returns the rolled value
     * PRE: true
     * POST: Die has new `value`
     *       returns new `value`
     */
    int rollDie()
    {
        value = rand.nextInt(6) + 1;
        return value;
    }
    
}
