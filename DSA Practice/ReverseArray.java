public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int end = arr.length - 1;
        int start = 0;
        int temp;
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int j : arr){
            System.out.println(j);
        }
    }
}
