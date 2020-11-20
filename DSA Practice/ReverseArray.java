public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int end = arr.length - 1;
        int start = 0;
        int temp;
        reverseArray(arr, start, end);

        //Iterative method
        /*while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }*/
        for (int j : arr){
            System.out.println(j);
        }
    }

    //Recursive Method
    public static void reverseArray(int[] arr, int start, int end){
        if(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr, ++start, --end);
        }
    }
}
