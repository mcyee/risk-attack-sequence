/**
 * Author: Ming-Cee Yee
 * Date Created: 2014-03-11
 * Description: Territories on the Risk map.
 */

package com.skysketches.RiskAttackSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Territory {
	//--VARIABLES---------------------------------------------------------------

	private final String name; // name of this Territory
	private final List<String> adjacent; // adjacent Territories
	private int armies; // number of occupying armies
	private String occPlayer; // currently occupying Player

	//--CONSTRUCTORS------------------------------------------------------------

	// no Player, 0 armies
	public Territory(List<String> t, String n) {
		this.name = n;
		this.adjacent = t;
		this.armies = 0;
		this.occPlayer = "";
	}
	
	public Territory(List<String> t, int a, String n, String o) {
		this.name = n;
		this.adjacent = t;
		this.armies = a;
		this.occPlayer = o;
	}

	//--METHODS-----------------------------------------------------------------

	//--getters--

	/**
	 * getAdjacent() returns the list of adjacent Territories
	 */
	public List<String> getAdjacent() {
		return this.adjacent;
	}

	/**
	 * getArmies() returns the number of armies occupying the Territory
	 */
	public int getArmies() {
		return this.armies;
	}

	/**
	 * getName() returns the name of the Territory
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getOccPlayer() returns the name of the occupying Player
	 */
	public String getOccPlayer() {
		return this.occPlayer;
	}

	//-setters--

	/**
	 * addArmies(n) adds `n` more occupying armies to the Territory, returns
	 * false if invalid number of armies
	 */
	public Boolean addArmies(int n) {
		if (n < 1) return false;
		
		this.armies += n;
		return true;
	}

	/**
	 * isValidDice(n, max, armies) returns true if `n` is a valid number of dice
	 * to roll given `max` number of dice and `armies` of Territory
	 * PRE: `max` == 2 or `max` == 3, `armies` > 0
	 */
	private static Boolean isValidDice(int n, int max, int armies) {
		// TODO throw error?
		if (max != 2 && max != 3) return false;
		if (armies < 1) return false;
		
		return ((n > 0) && (n <= max) && (n < armies));
	}

	/**
	 * promptDice(t, attack) prompts the Player for number of dice to roll
	 * if attack == true, Player is attacking, defending otherwise
	 */
	private static int promptDice(Territory t, Boolean attack) {
		Boolean loop = true; // loop control

		String action; // "attack" or "defend"
		int dice = 0; // prompted number
		String player = t.getOccPlayer();
		int max; // 3 or 2

		if (attack) {
			action = "attack";
			max = 3;
		}
		else {
			action = "defend";
			max = 2;
		}

		// attacker must have more than one army in territory to attack
		if (t.getArmies() <= 1 && attack) {
			System.out.println("Sorry, you do not have enough armies to attack.");
		}
		else {
			do {
				System.out.println(player + ", how many armies to "
						+ action + " with? : ");

				// Take user input `str`
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
					String str = reader.readLine();

					// Check if `str` is valid number of armies
					dice = Integer.valueOf(str);
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (!isValidDice(dice, max, t.getArmies())) {
					System.out.println("That's not a valid number."
							+ " Please try again.\n");
				}
				else {
					loop = false;
				}
			} while (loop);
		}

		return dice;
	}

	/**
	 * attack(t) attacks `t` from the Territory
	 */
	public void attack(Territory t) {
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
		if (aDice.length > dDice.length) {
			check = dDice.length;
		}
		else {
			check = aDice.length;
		}

		for (int i = 0; i < check; i++) {
			if (aDice[i] > dDice[i]) {
				System.out.println(getOccPlayer() + " rolls a " + aDice[i]
						+ ", which is greater than " + t.getOccPlayer()
						+ "'s " + dDice[i] + ". " + getOccPlayer()
						+ "wins the battle!");
				t.removeArmies(1);
				defendDice--;
			}
			else {
				System.out.print(t.getOccPlayer() + " rolls a " + dDice[i]
						+ "which is ");
				if (aDice[i] == dDice[i]) {
					System.out.print("equal to ");
				}
				else {
					System.out.print("greater than ");
				}

				System.out.println(getOccPlayer() + "'s " + aDice[i] + ". "
						+ t.getOccPlayer() + " wins the battle!");

				removeArmies(1);
				attackDice--;
			}
		}

		// change results of attack
		if (t.getArmies() <= 0) {
			System.out.println(getOccPlayer() + " has conquered "
					+ t.getName() + "!");
			t.changeOccPlayer(getOccPlayer());
			t.addArmies(attackDice);
		}
		else { // if (attackDice <= 0)
			System.out.println(t.getOccPlayer() + " has successfully defended "
					+ t.getName() + " from " + getOccPlayer() + "!");
		}
	}

	/**
	 * changeOccPlayer(p) changes the occupying Player of the Territory to `p`
	 */
	public void changeOccPlayer(String p) {
		this.occPlayer = p;
	}


	/**
	 * removeArmies() decreases the number of armies occupying the Territory
	 * by `n`, returns false if invalid number of armies
	 */
	public Boolean removeArmies(int n) {
		if (armies < 1) return false;
		if (armies > this.armies) return false;
		
		this.armies -= n;
		return true;
	}

}
