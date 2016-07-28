/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		
		removeAll();
		printFirstPicture();
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}
	
	private void printFirstPicture(){
		printScaffold();
		printBeam();
		printRope();
	}
	
	private void printScaffold(){
		double x0 = ((getWidth()-BEAM_LENGTH - UPPER_ARM_LENGTH) *3/4);
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2;
		GLine scaffold = new GLine(x0, y0, x0, y0 + SCAFFOLD_HEIGHT);
		add(scaffold);
	}
	
	private void printBeam(){
		double x0 = ((getWidth()-BEAM_LENGTH - UPPER_ARM_LENGTH) *3/4);
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 + SCAFFOLD_HEIGHT;
		GLine beam = new GLine(x0, y0, x0 + BEAM_LENGTH, y0);
		add(beam);
	}
	
	private void printRope(){
		double x0 = ((getWidth() - UPPER_ARM_LENGTH) *3/4) + BEAM_LENGTH / 2;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2  + SCAFFOLD_HEIGHT;
		GLine rope = new GLine(x0, y0, x0, y0 + ROPE_LENGTH);
		add(rope);
	}
	

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
