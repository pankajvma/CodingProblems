public class MoveNegatives {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            if((arr[start] > 0) && (arr[end] < 0)){
                swap(arr, start, end);
                start++;
                end--;
            }else{
                if(arr[start] < 0){
                    start++;
                } if(arr[end] >= 0){
                    end--;
                }
            }
        }

        for (int i: arr) {
            System.out.println(i);
        }
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }
}
