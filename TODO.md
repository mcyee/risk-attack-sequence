# TODO

Provides outline/planning for risk-attack-sequence.

## Classes

### *public class* Die

#### variables

* **faces** int
    - number of faces on this Die
* **value** int
    - current rolled value of this Die

#### constructors:

* (f)
    * **faces** = f
    * **value** = 1
        - *defaults to 1*

#### methods

##### getters
* **getFaces** int
    - returns number of faces on this Die
* **getValue** int
    - returns the current rolled value of this Die

##### setters
* **rollDie** int
    - rolls this Die and returns its new rolled value


---

### *public abstract class* Player

#### variables
* **cards** Card[]
    - Cards that this Player holds
* **occupiedLand** String[]
    - Territories that this Player is currently occupying

#### constructors
* 

#### methods
* 

---

### *public class* HumanPlayer *extends* Player

#### variables
* 

#### constructors
* 

#### methods
* 

---

### *public class* BotPlayer *extends* Player

#### variables
* 

#### constructors
* 

#### methods
* 

---

### *public class* Territory

#### variables
* **adjacent** String[]
    - adjacent Territories
* **armies** int
    - number of armies occupying this Territory
* **name** String
    - name of this Territory
* **occPlayer** String
        - currently occupying Player

#### constructors
* (t, a, n, o)
    * **adjacent** = t
    * **armies** = a
    * **name** = n
    * **occPlayer** = o

#### methods

##### getters
* **getAdjacent** String[]
    - returns array of adjacent Territories
* **getArmies** int
    - returns number of armies occupying this Territory
* **getName** String
    - returns name of this Territory
* **getOccPlayer** String
    - returns currently occupying Player of this Territory
        
##### setters
* **changeArmies** void
    - updates number of armies occupying this Territory
* **changeOccPlayer** void
    - updates currently occupying Player of this Territory