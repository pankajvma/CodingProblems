public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        bubble(arr);

        for (int i : arr){
            System.out.println(i);
        }
    }

    public static void bubble(int[] arr){
        int sortedIndex = arr.length - 1;
        while(sortedIndex > 0){
            for (int i = 0; i < sortedIndex; i++) {
                if(arr[i] > arr[i + 1]){
                    swap(arr, i+1, i);
                }
            } sortedIndex--;
        }

    }

    public static void swap(int[] arr, int greater, int smaller){
        int temp = arr[smaller];
        arr[smaller] = arr[greater];
        arr[greater] = temp;
    }
}
