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
	private static final int LIVES_NUMBER = 5;

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
	    	setTheCurrentWordtoGuess();
	    	while (!gameOver){
	    		
	    		promptForWord();
	    		checkTypeOfInput();
	    		actOnInputLetter();
	    		if (gameWon) break;
	    		checkIfGameOver();
	    		printTheGuessWord();   
	    		
	    	}
	    	printEndStatement();
	    	setForTheNextGame();
	    	askIfAnotherGame();
	    	
    	}
    }
    
    /**
     * If char is input, checks if it is in word and print on screen
     * If word is put, checks if approperiate word is guessed if so, ends the game
     * If all letters found ends the game
     */

    private void actOnInputLetter(){
    	if (checkIfApproperiate().equals("Char")){
    		putLetterInTheWord(checkIfCharInWord());
    		checkIfAllLettersFound();
    		
		} else if (checkIfApproperiate().equals("Word")){
			checkIfProperGuessOfWord();
		}
    }
    
    /**
     * sets the parameters ready for the next game
     */
    private void setForTheNextGame(){
    	gameWon = false;
    	gameOver = false;
    	charTyped = "";
    	word = "";
    	currentWordToGuess = "";
    	lettersLeftToGuess = 0;
    	
    }
    private void checkIfGameOver(){
    	if (lives == 0 || gameWon) {
    		gameOver = true;
    		lives = LIVES_NUMBER;
    	}
    	
    }
    
    private void askIfAnotherGame(){
    	println("Do You want to have another game?");
    	println("Yes or No?");
    	String y = readLine("");
    	while (!y.equals("Yes") && !y.equals("No")){
    		y = readLine("Type Yes or No: ");
    	}
    	if (y.equals("No")) endGameRequest = true;
    }
    
    /**
     * picks  one word from the chosen source and places it in field word
     */
    private void pickOneWord(){
 
    	int pickWordNumber = rgen.nextInt(0, lexicon.getWordCount()-1);
    	word = lexicon.getWord(pickWordNumber);
    	lettersLeftToGuess = word.length();
    }
    
    /**
     * sets the currentWordToGuess as approperiate number of underscores each followed by space
     *REMEMBER THAT TO CHANGE BACKSLASH YOU MUST REFER TO BACKSLASH SEPARATED BY A SPACE!
     */
    private void setTheCurrentWordtoGuess(){
    	for (int i=0; i < word.length(); i++){
    		currentWordToGuess += "_ ";
    	}
    	
    }
    
    /**
     * checks if the typed input is approperiate for the game
     * and changes the guessWord or guessLetter to store the processed Word/Character
     * or throws an exception if inapproperiate input
     */
    private void checkTypeOfInput(){

    	
    	
    	if (checkIfApproperiate().equals("Inapproperiate")){
    		throwException();
    	} else if (checkIfApproperiate().equals("Char")){
    		convertToChar();
    	} else if (checkIfApproperiate().equals("Word")){
    		guessWord = currentGuessString;
    	}    	
    }
