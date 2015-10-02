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
	 * initContinents() initialises the Territories in all the continents
	 */
	private Boolean initContinents() {
		// add Africa
		List<Territory> africa = new ArrayList<Territory>();
		List<String> territories = new ArrayList<String>();
		
		// add Congo to Africa
		territories.add("East Africa");
		territories.add("North Africa");
		territories.add("South Africa");
		africa.add(new Territory(territories, "Congo"));
		
		// add East Africa to Africa
		territories.clear();
		territories.add("Congo");
		territories.add("Egypt");
		territories.add("Madagascar");
		territories.add("North Africa");
		territories.add("South Africa");
		territories.add("Middle East");
		africa.add(new Territory(territories, "East Africa"));
		
		// add Egypt to Africa
		territories.clear();
		territories.add("East Africa");
		territories.add("North Africa");
		territories.add("Southern Europe");
		territories.add("Middle East");
		africa.add(new Territory(territories, "Egypt"));
		
		// add Madagascar to Africa
		territories.clear();
		territories.add("East Africa");
		territories.add("South Africa");
		africa.add(new Territory(territories, "Madagascar"));
		
		// add North Africa to Africa
		territories.clear();
		territories.add("Congo");
		territories.add("East Africa");
		territories.add("Egypt");
		territories.add("Brazil");
		territories.add("Southern Europe");
		territories.add("Western Europe");
		africa.add(new Territory(territories, "North Africa"));
		
		// add South Africa to Africa
		territories.clear();
		territories.add("Congo");
		territories.add("East Africa");
		territories.add("Madagascar");
		africa.add(new Territory(territories, "South Africa"));
		
		this.continents.add(africa);
		
		// add Australia
		List<Territory> australia = new ArrayList<Territory>();
		
		// add Eastern Australia to Australia
		territories.clear();
		territories.add("New Guinea");
		territories.add("Western Australia");
		australia.add(new Territory(territories, "Eastern Australia"));
		
		// add Indonesia to Australia
		territories.clear();
		territories.add("New Guinea");
		territories.add("Western Australia");
		territories.add("Siam");
		australia.add(new Territory(territories, "Indonesia"));
		
		// add New Guinea to Australia
		territories.clear();
		territories.add("Eastern Australia");
		territories.add("Indonesia");
		territories.add("Western Australia");
		australia.add(new Territory(territories, "New Guinea"));
		
		// add Western Australia to Australia
		territories.clear();
		territories.add("Eastern Australia");
		territories.add("Indonesia");
		territories.add("New Guinea");
		australia.add(new Territory(territories, "Western Australia"));
		
		this.continents.add(australia);
		
		// add Asia
		List<Territory> asia = new ArrayList<Territory>();
		
		// add Afghanistan to Asia
		territories.clear();
		territories.add("China");
		territories.add("India");
		territories.add("Ukraine");
		territories.add("Middle East");
		territories.add("Ural");
		asia.add(new Territory(territories, "Afghanistan"));
		
		// add China to Asia
		territories.clear();
		territories.add("Afghanistan");
		territories.add("India");
		territories.add("Mongolia");
		territories.add("Siam");
		territories.add("Siberia");
		territories.add("Ural");
		asia.add(new Territory(territories, "China"));
		
		// add India to Asia
		territories.clear();
		territories.add("Afghanistan");
		territories.add("China");
		territories.add("Middle East");
		territories.add("Siam");
		asia.add(new Territory(territories, "India"));
		
		// add Irkutsk to Asia
		territories.clear();
		territories.add("Kamchatka");
		territories.add("Mongolia");
		territories.add("Siberia");
		territories.add("Yakutsk");
		asia.add(new Territory(territories, "Irkutsk"));
		
		// add Japan to Asia
		territories.clear();
		territories.add("Kamchatka");
		territories.add("Mongolia");
		asia.add(new Territory(territories, "Japan"));
		
		// add Kamchatka to Asia
		territories.clear();
		territories.add("Alaska");
		territories.add("Irkutsk");
		territories.add("Japan");
		territories.add("Mongolia");
		territories.add("Yakutsk");
		asia.add(new Territory(territories, "Kamchatka"));
		
		// add Middle East to Asia
		territories.clear();
		territories.add("Afghanistan");
		territories.add("East Africa");
		territories.add("India");
		territories.add("Egypt");
		territories.add("Southern Europe");
		territories.add("Ukraine");
		asia.add(new Territory(territories, "Middle East"));
		
		// add Mongolia to Asia
		territories.clear();
		territories.add("China");
		territories.add("Irkutsk");
		territories.add("Japan");
		territories.add("Kamchatka");
		territories.add("Siberia");
		asia.add(new Territory(territories, "Mongolia"));
		
		// add Siam to Asia
		territories.clear();
		territories.add("Indonesia");
		territories.add("China");
		territories.add("India");
		asia.add(new Territory(territories, "Siam"));
		
		// add Siberia to Asia
		territories.clear();
		territories.add("China");
		territories.add("Irkutsk");
		territories.add("Mongolia");
		territories.add("Ural");
		territories.add("Yakutsk");
		asia.add(new Territory(territories, "Siberia"));
		
		// add Ural to Asia
		territories.clear();
		territories.add("Afghanistan");
		territories.add("China");
		territories.add("Ukraine");
		territories.add("Siberia");
		asia.add(new Territory(territories, "Ural"));
		
		// add Yakutsk to Asia
		territories.clear();
		territories.add("Irkutsk");
		territories.add("Kamchatka");
		territories.add("Siberia");
		asia.add(new Territory(territories, "Yakutsk"));
		
		this.continents.add(asia);
		
		// add Europe
		List<Territory> europe = new ArrayList<Territory>();
		
		// add Great Britain to Europe
		territories.clear();
		territories.add("Iceland");
		territories.add("Northern Europe");
		territories.add("Scandinavia");
		territories.add("Western Europe");
		europe.add(new Territory(territories, "Great Britain"));
		
		// add Iceland to Europe
		territories.clear();
		territories.add("Great Britain");
		territories.add("Scandinavia");
		territories.add("Greenland");
		europe.add(new Territory(territories, "Iceland"));
		
		// add Northern Europe to Europe
		territories.clear();
		territories.add("Great Britain");
		territories.add("Scandinavia");
		territories.add("Southern Europe");
		territories.add("Ukraine");
		territories.add("Western Europe");
		europe.add(new Territory(territories, "Northern Europe"));
		
		// add Scandinavia to Europe
		territories.clear();
		territories.add("Great Britain");
		territories.add("Iceland");
		territories.add("Northern Europe");
		territories.add("Ukraine");
		europe.add(new Territory(territories, "Scandinavia"));
		
		// add Southern Europe to Europe
		territories.clear();
		territories.add("Northern Europe");
		territories.add("Egypt");
		territories.add("North Africa");
		territories.add("Ukraine");
		territories.add("Western Europe");
		territories.add("Middle East");
		europe.add(new Territory(territories, "Southern Europe"));
		
		// add Ukraine to Europe
		territories.clear();
		territories.add("Afghanistan");
		territories.add("Northern Europe");
		territories.add("Scandinavia");
		territories.add("Southern Europe");
		territories.add("Middle East");
		territories.add("Ural");
		europe.add(new Territory(territories, "Ukraine"));
		
		// add Western Europe to Europe
		territories.clear();
		territories.add("Great Britain");
		territories.add("Northern Europe");
		territories.add("Southern Europe");
		territories.add("North Africa");
		europe.add(new Territory(territories, "Western Europe"));
	}
	
	/**
	 * init() initialises the game by setting up the Territories and Players
	 */
	public void init() {
		// Initialise Territories
		initContinents();
		
		
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
