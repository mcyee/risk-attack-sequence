# TODO

Provides outline/planning for risk-attack-sequence.


## Implementation

* Initialise game
    * Set up Territories and Players
* Set turn and prompt Player to attack or pass
* Initialise attack
    * Set attacker and defender
* Prompt attacker for Territory to attack from
* Prompt attacker for Territory to attack
* Prompt attacker for number of armies to attack with
    * Set number of attacking Dice, max 3 or number of available attacking 
      armies if less than 3
* Prompt defender for number of armies to defend with
    * Set number of defending Dice, max 2 or 1 if only one army in defending 
      Territory
* Roll Dice and sort from highest to lowest
* Compare highest of attacking Dice with highest of defending Dice
    * Higher Die roll wins, tie goes to defender
    * Remove one army from losing Player's Territory
    * Repeat until one Player loses all their armies
* If attacker wins, attacker occupies Territory with remaining attacking armies
    * Update Territory's occupying Player, update both Player's list of 
      Territories
    * Prompt attacker to move more forces into new Territory or not
        * Must be from attacking Territory
        * Must leave at least one army in attacking Territory
    * Draw card
* If defender loses and has no more Territories left, defender is eliminated


## Classes

### *public class* Die

#### variables

* `faces` int
    * number of faces on this Die
* `value` int
    * current rolled value of this Die

#### constructors:

* (f)
    * `faces` = f
    * `value` = 1
        * *defaults to 1*

#### methods

**getters**

* `getFaces` int
    * returns `faces`
* `getValue` int
    * returns `value`

**setters**

* `rollDie` int
    * rolls Die and returns its new `value`

---

### *public class* GameState

#### variables

* `AFRICA` const int
    * 0
* `ASIA` const int
    * 1
* `AUSTRALIA` const int
    * 2
* `EUROPE` const int
    * 3
* `NORTH_AMERICA` const int
    * 4
* `SOUTH_AMERICA` const int
    * 5
* `activePlayers` ArrayList<Player>
    * Players still in the game
* `continentBonus` int[]
    * bonus from occupying continents, index is given continent
* `continents` ArrayList<ArrayList<Territory>>
    * Territories in each continent, index is given continent
* `players` ArrayList<Player>
    * Players in the game

#### constructors

* (ap, cb, c, p, t)
    * `activePlayers` = ap
    * `continentBonus` = cb
    * `continents` = c
    * `players` = p

#### methods

**getters**

* `getActivePlayers` ArrayList<Player>
    * returns `activePlayers`
* `getContinentBonus` int
    * returns bonus awarded for given continent
* `getContinents` ArrayList<ArrayList<Territory>>
    * returns `continents`
* `getContinentOcc` String
    * returns name of Player who owns given continent
* `getPlayers` ArrayList<Player>
    * returns `players`

**setters**

* `addActivePlayer` void
    * adds given Player to `activePlayers`
* `addPlayer` void
    * adds given Player to `players`
* `removeActivePlayer` void
    * removes given Player from `activePlayers`
* `removePlayer` void
    * removes given Player from `players`

---

### *public class* Player

#### variables

* `cards` ArrayList<Card>
    * Cards that this Player holds
* `occTerritories` int
    * number of Territories this Player is occupying

#### constructors

* (c, o)
    * `cards` = c
    * `occTerritories` = o

#### methods

**getters**

* `getCards` ArrayList<Card>
    * returns `cards`
* `getOccTerritories` int
    * returns `occTerritories`
* `isEliminated` bool
    * checks if this Player has been eliminated from the game

**setters**

* `addCard` void
    * adds given Card to `cards`
* `addTerritory` void
    * increments number of occupied Territories
* `removeCards` void
    * removes given Cards from `cards`
* `removeTerritory` void
    * decrements number of occupied Territories

---

### *public class* Territory

#### variables

* `adjacent` ArrayList<String>
    * adjacent Territories that can be attacked/defended from
* `armies` int
    * number of armies occupying this Territory
* `name` String
    * name of this Territory
* `occPlayer` String
        * currently occupying Player

#### constructors

* (t, a, n, o)
    * `adjacent` = t
    * `armies` = a
    * `name` = n
    * `occPlayer` = o

#### methods

**getters**

* `getAdjacent` ArrayList<String>
    * returns `adjacent`
* `getArmies` int
    * returns `armies`
* `getName` String
    * returns `name`
* `getOccPlayer` String
    * returns `occPlayer`

**setters**

* `addArmies` void
    * increases number of armies occupying this Territory by given number
* `attack` int[]
    * attacks given Territory from this Territory with given number of armies
    * returns array of sorted Dice values
* `changeOccPlayer` void
    * updates currently occupying Player of this Territory
* `defend` int[]
    * defends this Territory with given number of armies
    * returns array of sorted Dice values
* `removeArmies` void
    * decreases number of armies occupying this Territory by given number