import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*Jancarlo Sevilla
 * 9/17/2020
 * CEN-3024C
 * MODULE 2 SDLC ASSIGNMENT
 * 
 * Write a text analyzer that reads a file and outputs statistics about that file.
 * It should output the word frequencies of all words in the file, sorted by the most frequently used word.
 * The output should be a set of pairs, each pair containing a word and how many times it occurred in the file.
 * 
 * Poem was provided by:  https://www.gutenberg.org/files/1065/1065-h/1065-h.htm
 * Ignore HTML TEXT, TEXT BEFORE POEM'S TITLE AND TEXT AFTER END OF POEM
 * 
*/

public class MainTest {
	
	
	
    public static void main(String[] args)
    {
    	Map<String, Integer> fileWords = new HashMap<String, Integer>();
    	
    	//checker to check for the txt file of the poem
    	File checker = new File("C:\\Users\\blast\\Desktop\\Stuff\\Homework\\CEN-3024C\\module2-poem.txt");
    	//checker
    	if(checker.exists())
    	{
        	System.out.println("---Words Sorted by Frequency---");
        	
        	//methods
          	wordCount(checker, fileWords);
           	//System.out.println(fileWords); - this was used to check if first method worked
           	sortWordFreq(fileWords);
    	}
    	else
    	{
    		//message of user failure to provide the poem txt file
    		System.out.println(">> Please try again when you have enter the file path in order to use this Text Analyzer\n>> Program Closed");
    		
    	}
    	
    }
    
    
    //methods
    
	static void wordCount(File fileName, Map<String, Integer> fileWords)
    {
    	Scanner file;//setting up text file to be scanned and as well as passing values
		try {
			file = new Scanner(fileName);
			file.useDelimiter("[^a-zA-Z]+");//limiting string to alphabets 
	    	while (file.hasNext())//while the text file contains a token it moves on until it reaches none
	    	{
	    		
	    		String tempPasser = file.next();//passing the scanner token that it encounter into the string
	    		//System.out.println(file.next); this was used to check the use of the scanner.next
	    		
	    		String trackingWords = tempPasser.toLowerCase();//passing string once all of the string has been lower cased
	    		Integer countWords = fileWords.get(trackingWords);//key and integer is passed but integer is recorded
	    		
	    		//System.out.println(trackingWords);//for me to check
	    		//System.out.println(countWords);//for me to check
	    		
	    		if(countWords != null)//once integer is passed checks if its null
	    		{
	    			countWords++;//if not null integer goes up by 1 
	    			//this happens when key if a known key is passed and already has a value
	    		}
	    		else
	    		{
	    			//if key is null it gets 1 to represent its first iteration
	    			countWords = 1;
	    		}
	    		//System.out.println(countWords); for me to check
	    		fileWords.put(trackingWords, countWords);//key and value gets recorded and loop goes again
	    	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    static void sortWordFreq(Map<String,Integer> fileWords)
    {
    	//this creates a set containing the same elements as the hashmap as well as passing the set into the list
    	List<Entry<String, Integer>> passingList = new LinkedList<Entry<String, Integer>>(fileWords.entrySet());
    	//using collection sorts allows the sorting of the passingList and as well as using the comparator interface as a anonymous class
    	//we can then compare two objects of the set and return the sorted elements into the passingList.
    	Collections.sort(passingList, new Comparator<Entry<String, Integer>>()
    			{

					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) 
					{
						// TODO Auto-generated method stub
						return o2.getValue().compareTo(o1.getValue());
					}
    		
    			});
    	
    	int tempIndex = 0;//temp value for limiting list
    	
    	//initially I was going to transfer the list back to the map but if we can just using the sorted list 
    	//to show the ordered items then i think its fine
    	for(Entry<String,Integer> e : passingList)//enchanced for loop
    	{
    		tempIndex++;
    		if(tempIndex <= 20)//this will be printed until the temp variable reaches past 21
    		{
    			//System.out.println(tempIndex);this was for me to check 
    			System.out.println(">> " + "{" + e.getKey() + "," + e.getValue() + "}");
    		}
    		else
    		{
    			break;//once pass the temp value it breaks the loop
    		}
    	}
    	
    	//What I initially thought of but deciding that since we are manipulating the list by assortment
    	//wouldnt it be faster using a linkedlist?
    	// I also tried to do TreeMap but sorting it out using Keys is not the answer
    	
    	/*int count = 0;
    	List<Entry<String, Integer>> listOfValues = new ArrayList<Entry<String, Integer>>(fileWords.entrySet());
    	
    	/*System.out.println("\n-----Words Ordered By Frequency-----");
    	while(count != 20)
    	{
    	
    	}*/
    
    	
    	
    	
    }
    
    
}







