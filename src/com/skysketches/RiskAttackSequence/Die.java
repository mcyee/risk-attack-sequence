/**
 * Author: Ming-Cee Yee
 * Date Created: 2014-03-09
 * Description: Provides Dice to roll.
 */

package com.skysketches.RiskAttackSequence;

import java.util.Random;

public class Die {
	//--VARIABLES---------------------------------------------------------------

	private Random rand;
	private int faces; // number of faces
	private int value; // current rolled value


	//--CONSTRUCTORS------------------------------------------------------------

	// `f`-faced Die
	public Die(int f) {
		this.faces = f;
		this.value = 1; // default value
	}

	// 6-faced Die
	public Die() {
		this(6);
	}


	//--METHODS-----------------------------------------------------------------

	//--getters--

	/**
	 * getFaces() returns `faces`
	 */
	public int getFaces() {
		return this.faces;
	}

	/**
	 * getValue() returns `value`
	 */
	public int getValue() {
		return this.value;
	}


	//--setters--

	/**
	 * roll() rolls Die and returns the rolled value
	 */
	public int roll() {
		value = rand.nextInt(6) + 1;
		return value;
	}

	/**
	 * rollDice(d, n) rolls the Die `n` times and returns the rolled values
	 * PRE: n > 0
	 */
	public int[] rollDice(int n) {
		// TODO write guard
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = roll();
		}

		return a;
	}

}
