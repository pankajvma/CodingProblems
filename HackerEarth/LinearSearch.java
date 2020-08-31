import java.util.Scanner;

public class LinearSearch {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int numberOfElements = scanner.nextInt();
        int numberToSearch = scanner.nextInt();
        int [] array = getElements(numberOfElements);
        System.out.println(linearSearch(array, numberToSearch)); 
    }

    private static int[] getElements(int numberOfElements){
        int [] array = new int [numberOfElements];
        for(int i = 0; i < numberOfElements; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int linearSearch(int [] array, int numberToSearch){
        int lastIndex = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == numberToSearch){
                lastIndex =i + 1;
            }
        }
        return lastIndex;
    }
}
