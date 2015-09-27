/**
 * Project: RiskAttackSequence
 * File: Territory.java
 *
 * Author: Ming-Cee Yee
 *
 * Date Created: 2014-03-11
 * Last Modified: 2014-04-17
 * Description: Territories on the Risk map.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Territory
{
    //--VARIABLES---------------------------------------------------------------
    
    private ArrayList<String> adjacent;  // adjacent Territories that can be
                                         // attacked or defended from
    private int          armies;         // number of armies currently occupying
    private String       name;           // name of this Territory
    private String       occPlayer;      // currently occupying Player
    
    //--CONSTRUCTORS------------------------------------------------------------
    
    public Territory(ArrayList<String> t, int a, String n, String o)
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
    public List<String> getAdjacent()
    {
        return adjacent;
    }
    
    /**
     * getArmies() returns the number of armies occupying the Territory
     * PRE: true
     * POST: returns number of armies occupying Territory
     */
    public int getArmies()
    {
        return armies;
    }
    
    /**
     * getName() returns the name of the Territory
     * PRE: true
     * POST: returns name of Territory
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * getOccPlayer() returns the name of the occupying Player
     * PRE: true
     * POST: returns name of occupying Player
     */
    public String getOccPlayer()
    {
        return occPlayer;
    }
    
    //-setters--
    
    /**
     * addArmies(n) adds `n` more occupying armies to the Territory
     * PRE: n >= 0
     * POST: adds `n` more armies
     */
    public void addArmies(int n)
    {
        armies += n;
    }
    
    /**
     * isValidDice(n, max, armies) checks if `n` is a valid number of dice to
     *            roll given `max` number of dice and `armies` of Territory
     *            helper for attack(t)
     * PRE: `max` == 2 or `max` == 3, `armies` > 0
     * POST: returns true if n is valid, false otherwise
     */
    private static Boolean isValidDice(int n, int max, int armies)
    {
        return ((n > 0) && (n <= max) && (n < armies));
    }
    
    /**
     * promptDice(t, attack) prompts the Player for number of dice to roll
     *           if attack == true, Player is attacking, defending otherwise
     *           helper for attack(t)
     * PRE: true
     * POST: returns the number of dice to roll
     *       prompts Player for number of dice to roll until valid number
     *       is provided
     */
    private static int promptDice(Territory t, Boolean attack)
    {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader    reader = new BufferedReader(stream);
        Boolean     b = true;   // loop control
        
        String      action;     // "attack" or "defend"
        int         dice = 0;   // prompted number
        String      player = t.getOccPlayer();
        int         max;        // 3 or 2
        
        if (attack)
        {
            action = "attack";
            max = 3;
        }
        else
        {
            action = "defend";
            max = 2;
        }
        
        // attacker must have more than one army in territory to attack
        if (t.getArmies() <= 1 && attack)
        {
            System.out.println("Sorry, you do not have enough armies to attack.");
        }
        else
        {
            do
            {
                System.out.println(player + ", how many armies to "
                        + action + " with? : ");
                String str;
                
                // Take user input `str`
                try
                {
                    str = reader.readLine();
                }
                catch (IOException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    continue;
                }
                
                // Check if `str` is valid number of armies
                try
                {
                    dice = Integer.valueOf(str);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("That's not an integer. Please try again.\n");
                    continue;
                }
                
                if (!isValidDice(dice, max, t.getArmies()))
                {
                    System.out.println("That's not a valid number."
                            + " Please try again.\n");
                }
                else
                {
                    b = false;
                }
            } while (b);
        }
        
        return dice;
    }
    
    /**
     * attack(t) attacks `t` from the Territory
     * PRE: true
     * POST: attack is performed on t  
     */
    public void attack(Territory t)
    {
        // prompt for user input: number of dice to roll
        int attackDice = promptDice(this, true);
        int defendDice = promptDice(t, false);
        
        // roll dice
        Die d = new Die();
        int[] aDice = new int[attackDice];
        int[] dDice = new int[defendDice];
        
        aDice = d.rollDice(attackDice);
        dDice = d.rollDice(defendDice);
        Arrays.sort(aDice);
        Arrays.sort(dDice);
        
        // compare dice values
        int check;
        if (aDice.length > dDice.length)
        {
            check = dDice.length;
        }
        else
        {
            check = aDice.length;
        }
        
        for (int i = 0; i < check; i++)
        {
            if (aDice[i] > dDice[i])
            {
                System.out.println(getOccPlayer() + " rolls a " + aDice[i]
                        + ", which is greater than " + t.getOccPlayer()
                        + "'s " + dDice[i] + ". " + getOccPlayer()
                        + "wins the battle!");
                t.removeArmies(1);
                defendDice--;
            }
            else
            {
                System.out.print(t.getOccPlayer() + " rolls a " + dDice[i]
                        + "which is ");
                if (aDice[i] == dDice[i])
                {
                    System.out.print("equal to ");
                }
                else
                {
                    System.out.print("greater than ");
                }
                
                System.out.println(getOccPlayer() + "'s " + aDice[i] + ". "
                        + t.getOccPlayer() + " wins the battle!");
                
                removeArmies(1);
                attackDice--;
            }
        }
        
        // change results of attack
        if (t.getArmies() <= 0)
        {
            System.out.println(getOccPlayer() + " has conquered "
                    + t.getName() + "!");
            t.changeOccPlayer(getOccPlayer());
            t.addArmies(attackDice);
            
        }
        else // if (attackDice <= 0)
        {
            System.out.println(t.getOccPlayer() + " has successfully defended "
                    + t.getName() + " from " + getOccPlayer() + "!");
        }
    }
    
    /**
     * changeOccPlayer(p) changes the occupying Player of the Territory to `p`
     * PRE: `p` is name of Player in `activePlayers`
     * POST: changes occupying Player name to `p`
     */
    public void changeOccPlayer(String p)
    {
        occPlayer = p;
    }
    
    
    /**
     * removeArmies() decreases the number of armies occupying the Territory
     *                by `n`
     * PRE: `armies` > 0
     * POST: subtracts `n` from `armies`
     */
    public void removeArmies(int n)
    {
        armies -= n;
    }

}
