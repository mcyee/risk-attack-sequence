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
import java.util.Scanner;

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

//	private List<Player> activePlayers;  // Players still in the game
	private int[] continentBonus; // bonus from occupying continents, index is given continent
	private List<List<Territory>> continents; // Territories in each continent
	private List<Player> players; // Players in the game
	private int turn; // determines who's turn it is


	//--CONSTRUCTORS------------------------------------------------------------
	public GameState(List<Player> ap, int[] cb, List<List<Territory>> c, List<Player> p) {
//		this.activePlayers = ap;
		this.continentBonus = cb;
		this.continents = c;
		this.players = p;
		this.turn = 0;
	}


	//--METHODS-----------------------------------------------------------------

	/**
	 * initContinents() initialises the Territories in all the continents
	 */
	private void initContinents() {
		// add Africa
		List<Territory> africa = new ArrayList<Territory>();
		
		// add Congo to Africa
		List<String> congoTerr = new ArrayList<String>();
		congoTerr.add("East Africa");
		congoTerr.add("North Africa");
		congoTerr.add("South Africa");
		africa.add(new Territory(congoTerr, "Congo"));
		
		// add East Africa to Africa
		List<String> eafricaTerr = new ArrayList<String>();
		eafricaTerr.add("Congo");
		eafricaTerr.add("Egypt");
		eafricaTerr.add("Madagascar");
		eafricaTerr.add("North Africa");
		eafricaTerr.add("South Africa");
		eafricaTerr.add("Middle East");
		africa.add(new Territory(eafricaTerr, "East Africa"));
		
		// add Egypt to Africa
		List<String> egyptTerr = new ArrayList<String>();
		egyptTerr.add("East Africa");
		egyptTerr.add("North Africa");
		egyptTerr.add("Southern Europe");
		egyptTerr.add("Middle East");
		africa.add(new Territory(egyptTerr, "Egypt"));
		
		// add Madagascar to Africa
		List<String> madagascarTerr = new ArrayList<String>();
		madagascarTerr.add("East Africa");
		madagascarTerr.add("South Africa");
		africa.add(new Territory(madagascarTerr, "Madagascar"));
		
		// add North Africa to Africa
		List<String> nafricaTerr = new ArrayList<String>();
		nafricaTerr.add("Congo");
		nafricaTerr.add("East Africa");
		nafricaTerr.add("Egypt");
		nafricaTerr.add("Brazil");
		nafricaTerr.add("Southern Europe");
		nafricaTerr.add("Western Europe");
		africa.add(new Territory(nafricaTerr, "North Africa"));
		
		// add South Africa to Africa
		List<String> safricaTerr = new ArrayList<String>();
		safricaTerr.add("Congo");
		safricaTerr.add("East Africa");
		safricaTerr.add("Madagascar");
		africa.add(new Territory(safricaTerr, "South Africa"));
		
		this.continents.add(africa);
		
		// add Australia
		List<Territory> australia = new ArrayList<Territory>();
		
		// add Eastern Australia to Australia
		List<String> eaustraliaTerr = new ArrayList<String>();
		eaustraliaTerr.add("New Guinea");
		eaustraliaTerr.add("Western Australia");
		australia.add(new Territory(eaustraliaTerr, "Eastern Australia"));
		
		// add Indonesia to Australia
		List<String> indonesiaTerr = new ArrayList<String>();
		indonesiaTerr.add("New Guinea");
		indonesiaTerr.add("Western Australia");
		indonesiaTerr.add("Siam");
		australia.add(new Territory(indonesiaTerr, "Indonesia"));
		
		// add New Guinea to Australia
		List<String> newguineaTerr = new ArrayList<String>();
		newguineaTerr.add("Eastern Australia");
		newguineaTerr.add("Indonesia");
		newguineaTerr.add("Western Australia");
		australia.add(new Territory(newguineaTerr, "New Guinea"));
		
		// add Western Australia to Australia
		List<String> waustraliaTerr = new ArrayList<String>();
		waustraliaTerr.add("Eastern Australia");
		waustraliaTerr.add("Indonesia");
		waustraliaTerr.add("New Guinea");
		australia.add(new Territory(waustraliaTerr, "Western Australia"));
		
		this.continents.add(australia);
		
		// add Asia
		List<Territory> asia = new ArrayList<Territory>();
		
		// add Afghanistan to Asia
		List<String> afghanistanTerr = new ArrayList<String>();
		afghanistanTerr.add("China");
		afghanistanTerr.add("India");
		afghanistanTerr.add("Ukraine");
		afghanistanTerr.add("Middle East");
		afghanistanTerr.add("Ural");
		asia.add(new Territory(afghanistanTerr, "Afghanistan"));
		
		// add China to Asia
		List<String> chinaTerr = new ArrayList<String>();
		chinaTerr.add("Afghanistan");
		chinaTerr.add("India");
		chinaTerr.add("Mongolia");
		chinaTerr.add("Siam");
		chinaTerr.add("Siberia");
		chinaTerr.add("Ural");
		asia.add(new Territory(chinaTerr, "China"));
		
		// add India to Asia
		List<String> indiaTerr = new ArrayList<String>();
		indiaTerr.add("Afghanistan");
		indiaTerr.add("China");
		indiaTerr.add("Middle East");
		indiaTerr.add("Siam");
		asia.add(new Territory(indiaTerr, "India"));
		
		// add Irkutsk to Asia
		List<String> irkutskTerr = new ArrayList<String>();
		irkutskTerr.add("Kamchatka");
		irkutskTerr.add("Mongolia");
		irkutskTerr.add("Siberia");
		irkutskTerr.add("Yakutsk");
		asia.add(new Territory(irkutskTerr, "Irkutsk"));
		
		// add Japan to Asia
		List<String> japanTerr = new ArrayList<String>();
		japanTerr.add("Kamchatka");
		japanTerr.add("Mongolia");
		asia.add(new Territory(japanTerr, "Japan"));
		
		// add Kamchatka to Asia
		List<String> kamchatkaTerr = new ArrayList<String>();
		kamchatkaTerr.add("Alaska");
		kamchatkaTerr.add("Irkutsk");
		kamchatkaTerr.add("Japan");
		kamchatkaTerr.add("Mongolia");
		kamchatkaTerr.add("Yakutsk");
		asia.add(new Territory(kamchatkaTerr, "Kamchatka"));
		
		// add Middle East to Asia
		List<String> middleeastTerr = new ArrayList<String>();
		middleeastTerr.add("Afghanistan");
		middleeastTerr.add("East Africa");
		middleeastTerr.add("India");
		middleeastTerr.add("Egypt");
		middleeastTerr.add("Southern Europe");
		middleeastTerr.add("Ukraine");
		asia.add(new Territory(middleeastTerr, "Middle East"));
		
		// add Mongolia to Asia
		List<String> mongoliaTerr = new ArrayList<String>();
		mongoliaTerr.add("China");
		mongoliaTerr.add("Irkutsk");
		mongoliaTerr.add("Japan");
		mongoliaTerr.add("Kamchatka");
		mongoliaTerr.add("Siberia");
		asia.add(new Territory(mongoliaTerr, "Mongolia"));
		
		// add Siam to Asia
		List<String> siamTerr = new ArrayList<String>();
		siamTerr.add("Indonesia");
		siamTerr.add("China");
		siamTerr.add("India");
		asia.add(new Territory(siamTerr, "Siam"));
		
		// add Siberia to Asia
		List<String> siberiaTerr = new ArrayList<String>();
		siberiaTerr.add("China");
		siberiaTerr.add("Irkutsk");
		siberiaTerr.add("Mongolia");
		siberiaTerr.add("Ural");
		siberiaTerr.add("Yakutsk");
		asia.add(new Territory(siberiaTerr, "Siberia"));
		
		// add Ural to Asia
		List<String> uralTerr = new ArrayList<String>();
		uralTerr.add("Afghanistan");
		uralTerr.add("China");
		uralTerr.add("Ukraine");
		uralTerr.add("Siberia");
		asia.add(new Territory(uralTerr, "Ural"));
		
		// add Yakutsk to Asia
		List<String> yakutskTerr = new ArrayList<String>();
		yakutskTerr.add("Irkutsk");
		yakutskTerr.add("Kamchatka");
		yakutskTerr.add("Siberia");
		asia.add(new Territory(yakutskTerr, "Yakutsk"));
		
		this.continents.add(asia);
		
		// add Europe
		List<Territory> europe = new ArrayList<Territory>();
		
		// add Great Britain to Europe
		List<String> gbTerr = new ArrayList<String>();
		gbTerr.add("Iceland");
		gbTerr.add("Northern Europe");
		gbTerr.add("Scandinavia");
		gbTerr.add("Western Europe");
		europe.add(new Territory(gbTerr, "Great Britain"));
		
		// add Iceland to Europe
		List<String> icelandTerr = new ArrayList<String>();
		icelandTerr.add("Great Britain");
		icelandTerr.add("Scandinavia");
		icelandTerr.add("Greenland");
		europe.add(new Territory(icelandTerr, "Iceland"));
		
		// add Northern Europe to Europe
		List<String> neuropeTerr = new ArrayList<String>();
		neuropeTerr.add("Great Britain");
		neuropeTerr.add("Scandinavia");
		neuropeTerr.add("Southern Europe");
		neuropeTerr.add("Ukraine");
		neuropeTerr.add("Western Europe");
		europe.add(new Territory(neuropeTerr, "Northern Europe"));
		
		// add Scandinavia to Europe
		List<String> scandinaviaTerr = new ArrayList<String>();
		scandinaviaTerr.add("Great Britain");
		scandinaviaTerr.add("Iceland");
		scandinaviaTerr.add("Northern Europe");
		scandinaviaTerr.add("Ukraine");
		europe.add(new Territory(scandinaviaTerr, "Scandinavia"));
		
		// add Southern Europe to Europe
		List<String> seuropeTerr = new ArrayList<String>();
		seuropeTerr.add("Northern Europe");
		seuropeTerr.add("Egypt");
		seuropeTerr.add("North Africa");
		seuropeTerr.add("Ukraine");
		seuropeTerr.add("Western Europe");
		seuropeTerr.add("Middle East");
		europe.add(new Territory(seuropeTerr, "Southern Europe"));
		
		// add Ukraine to Europe
		List<String> ukraineTerr = new ArrayList<String>();
		ukraineTerr.add("Afghanistan");
		ukraineTerr.add("Northern Europe");
		ukraineTerr.add("Scandinavia");
		ukraineTerr.add("Southern Europe");
		ukraineTerr.add("Middle East");
		ukraineTerr.add("Ural");
		europe.add(new Territory(ukraineTerr, "Ukraine"));
		
		// add Western Europe to Europe
		List<String> weuropeTerr = new ArrayList<String>();
		weuropeTerr.add("Great Britain");
		weuropeTerr.add("Northern Europe");
		weuropeTerr.add("Southern Europe");
		weuropeTerr.add("North Africa");
		europe.add(new Territory(weuropeTerr, "Western Europe"));
		
		this.continents.add(europe);
		
		// add North America
		List<Territory> namerica = new ArrayList<Territory>();
		
		// add Alaska to North America
		List<String> alaskaTerr = new ArrayList<String>();
		alaskaTerr.add("Alberta");
		alaskaTerr.add("Northwest Territory");
		alaskaTerr.add("Kamchatka");
		namerica.add(new Territory(alaskaTerr, "Alaska"));
		
		// add Alberta to North America
		List<String> albertaTerr = new ArrayList<String>();
		albertaTerr.add("Alaska");
		albertaTerr.add("Northwest Territory");
		albertaTerr.add("Ontario");
		albertaTerr.add("Western United States");
		namerica.add(new Territory(albertaTerr, "Alberta"));

		// add Central America to North America
		List<String> camericaTerr = new ArrayList<String>();
		camericaTerr.add("Eastern United States");
		camericaTerr.add("Venezuela");
		camericaTerr.add("Western United States");
		namerica.add(new Territory(camericaTerr, "Central America"));

		// add Eastern United States to North America
		List<String> eusTerr = new ArrayList<String>();
		eusTerr.add("Central America");
		eusTerr.add("Ontario");
		eusTerr.add("Quebec");
		eusTerr.add("Western United States");
		namerica.add(new Territory(eusTerr, "Eastern United States"));

		// add Greenland to North America
		List<String> greenlandTerr = new ArrayList<String>();
		greenlandTerr.add("Iceland");
		greenlandTerr.add("Northwest Territory");
		greenlandTerr.add("Ontario");
		greenlandTerr.add("Quebec");
		namerica.add(new Territory(greenlandTerr, "Greenland"));

		// add Northwest Territory to North America
		List<String> nwterritoryTerr = new ArrayList<String>();
		nwterritoryTerr.add("Alaska");
		nwterritoryTerr.add("Alberta");
		nwterritoryTerr.add("Greenland");
		nwterritoryTerr.add("Ontario");
		namerica.add(new Territory(nwterritoryTerr, "Northwest Territory"));

		// add Ontario to North America
		List<String> ontarioTerr = new ArrayList<String>();
		ontarioTerr.add("Alberta");
		ontarioTerr.add("Eastern United States");
		ontarioTerr.add("Greenland");
		ontarioTerr.add("Northwest Territory");
		ontarioTerr.add("Quebec");
		ontarioTerr.add("Western United States");
		namerica.add(new Territory(ontarioTerr, "Ontario"));

		// add Quebec to North America
		List<String> quebecTerr = new ArrayList<String>();
		quebecTerr.add("Eastern United States");
		quebecTerr.add("Greenland");
		quebecTerr.add("Ontario");
		namerica.add(new Territory(quebecTerr, "Quebec"));

		// add Western United States to North America
		List<String> wusTerr = new ArrayList<String>();
		wusTerr.add("Alberta");
		wusTerr.add("Central America");
		wusTerr.add("Eastern United States");
		wusTerr.add("Ontario");
		namerica.add(new Territory(wusTerr, "Western United States"));
		
		this.continents.add(namerica);
		
		// add South America
		List<Territory> samerica = new ArrayList<Territory>();
		
		// add Argentina to South America
		List<String> argentinaTerr = new ArrayList<String>();
		argentinaTerr.add("Brazil");
		argentinaTerr.add("Peru");
		samerica.add(new Territory(argentinaTerr, "Argentina"));

		// add Brazil to South America
		List<String> brazilTerr = new ArrayList<String>();
		brazilTerr.add("Argentina");
		brazilTerr.add("Peru");
		brazilTerr.add("Venezuela");
		brazilTerr.add("North Africa");
		samerica.add(new Territory(brazilTerr, "Brazil"));

		// add Peru to South America
		List<String> peruTerr = new ArrayList<String>();
		peruTerr.add("Argentina");
		peruTerr.add("Brazil");
		peruTerr.add("Venezuela");
		samerica.add(new Territory(peruTerr, "Peru"));

		// add Venezuela to South America
		List<String> venezuelaTerr = new ArrayList<String>();
		venezuelaTerr.add("Brazil");
		venezuelaTerr.add("Peru");
		venezuelaTerr.add("Central America");
		samerica.add(new Territory(venezuelaTerr, "Venezuela"));
		
		this.continents.add(samerica);
	}
	
	/**
	 * initPlayers() initialises the list of Players
	 */
	private void initPlayers() {
		// read in number of Players
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("How many players are there?");
			int numPlayers = 0;
			Boolean valid = false;
			// ensure valid input
			while (!valid) {
				numPlayers = Integer.parseInt(scan.next());
				if (1 < numPlayers && numPlayers < 6) {
					valid = true;
				}
				else {
					System.out.println("Please enter a valid number of players (2-6).");
				}
			}
			
			// read in Player names
			System.out.println("What are your names?");
			for (int i = 0; i < numPlayers; i++) {
				String name = scan.nextLine();
				this.players.add(new Player(name));
			}
		}
	}
	
	/**
	 * init() initialises the game by setting up the Territories and Players
	 */
	public void init() {
		// Initialise Territories
		initContinents();
		initPlayers();
			
		//TODO shuffle Player turn order
		
		while (this.players.get(this.turn).isEliminated()) {
			if (this.turn >= this.players.size()) {
				this.turn = 0;
			}
			else {
				this.turn++;
			}
		}
		
		System.out.println("It is " + this.players.get(this.turn).getName()
				+ "'s turn.");
		
		//TODO write body
		// Prompt attack or pass
		// init attack
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
//	public List<Player> getActivePlayers() {
//		return this.activePlayers;
//	}

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
//	public void addActivePlayer(Player p) {
//		this.activePlayers.add(p);
//	}

	/**
	 * addPlayer(p) adds p to list of Players
	 */
	public void addPlayer(Player p) {
		this.players.add(p);
	}

	/**
	 * removeActivePlayer(p) removes p from list of active Players
	 */
//	public void removeActivePlayer(Player p) {
//		this.activePlayers.remove(p);
//	}

	/**
	 * removePlayer(p) removes p from list of Players
	 */
	public void removePlayer(Player p) {
		this.players.remove(p);
	}

}
