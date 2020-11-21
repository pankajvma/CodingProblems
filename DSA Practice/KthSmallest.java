import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {2, 8, 5, 9, 6, 3};
        int k = 3;
        Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }
}