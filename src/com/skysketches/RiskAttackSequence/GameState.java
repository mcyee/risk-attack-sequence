/**
 * Author: Ming-Cee Yee
 * Date Created: 2014-03-10
 * Description: Stores the state of the game: continents, active players,
 *              all players, association of territories to continents, and
 *              bonus amounts for occupying continents. 
 */

package com.skysketches.RiskAttackSequence;

import java.util.ArrayList;
import java.util.List;

public class GameState {

	//--VARIABLES---------------------------------------------------------------
	private enum Continent {
		AFRICA(0), ASIA(1), AUSTRALIA(2), EUROPE(3), NAMERICA(4), SAMERICA(5);

		private final int ID;

		Continent(int id) {
			this.ID = id;
		}

		public int getID() {
			return this.ID;
		}
	}

	private List<Player> activePlayers;  // Players still in the game
	private int[] continentBonus; // bonus from occupying continents, index is given continent
	private List<List<Territory>> continents; // Territories in each continent
	private List<Player> players; // Players in the game


	//--CONSTRUCTORS------------------------------------------------------------
	public GameState(List<Player> ap, int[] cb, List<List<Territory>> c, List<Player> p) {
		this.activePlayers = ap;
		this.continentBonus = cb;
		this.continents = c;
		this.players = p;
	}


	//--METHODS-----------------------------------------------------------------

	/**
	 * init() initialises the game by setting up the Territories and Players
	 */
	public void init() {
		// Initialise Territories
		
		// add Africa
		List<Territory> africa = new ArrayList<Territory>();
		List<String> territories = new ArrayList<String>();
		
		// add Congo to Africa
		territories.add("East Africa");
		territories.add("North Africa");
		territories.add("South Africa");
		africa.add(new Territory(territories, 0, "Congo", ""));
		
		// add ... to Africa
		
		//TODO write body
	}
	
	//--getters--

	/**
	 * findPlayer(p) returns the Player whose name is `p`
	 */
	public Player findPlayer(String p) {
		for (Player pl : players) {
			if (pl.getName().equals(p)) {
				return pl;
			}
		}

		return players.get(0);
	}

	/**
	 * getActivePlayers() returns the list of players still in the game
	 */
	public List<Player> getActivePlayers() {
		return this.activePlayers;
	}

	/**
	 * getContinentBonus(c) returns the bonus awarded for occupying `c`
	 */
	public int getContinentBonus(Continent c) {
		return this.continentBonus[c.getID()];
	}

	/**
	 * getContinents() returns the list of continents and their associated
	 * Territories
	 */
	public List<List<Territory>> getContinents() {
		return this.continents;
	}

	/**
	 * getContinentOcc(c) returns the name of the Player who is occupying `c`
	 * or "!" if it is unoccupied
	 */
	public String getContinentOcc(int c) {
		List<Territory> cont = continents.get(c); // list of Territories in `c`
		String nm = cont.get(0).getOccPlayer(); // name of first Territory's occupying Player

		for (Territory t : cont) {
			if (!nm.equals(t.getName())) {
				return "!";
			}
		}

		return nm;
	}

	/**
	 * getPlayers() returns the list of Players in the game
	 */
	public List<Player> getPlayers() {
		return this.players;
	}

	//--setters--

	/**
	 * addActivePlayer(p) adds p to list of active Players
	 */
	public void addActivePlayer(Player p) {
		this.activePlayers.add(p);
	}

	/**
	 * addPlayer(p) adds p to list of Players
	 */
	public void addPlayer(Player p) {
		this.players.add(p);
	}

	/**
	 * removeActivePlayer(p) removes p from list of active Players
	 */
	public void removeActivePlayer(Player p) {
		this.activePlayers.remove(p);
	}

	/**
	 * removePlayer(p) removes p from list of Players
	 */
	public void removePlayer(Player p) {
		this.players.remove(p);
	}

}
