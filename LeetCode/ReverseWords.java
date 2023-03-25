// https://leetcode.com/problems/reverse-words-in-a-string/
import java.util.Scanner;

public class ReverseWords {
    public static String reverseWords(String s) {

        StringBuilder str = new StringBuilder();
        String[] strArr = s.trim().split("\\s+");
        System.out.println(strArr.length);
        for(int i = strArr.length - 1; i >=0 ; i--){
            str.append(strArr[i].trim());
            if(i != 0) str.append(" ");
        }
        return str.toString();
    }
     public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(reverseWords(s));
     }
}