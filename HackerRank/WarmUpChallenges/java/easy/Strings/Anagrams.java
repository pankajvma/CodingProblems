// https://www.hackerrank.com/challenges/java-anagrams/problem
package hackerrank.warmupChallenges.java.easy.Strings;

import java.util.Scanner;

public class Anagrams {
    
    static int[] aToZ(){
        int[] arr = new int[26];
        int i = 0;
        for(int alphabet = 'a'; alphabet <= 'z'; alphabet++){
            arr[i] = alphabet;
            i++;
        }
        return arr;
    }

    static int getCharCount(int alphabet, String aOrb){
        int count = 0;
        for(int i = 0; i < aOrb.length(); i++){
            if(aOrb.charAt(i) == alphabet) count++;
        }
        return count;
    }
    
    static boolean isAnagram(String a, String b) {
        if(a.equals(b)) return true;
        if(a.length() != b.length()) return false;
        int[] charArr = aToZ();
        for(int i = 0; i < charArr.length; i++){
            if(getCharCount(charArr[i], a.toLowerCase()) != getCharCount(charArr[i], b.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    // An alternate way of solving this is as follows

    // static boolean isAnagram(String a, String b) {
    //     if(a.equals(b)) return true;
    //     if(a.length() != b.length()) return false;
        
    //     String c= a.toLowerCase();
    //     String d= b.toLowerCase();

    //     char  []c1=c.toCharArray();
    //     char  []c2=d.toCharArray();

    //     java.util.Arrays.sort(c1);
    //     java.util.Arrays.sort(c2);
    //     a=java.util.Arrays.toString(c1);
    //     b=java.util.Arrays.toString(c2);
    //     return a.equals(b);
    // }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}