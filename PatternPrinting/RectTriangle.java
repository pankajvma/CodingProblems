import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class RectTriangle {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n % 2 != 0){
            System.out.println("Please enter an Even number");
            return;
        }
        int temp = n + 1;
        int small_spacing = n/2;
        int largest_spacing = 2*n + small_spacing;
        int count = 1;
        int count0 = n/2;
        while( temp != 0){
            for(int i = 0; i < largest_spacing; i++){
                System.out.print(" ");
            }
            if(count <= n/2+1){
                for(int i = 1; i <= count; i++){
                    System.out.print("@");
                }
            }else{
                for(int i = count0; i >= 1; i--){
                    System.out.print("@");
                }
                count0--;
            }

            System.out.println();
            count++;
            temp--;
        }

        temp = n;
        while(temp != 0){
            for(int i = 0; i < small_spacing; i++){
                System.out.print(" ");
            }
            for(int i = 0; i < 2*n; i++){
                System.out.print("*");
            }
            System.out.println();
            temp--;
        }
        int base = 0;
        while(base < n+1){
            for(int i = 0; i < small_spacing; i++){
                System.out.print(" ");
            }
            for(int i = 0; i <= base; i++){
                System.out.print("@");
            }
            System.out.println();
            small_spacing--;
            base+=2;
        }
    }
}
