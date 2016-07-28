/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.*;

import acm.util.*;
import acm.program.*;

public class HangmanLexicon extends ConsoleProgram{
		// This is the HangmanLexicon constructor
		public HangmanLexicon() {

		}

		public void run(){
		BufferedReader rd = openFile("Please enter filename");
		
		try {
			while (true){
				String line = rd.readLine();
				if (line == null) break;
				println("Read line: [" + line + "]");
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	// your initialization code goes here
	}		
		
		private BufferedReader openFile(String prompt){
			BufferedReader rd = null;
			while (rd == null){
				try {
					String filename = readLine(prompt);
					rd = new BufferedReader( new FileReader(filename));
				} catch (IOException ex) {
					println("bad file");
				}
			}
			return rd;
		}
		
		
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	};
}
