// Name: Sai Kiran Vadlamudi		Username: svadlamudi		Section: B01
// Name: Marilda Bozdo				Username: mbozdo			Section: B06

import tester.Tester;

/**
 * The Examples Class provides a way to create examples to test the code
 * with the help of the Tester Library
 */
public class Examples {
	
	/**
	 * Default Constructor for Examples
	 */
	Examples(){}
	
	/**
	 * Returns True if all the code works along specification
	 * 
	 * @param t
	 * @return boolean
	 */
	boolean testLCS(Tester t){
		return t.checkExpect(new LongestCommonSubsequence("", "").lcs(), "") &&
				t.checkExpect(new LongestCommonSubsequence("", "Hello").lcs(), "") &&
				t.checkExpect(new LongestCommonSubsequence("Hello", "").lcs(), "") &&
				t.checkExpect(new LongestCommonSubsequence("bombast", "aromatics").lcs(), "omat") &&
				t.checkExpect(new LongestCommonSubsequence("doublet", "out").lcs(), "out") &&
				t.checkExpect(new LongestCommonSubsequence("lake", "make").lcs(), "ake") &&
				t.checkExpect(new LongestCommonSubsequence("laundromat", "automatically").lcs(), "auomat"); }	
}
