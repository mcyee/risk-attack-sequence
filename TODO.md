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

* If attacker wins, attacker occupies Territory with remaining attacking armies
    * Prompt attacker to move more forces into new Territory or not
        * Must be from attacking Territory
        * Must leave at least one army in attacking Territory
    * Draw card
* If defender loses and has no more Territories left, defender is eliminated


## Classes

### *public class* GameState



**setters**

* `startGame` void
    * initialises game, sets up Territories and Players
