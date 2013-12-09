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
	 * Sets the parameters to their equivalent Object fields
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
	 * Checks HashTable for the result.
	 * 
	 * @return String
	 */
	public String lcs(){
		
		LinkedList<String> tempList = new LinkedList<String>();
		tempList.add(stringOne);
		tempList.add(stringTwo);
		
		if(hashTable.containsKey(tempList))
			return hashTable.get(tempList);
		else{
			String value = this.lcsHelper(0, 0);
			hashTable.put(tempList, value);
			return value;
		}
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
		
		int stringOneLength = this.stringOne.length()-startOne;
		int stringTwoLength = this.stringTwo.length()-startTwo;
		int startOneTemp = startOne;
		int startTwoTemp = startTwo;
		int startOneTemp2 = startOne;
		int startTwoTemp2 = startTwo;
		int startOneTemp3 = startOne;
		int startTwoTemp3 = startTwo;
		
		if(stringOneLength == 0 || stringTwoLength == 0){
			return "";
		}			
		else if(this.stringOne.charAt(startOneTemp) == this.stringTwo.charAt(startTwoTemp)){
			LinkedList<String> tempList = new LinkedList<String>();
			tempList.add(stringOne.substring(startOneTemp));
			tempList.add(stringTwo.substring(startTwoTemp));
			
			if(hashTable.containsKey(tempList))
				return hashTable.get(tempList);
			else{
				String result = this.stringOne.charAt(startOne) + this.lcsHelper(startOne += 1, startTwo += 1);	
				hashTable.put(tempList, result);
				return result;
			}			
		}
		else{
			String stringOneResult;
			String stringTwoResult;// = this.lcsHelper(startOneTemp3 += 1, startTwoTemp3);
			
			LinkedList<String> tempListTwo = new LinkedList<String>();
			tempListTwo.add(stringOne.substring(startOneTemp2));
			tempListTwo.add(stringTwo.substring(1 + startTwoTemp2));			
			if(hashTable.containsKey(tempListTwo))
				stringOneResult = hashTable.get(tempListTwo);
			else{
				stringOneResult = this.lcsHelper(startOneTemp2, startTwoTemp2 += 1);
				hashTable.put(tempListTwo, stringOneResult);
			}
			
			LinkedList<String> tempListThree = new LinkedList<String>();
			tempListThree.add(stringOne.substring(1 + startOneTemp3));
			tempListThree.add(stringTwo.substring(startTwoTemp3));	
			if(hashTable.containsKey(tempListThree))
				stringTwoResult = hashTable.get(tempListThree);
			else{
				stringTwoResult = this.lcsHelper(startOneTemp3 += 1, startTwoTemp3);
				hashTable.put(tempListThree, stringTwoResult);
			}
			
			if(stringOneResult.length() > stringTwoResult.length())
				return stringOneResult;
			else
				return stringTwoResult;
		}			
	}
}

