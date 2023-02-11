package saksoft;

// 5. Write a programme to sort integer array?
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int a = scanner.nextInt();
        System.out.println("Enter "+ a +" elements: ");
        int[] arr = new  int[a];

        for(int i = 0; i < a; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array entered:");

        for(int integer : arr){
            System.out.print(integer + " ");
        }

        Arrays.sort(arr);

        System.out.println("\nSorted array:");

        for(int integer : arr){
            System.out.print(integer + " ");
        }
        
    }
}
