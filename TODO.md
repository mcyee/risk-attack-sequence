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

### *public class* GameState

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

### *public class* Territory

#### methods

**setters**

* `addArmies` void
    * increases number of armies occupying this Territory by given number
* `attack` int[]
    * attacks given Territory from this Territory with given number of armies
    * returns array of sorted Dice values
    * change to do full attack comparison
* `changeOccPlayer` void
    * updates currently occupying Player of this Territory
* `defend` int[]
    * defends this Territory with given number of armies
    * returns array of sorted Dice values
* `removeArmies` void
    * decreases number of armies occupying this Territory by given number