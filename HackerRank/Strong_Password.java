package hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.Character;

public class Strong_Password {
    static int minimumNumber(int n, String password) {
        int min =0;
        boolean isUp=false, isLow = false, isSp=false, isNum= false;
        char[] pass = password.toCharArray();
        for(int i= 0; i < n; i++){
            if(Character.isUpperCase(pass[i]))
                isUp=true;
            if(Character.isLowerCase(pass[i]))
                isLow=true;
            if(pass[i] == '!' || pass[i] == '@' || pass[i] == '#' || pass[i] ==  '$' || pass[i] ==  '%' || pass[i] == '^' || pass[i] == '&' || pass[i] == '*' || pass[i] == '(' || pass[i] ==  ')' || pass[i] == '-' || pass[i] ==  '+')
                isSp=true;
            if(Character.isDigit(pass[i]))
                isNum= true;
        }// Return the minimum number of characters to make the password strong
        if(isUp == false) min++;
        if(isLow == false) min++;
        if(isSp == false) min++;
        if(isNum== false)min++;
        if(min+n > 6)
           return min;
        else
            min=min+6-(min+n);
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
