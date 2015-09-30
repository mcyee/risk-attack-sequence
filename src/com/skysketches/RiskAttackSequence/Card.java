/**
 * Author: Ming-Cee Yee
 * Date Created: 2014-03-09
 * Description: Risk cards that can be traded in for more armies
 */

package com.skysketches.RiskAttackSequence;

public class Card {
	//--VARIABLES---------------------------------------------------------------

	private String name; // name of card
	private int stars; // number of stars on card, max 2
	private String territory; // Territory depicted on card
	private String unit; // unit depicted on card (soldier/cavalry/artillery)


	//--CONSTRUCTORS------------------------------------------------------------

	// Star-type Card
	public Card(String n, int s) {
		this.name = n;
		this.stars = s;
	}

	// Territory-Unit-type Card
	public Card(String n, String t, String u) {
		this.name = n;
		this.territory = t;
		this.unit = u;
	}


	//--METHODS-----------------------------------------------------------------

	//--getters--

	/**
	 * getName() returns `name`
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getStars() returns `stars`
	 */
	public int getStars() {
		return this.stars;
	}

	/**
	 * getTerritory() returns `territory`
	 */
	public String getTerritory() {
		return this.territory;
	}

	/**
	 * getUnit() returns `unit`
	 */
	public String getUnit() {
		return this.unit;
	}

}
