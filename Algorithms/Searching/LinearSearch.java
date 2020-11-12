import java.util.Scanner;

public class LinearSearch {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter the number of elements:");
        int numberOfElements = scanner.nextInt();
        System.out.println("Enter the "+ numberOfElements +" elements:");
        int [] array = getElements(numberOfElements);
        System.out.println("Enter the number to search in the array:");
        int numberToSearch = scanner.nextInt();
        linearSearch(array, numberToSearch);
    }

    private static int[] getElements(int numberOfElements){
        int [] array = new int [numberOfElements];
        for(int i = 0; i < numberOfElements; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static void linearSearch(int [] array, int numberToSearch){
        for(int i = 0; i < array.length; i++){
            if(array[i] == numberToSearch){
                System.out.println(numberToSearch+ " found at index "+ i);
            }
        }
    }
}
