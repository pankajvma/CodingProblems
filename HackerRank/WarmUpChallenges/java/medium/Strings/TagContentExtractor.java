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