import java.util.Scanner;

public class BinarySearch {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter the number of elements:");
        int numberOfElements = scanner.nextInt();
        System.out.println("Enter the "+ numberOfElements +" elements in sorted order:");
        int [] array = getElements(numberOfElements);
        System.out.println("Enter the number to search in the sorted array:");
        int numberToSearch = scanner.nextInt();
        int lowerBound = 0;
        int upperBound = array.length - 1;
        int mid = binarySearch(array, lowerBound, upperBound, numberToSearch);
        if(mid != -1) {
            System.out.println("Item found at index: "+ mid);
        } else{
            System.out.println("Item not found.");
        }
    }

    private static int[] getElements(int numberOfElements){
        int [] array = new int [numberOfElements];
        for(int i = 0; i < numberOfElements; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int binarySearch(int [] array, int lowerBound, int upperBound, int numberToSearch){
            int mid = (lowerBound + upperBound)/2;
            if(array[mid] == numberToSearch){
                return mid;
            }
            else if (numberToSearch < array[mid]){
                upperBound = mid - 1;
            }
            else if (numberToSearch >array[mid]){
                lowerBound = mid + 1;
            }
            if(upperBound >= lowerBound){
                return binarySearch(array, lowerBound, upperBound, numberToSearch);
            }
        return -1;
    }
}
