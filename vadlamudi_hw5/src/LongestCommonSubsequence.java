// Name: Sai Kiran Vadlamudi		Username: svadlamudi		Section: B01
// Name: Marilda Bozdo				Username: mbozdo			Section: B06

/*
 * {@link <java.util.HashMap> [HashMap]}
 */
import java.util.HashMap;
/*
 * {@link <java.util.LinkedList> [LinkedList]}
 */
import java.util.LinkedList;

/**
 * @author Sai Kiran Vadlamudi
 * @author Marilda Bozdo
 * 
 * The LongestCommonSubsequence class calculates and
 * returns the longest subsequence string of the two string fields
 * of the activating object.
 */
public class LongestCommonSubsequence {

	/**
	 * Two strings from which longest subsequence is calculated
	 * HashMap for containing LinkedList<String> for key and String for value.
	 */
	String stringOne;
	String stringTwo;
	HashMap<LinkedList<String>, String> hashTable;
	
	/**
	 * Parameterized Constructor for LongestCommonSubsequence
	 * Sets the parameters equal to their equivalent Object fields
	 * 
	 * @param stringOne
	 * @param stringTwo
	 */
	public LongestCommonSubsequence(String stringOne, String stringTwo){
		this.stringOne = stringOne;
		this.stringTwo = stringTwo;
		hashTable = new HashMap<LinkedList<String>, String>();
	}
	
	/**
	 * Returns the longest subsequence of the two strings.
	 * 
	 * @return String
	 */
	public String lcs(){		
		return this.lcsHelper(0, 0);			
	}
	
	/**
	 * Returns the longest subsequence in the substrings
	 * , beginning index is the start index that is passed in, 
	 *  of the two String fields.
	 * 
	 * @param startOne - Index to Start from in String One
	 * @param startTwo - Index to Start from in String Two
	 * @return String
	 */
	public String lcsHelper(int startOne, int startTwo){
		
		LinkedList<String> tempList = new LinkedList<String>();
		tempList.add(stringOne.substring(startOne));
		tempList.add(stringTwo.substring(startTwo));
		
		int stringOneLength = this.stringOne.length()-startOne;
		int stringTwoLength = this.stringTwo.length()-startTwo;		
		
		if(hashTable.containsKey(tempList)){
			return hashTable.get(tempList);
		}
		
		else{
			
			if(stringOneLength == 0 || stringTwoLength == 0){
				return "";
			}	
			
			else if(this.stringOne.charAt(startOne) == this.stringTwo.charAt(startTwo)){
				String result = this.stringOne.charAt(startOne) + this.lcsHelper(startOne + 1, startTwo + 1);	
				hashTable.put(tempList, result);
				return result;
			}
			
			else{
				String stringOneResult = this.lcsHelper(startOne, startTwo + 1);			
				String stringTwoResult = this.lcsHelper(startOne + 1, startTwo);				
			
				if(stringOneResult.length() > stringTwoResult.length()){
					hashTable.put(tempList, stringOneResult);
					return stringOneResult;
				}					
				else{
					hashTable.put(tempList, stringTwoResult);
					return stringTwoResult;
				}					
			}
			
		}	
		
	}				
}


