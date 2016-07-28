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
	public void noteIncorrectGuess(String charactersAlreadyTyped) {
		int livesLeft = Hangman.getLivesNumber() * (Hangman.getLivesNumber() / 8 + 1);
		System.out.println(livesLeft);
		switch (livesLeft) {
		case 7: printHead();
			break;
		case 6: printNeck();
			break;
		case 5: printLeftArm();
			break;
		case 4: printRightArm();
			break;
		case 3: printBody();
			break;
		case 2: printLeftLeg();
			break;
		case 1: printRightLeg();
			break;
		default: break;
		}
		
		printProbeCharacters(charactersAlreadyTyped);
	}
	
	private void printFirstPicture(){
		printScaffold();
		printBeam();
		printRope();
	}
	
	private void printScaffold(){
		double x0 = (getWidth()-BEAM_LENGTH - UPPER_ARM_LENGTH) /2;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 ;


		GLine scaffold = new GLine(x0, y0, x0, y0 + SCAFFOLD_HEIGHT);
		add(scaffold);
	}
	
	private void printBeam(){
		double x0 = (getWidth()-BEAM_LENGTH - UPPER_ARM_LENGTH) /2;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2;
		GLine beam = new GLine(x0, y0, x0 + BEAM_LENGTH, y0);
		add(beam);
	}
	
	private void printRope(){
		double x0 = BODY_MIDDLE_X;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2;
		GLine rope = new GLine(x0, y0, x0, y0 + ROPE_LENGTH);
		add(rope);
	}
	
	private void printHead(){
		int x = BODY_MIDDLE_X - HEAD_RADIUS;
		int y = (getHeight()-SCAFFOLD_HEIGHT)/2;
		GOval head = new GOval(x, y, 2*HEAD_RADIUS, 2*HEAD_RADIUS);
		add(head);
	}
	
	private void printNeck(){
		double x0 = BODY_MIDDLE_X;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS;
		GLine neck = new GLine(x0, y0, x0, y0 + ARM_OFFSET_FROM_HEAD);
		add(neck);
	}
	
	private void printLeftArm(){
		
		double x0_Horizontal = BODY_MIDDLE_X;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD;
		printHorizontalArm(x0_Horizontal, y0, -1);
		double x0_Vertical = BODY_MIDDLE_X - UPPER_ARM_LENGTH;
		printVerticalArm(x0_Vertical, y0);
	}
	
	private void printRightArm(){
		
		double x0_Horizontal = BODY_MIDDLE_X;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD;
		printHorizontalArm(x0_Horizontal, y0, 1);
		double x0_Vertical = BODY_MIDDLE_X + UPPER_ARM_LENGTH;
		printVerticalArm(x0_Vertical, y0);
	}
	
	private void printHorizontalArm(double x0, double y0, int armDirection){
		GLine armHorizontal = new GLine(x0, y0, x0 + armDirection * UPPER_ARM_LENGTH, y0 );
		add(armHorizontal);
	}
	
	private void printVerticalArm(double x0, double y0){
		GLine armVertical = new GLine(x0, y0, x0, y0 - LOWER_ARM_LENGTH);
		add(armVertical);
	}
	
	private void printBody(){
		int x0 = BODY_MIDDLE_X;
		int y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD ;
		GLine body = new GLine(x0, y0, x0, y0 + BODY_LENGTH);
		add(body);
	}
	
	private void printLeftLeg(){
		
		double x0_Horizontal = BODY_MIDDLE_X;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + BODY_LENGTH;
		printHorizontalLeg(x0_Horizontal, y0, -1);
		double x0_Vertical = BODY_MIDDLE_X - HIP_WIDTH;
		printVerticalLeg(x0_Vertical, y0);
		double y0_Foot = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + BODY_LENGTH + LEG_LENGTH;
		printFoot(x0_Vertical, y0_Foot, -1);
	}
	
	private void printRightLeg(){
		
		double x0_Horizontal = BODY_MIDDLE_X;
		double y0 = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + BODY_LENGTH;
		printHorizontalLeg(x0_Horizontal, y0, 1);
		double x0_Vertical = BODY_MIDDLE_X + HIP_WIDTH;
		printVerticalLeg(x0_Vertical, y0);
		double y0_Foot = (getHeight()-SCAFFOLD_HEIGHT)/2 + 2*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + BODY_LENGTH + LEG_LENGTH;
		printFoot(x0_Vertical, y0_Foot, 1);
	}
	
	private void printHorizontalLeg(double x0, double y0, int hipDirection){
		GLine hip = new GLine(x0, y0, x0 + hipDirection * HIP_WIDTH, y0 );
		add(hip);
	}
	
	private void printVerticalLeg(double x0, double y0){
		GLine leg = new GLine(x0, y0, x0, y0 - LEG_LENGTH);
		add(leg);
	}
	
	private void printFoot(double x0, double y0, int footDirection){
		GLine foot = new GLine(x0, y0, x0 + footDirection * FOOT_LENGTH, y0 );
		add(foot);
	}
	
	
	private void printProbeCharacters(String charactersAlreadyTyped){
		
		if (charactersTyped != null) remove(charactersTyped);
		charactersTyped = new GLabel("Characters already guessed are: " + charactersAlreadyTyped);
		double labelWidth = charactersTyped.getWidth();
		double labelAscent = charactersTyped.getAscent();
		charactersTyped.setLocation( (getWidth()-labelWidth) / 2 ,
				getHeight() - 50 + labelAscent);		
		add(charactersTyped);
	}
	
	public void initSize(){
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
	}
	
/*label with guess characters*/
	GLabel charactersTyped = null;



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

/*canvas size*/
	private static final int CANVAS_HEIGHT = BEAM_LENGTH + UPPER_ARM_LENGTH + 200;
	private static final int CANVAS_WIDTH = SCAFFOLD_HEIGHT + 200;

/*middle x of the body */
	private final int BODY_MIDDLE_X = (getWidth() - UPPER_ARM_LENGTH) /2 + BEAM_LENGTH;

}
