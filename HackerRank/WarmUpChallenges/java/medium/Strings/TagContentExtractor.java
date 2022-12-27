// https://www.hackerrank.com/challenges/tag-content-extractor/problem
package hackerrank.warmupChallenges.java.medium.Strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
            System.out.println(getExtract(line));
			testCases--;
		}
	}
    
    public static String getExtract(String str){
        StringBuilder extract = new StringBuilder();
        Pattern ptrn = Pattern.compile("<(.+)>([^<]+)</(\\1)>");
        Matcher match = ptrn.matcher(str); // matcher(input):  Creates a matcher that will match the given input against this pattern.
        if(!match.find()){ //find(): Attempts to find the next subsequence of the input sequence that matches the pattern.
            return "None";
        }
        match.reset();
        if(match.find()){
            extract.append(match.group(2)); // group(int): Returns the input subsequence captured by the given group during the previous match operation. Here, previous match operation is match.find()
        }
        while(match.find()){
            extract.append("\n");
            extract.append(match.group(2));
        }
       
        return extract.toString();
    }
}

/* Explaining above ptrn <(.+)>([^<]+)</(\\1)>
    #1. < --------> Exact match with <
    #2. (.+) -----> Group1 contains ".+". Here "." mean any charater except line terminator. "+" means the preceeding character or character type can repeat one or more times.
    #3. > --------> Exact match with >
    #4. ([^<]+) --> Group2 comtains a character class and + symbol. Explained in #5 and #6
    #5. [^<] -----> Shoul not start with a <
    #6. + --------> As explained in #2 here #5 is preceeding character class, it can repeat one or more times.
    #7. </ -------> Exact match with </
    #8. (//1) ----> Whatever was mattched in Group1
    #9. > --------> Exact match with >

    Explaining pattern
    Utilizing ipDigitPattern and using it with [.] to create the full pattern
     */