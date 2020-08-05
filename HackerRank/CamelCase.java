import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int camelcase(String s) {
        char[] strArray = s.toCharArray();
        int count = 0;
        if(!Character.isUpperCase(strArray[0])){
            count = 1;
            for(int i = 0; i < strArray.length; i++)
                if(Character.isUpperCase(strArray[i]))
                    count++;
        }
        else return count;
        return count;

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
