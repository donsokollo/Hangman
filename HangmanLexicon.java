/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.*;
import java.util.ArrayList;

import acm.util.*;
import acm.program.*;

public class HangmanLexicon {
		// This is the HangmanLexicon constructor

	
	
public HangmanLexicon() {
	makeAnArray();
	
}	

public void makeAnArray(){
	BufferedReader rd = openFile("Please enter filename: ");
	try {
		while (true){
			String line = rd.readLine();
			if (line == null) break;

			arrayOfWords.add(line);
		}
		rd.close();
	} catch (IOException ex) {
		throw new ErrorException(ex);
	}
}
		
		private BufferedReader openFile(String prompt){
			BufferedReader rd = null;
			while (rd == null){
				try {
					String filename = "HangmanLexicon.txt"; /*only a workaround of the problem that cannot ask readLine here?*/
					rd = new BufferedReader( new FileReader(filename));
				} catch (IOException ex) {
					System.out.println("Wrong name");
				}
			}
			return rd;
		}
		
		
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		/*new HangmanLexicon();*/
		return arrayOfWords.size();
	}

/** Returns the word at the specified index. */
	/* public String getWord(int index) {
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
	REIMPLEMENTED */
	public String getWord(int index){
		return arrayOfWords.get(index);
	}

private ArrayList<String> arrayOfWords = new ArrayList<String>();	
}

