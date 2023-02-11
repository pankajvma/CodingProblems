package saksoft;

// 7. Write a programme to reverse any String?
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = string.length() - 1; i >= 0; i--){
            stringBuilder.append(string.charAt(i));
        }
        System.out.println("Reversed string is: " + stringBuilder.toString());
    }
}
