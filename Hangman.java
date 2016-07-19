/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;


import java.awt.*;

public class Hangman extends ConsoleProgram {

	/** number of lives */
	private static final int LIVES_NUMBER = 30;

    public void run() {
    	lexicon = new HangmanLexicon();
    	setInitialState();
    	playGame();
    	
		/* You fill this in */
	}

    /**
     * sets an initial state of the hangman
     */
    private void setInitialState(){
    	printExplanationMessage();
    	
    }
    
    private void printExplanationMessage(){
    	println("Hangman is a game in which you have to guess a word chosen by the program");
    	println("You do it by making a guess of letters that may be inside the word marked by _");
    	println("The number of _ is the exact number of letters that appears in this word");
    	println("Every time you guess an approperiate letter, it gets displayed on the screen in all the palces it appears in the word");
    	println("If you make a guess letter that is not inside the word, you lose one live and are closer to hanging");
    	println("Once you run out of lives you are hanged. You have " + LIVES_NUMBER + " of lives");
    	println("Good luck !!");
    	println("");
    }
    
    private void playGame(){
    	while(!endGameRequest){
	    	pickOneWord();
	    	while (!gameOver()){
	    		guessLetterOrWord();
	    		checkIfInTheWord();
	    		putLetterInTheWord();
	    		printTheWord();    		
	    	}
    	}
    }
    
    private void gameOver(){
    	if (lives == 0) gameOver = true;
    }
    
    private void pickOneWord(){
 
    	int pickWordNumber = rgen.nextInt(0, lexicon.getWordCount());
    	word = lexicon.getWord(pickWordNumber);
    }
    
    /**
     * prompts to type the guess letter or word, checks if it is approperiate and changes the guessWord or guessLetter
     */
    private void guessLetterOrWord(){
    	String currentGuessString = readLine("Please type a guess letter or a guess word");
    	
    	
    }
    
    RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanLexicon lexicon;
    private static char guessLetter;
    private static String word, guessWord;
    private static boolean endGameRequest = false, gameOver = false;
    private static int lives = LIVES_NUMBER;
}