/**
 * informs the user that he typed an inapproperiate data type
 * and instructs what input is correct
 */
    private void throwException(){
    	println("Inapproperiate input");
    	println("Please write only a character or a whole word without numbers, special letters or spaces");
    }
   
    /**
     * assigns the guessed character to a guessLetter
     */
    private void convertToChar(){
    	guessLetter = currentGuessString.charAt(0);
    }
    
    /**
     * Assign the typed word to the currentGuessString
     */
    private void promptForWord(){
    	println("Letters already used are: " + charTyped);
    	println("Lives left " + lives);
    	/*println("the word is "+ word);*/
    	currentGuessString = readLine("Please type a guess letter or a guess word: ");
    	
    }

    /**
     * checks if the typed string is approperiate for the given job (is a letter or a string)
     * @return "Word" if an approperiate word, "Char" if an approperiate char and "Inapproperiate" if wrong input
     */
    private String checkIfApproperiate(){
    	if (currentGuessString.length() == 1){
    		char firstChar = currentGuessString.charAt(0);
    		if (Character.isLetter(firstChar)) return "Char";
    	} else if(haveOnlyLetters()){
    		return "Word";
    	} 
    	return "Inapproperiate";
    }
 
    /**
     * checks if the typed string has only letters
     * @return true if yes, false if no
     * preconditions: currentGuessString is a string
     */
    private boolean haveOnlyLetters(){
    	for (int i =0; i < currentGuessString.length(); i++){
    		char currentChar = currentGuessString.charAt(i);
    		if (!Character.isLetter(currentChar)) {
    			return false;
    		}
    	}
    	return true ;
    }
    
    /**
     * checks if the picked character is within the word
     * @return boolean
     */
    private boolean checkIfCharInWord(){
    	for (int i = 0; i < word.length(); i++)
    	if (word.charAt(i) == guessLetter) return true;
    return false;
    }
    
    /**
     * Replaces the guessLetter in every place in the currentWordToGuess 
     * that it appears in the word (to guess)
     * Puts the typed char into a charTyped
     * Reduces lettersLeftToGuess by 1
     * @param charInWord (boolean) specifies if the guessed character is in the word
     */
    private void putLetterInTheWord(boolean charInWord){
    	if (charInWord){	
    		for (int i = 0; i < word.length(); i++)
    	    	if (word.charAt(i) == guessLetter){
    	    		lettersLeftToGuess--;
    	    		currentWordToGuess = currentWordToGuess.substring(0, i*2) 
    	    				+ guessLetter + " " + currentWordToGuess.substring(i*2+2);
    	    	}
    	} else if (!letterAlreadyTyped()){
    		lives--;
    		println("You entered a wrong character");
    		println("");
    	}
    	charTyped+=guessLetter;
    }
    
    /**
     * checks if the letter typed was already typed beforehand
     * @return true or false
     */
    private boolean letterAlreadyTyped(){
    	
  
	    for (int i = 0; i < charTyped.length(); i++){
			if (charTyped.charAt(i) == guessLetter){
				println("Letter already checked");
				println("");
	    		return true;
			}
	    }
	    return false;
	}
    /**
     * checks if the game is won. If so, changes gameWon to true.
     * If not takes off a life (the guess word was not proper)
     */
    private void checkIfProperGuessOfWord(){
    	if (guessWord.equals(word)) {
    		gameWon = true;
    	}
    	else {
    		lives--;
    		println("You entered a wrong word");
    		println("");
    	}
    }
    
    /**
     * prints the current state of the word to guess in the statement
     */
    private void printTheGuessWord(){
    	println("The current state of guess is: " + currentWordToGuess);
    }
    
    /**
     * prints the ending statement on the screen
     * either winning or losing one
     */
    private void printEndStatement(){
    	if (gameOver){
    		println("You Lose");
    		
    	} else if (gameWon){
    		println("Congratulations");
    		println("YOU WON !!!!");
    	}
    	println("To play again hit spacebar");
		println("");
    }
    
    private void checkIfAllLettersFound(){
    	if (lettersLeftToGuess == 0) gameWon = true;
    }
    
    
    
    RandomGenerator rgen = RandomGenerator.getInstance();
    
    private HangmanLexicon lexicon;
    private static char guessLetter;
    
    /**
     * word - word to be guessed, 
     * currentWordToGuess - word that is typed as an input
     * guessWord - word that is typed as an input, 
     * currentGuessString - string recently typed as an input
     * charTyped - a string with all the characters previously typed during the game
     */
    private static String word, currentWordToGuess = "", guessWord = "", currentGuessString = "", charTyped = "";
    private static boolean endGameRequest = false, gameOver = false, gameWon=false;
    private static int lives = LIVES_NUMBER, lettersLeftToGuess = 0;
}
