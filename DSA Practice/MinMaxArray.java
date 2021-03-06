public class MinMaxArray {
    public static void main(String[] args) {
        int[] arr = {89, 1, 100, 3, 99};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while(i <= arr.length-1){
            if(min > arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
            i++;
        }
        System.out.println("Min: "+min+"\nMax: "+max);
    }
}
