import java.io.*;

class Sort012 {

    public static void sort012(int[] a, int n){
        int zeroes = countZeroes(a, n);
        int ones = countOnes(a, n);
        insertValues(a, 0, zeroes, 0);
        insertValues(a, zeroes, zeroes + ones, 1);
        insertValues(a, zeroes + ones, n, 2);
    }

    public static void insertValues(int[] a, int start, int end, int value){
        for(int i = start; i < end; i++){
            a[i] = value;
        }
    }

    public static int countZeroes(int[] a, int n){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == 0){
                count++;
            }
        }
        return count;
    }

    public static int countOnes(int[] a, int n){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == 1){
                count++;
            }
        }
        return count;
    }


    public static void main (String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}
