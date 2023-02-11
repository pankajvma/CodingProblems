package saksoft;

/* 9. Print following structure
*
**
***
****
*****
****
***
**
*

*/
import java.util.Scanner;

public class PrintPattern {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();  // We can just enter the value 5 here to print above pattern
        printPattern(a);
    }

    public static void printPattern(int a){
        for(int i = 1; i <= 5; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    
        for(int i = 4; i >= 0; i--){
            for(int j = i; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
