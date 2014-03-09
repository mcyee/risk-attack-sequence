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

### *public class* Card

#### variables

* **name** String
    * name of this Card
* **stars** int
    * number of stars on this Card, max 2
* **territory** String
    * Territory depicted on this Card
* **unit** String
    * type of unit depicted on this Card (one of soldier, cavalry, artillery)

#### constructors

#### methods

##### getters

##### setters

---

### *public class* Continent

#### variables

#### constructors

#### methods

##### getters

##### setters

---

### *public class* Die

#### variables

* **faces** int
    * number of faces on this Die
* **value** int
    * current rolled value of this Die

#### constructors:

* (f)
    * **faces** = f
    * **value** = 1
        * *defaults to 1*

#### methods

##### getters
* **getFaces** int
    * returns number of faces on this Die
* **getValue** int
    * returns the current rolled value of this Die

##### setters
* **rollDie** int
    * rolls this Die and returns its new rolled value

---

### *public class* Player

#### variables
* **bonusArmies** int
    * number of bonus Armies this Player holds from Continents occupied
* **cards** Card[]
    * Cards that this Player holds
* **occContinents** Continent[]
    * Continents that this Player is currently occupying
* **occTerritories** Territory[]
    * Territories that this Player is currently occupying

#### constructors
* (b, c, n, o)
    * **bonusArmies** = b
    * **cards** = c
    * **occContinents** = n
    * **occTerritories** = o

#### methods

##### getters
* **getBonusArmies** int
    * returns number of bonus armies earned from Continent occupancy
* **getCards** Card[]
    * returns array of Cards that this Player holds
* **getOccContinents** Continent[]
    * returns array of Continents this Player occupies
* **getOccTerritories** Territory[]
    * returns array of Territories that this Player occupies

##### setters
* **addArmies** void
    * adds given number of armies to bonusArmies
* **addCard** void
    * adds given Card to this Player's array of Cards
* **addContinent**
* **removeArmies** void
    * removes given number of armies from bonusArmies
    * cannot result in negative integer
* **removeCards** void
    * removes given Cards from this Player's array of Cards

---

### *public class* Territory

#### variables
* **adjacent** String[]
    * adjacent Territories
* **armies** int
    * number of armies occupying this Territory
* **name** String
    * name of this Territory
* **occPlayer** String
        * currently occupying Player

#### constructors
* (t, a, n, o)
    * **adjacent** = t
    * **armies** = a
    * **name** = n
    * **occPlayer** = o

#### methods

##### getters
* **getAdjacent** String[]
    * returns array of adjacent Territories
* **getArmies** int
    * returns number of armies occupying this Territory
* **getName** String
    * returns name of this Territory
* **getOccPlayer** String
    * returns currently occupying Player of this Territory
        
##### setters
* **attack** int[]
    * attacks given Territory from this Territory with given number of armies
    * returns array of sorted Dice values
* **changeArmies** void
    * updates number of armies occupying this Territory
* **changeOccPlayer** void
    * updates currently occupying Player of this Territory