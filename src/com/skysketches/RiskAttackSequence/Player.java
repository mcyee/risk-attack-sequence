/**
 * Author: Ming-Cee Yee
 * Date Created: 2014-03-07
 * Description: Player class, includes information about Cards held and
 *              Territories occupied.
 */

package com.skysketches.RiskAttackSequence;

import java.util.ArrayList;
import java.util.List;

public class Player {
	//--VARIABLES---------------------------------------------------------------

	private String name; // name of Player
	private Boolean active; // true if still in-game
	private List<Card> cards; // Cards held
	private int occTerritories; // number of Territories occupied


	//--CONSTRUCTORS-----------------------------------------------------------

	public Player(String n) {
		this.name = n;
		this.active = true;
		this.cards = new ArrayList<Card>();
		this.occTerritories = 0;
	}


	//--METHODS-----------------------------------------------------------------

	//--getters--

	/**
	 * getCards() returns `cards`
	 */
	public List<Card> getCards() {
		return this.cards;
	}

	/**
	 * getName() returns `name`
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getOccTerritories() returns `occTerritories`
	 */
	public int getOccTerritories() {
		return this.occTerritories;
	}

	/**
	 * isEliminated() returns true if this Player has been eliminated from the game
	 */
	public Boolean isEliminated() {
		return this.occTerritories <= 0;
	}
	
	/**
	 * isActive() returns true if this Player is still in-game
	 */
	public Boolean isActive() {
		return this.active;
	}


	//--setters--

	/**
	 * addCard(c) adds `c` to this Player's stack of Cards
	 */
	public void addCard(Card c) {
		this.cards.add(c);
	}

	/**
	 * addTerritory() increments this Player's number of occupied Territories
	 */
	public void addTerritory() {
		this.occTerritories++;
	}

	/**
	 * removeCards(c) removes each Card in c from this Player's stack of Cards
	 */
	public void removeCards(List<Card> c) {
		if (!c.isEmpty()) {
			for (Card item : c) {
				this.cards.remove(item);
			}
		}
	}

	/**
	 * removeTerritory() decrements this Player's number of occupied Territories
	 */
	public void removeTerritory() {
		this.occTerritories--;
	}
	
	/**
	 * remove() removes Player from the game
	 */
	public void remove() {
		this.active = false;
	}
}
