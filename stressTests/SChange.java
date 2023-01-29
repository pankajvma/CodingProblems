package stressTests;

import java.util.Random;

public class SChange {
    private static int getChange(int m) {
        int count = 0;
        while(m > 0){
            if(m >= 10){
                m -= 10;
            } else if(m >= 5){
                m -= 5;
            }else{
                m -= 1;
            } count++;
        }
        return count;
    }

    private static int getChangeFast(int m){
        return (m/10) + (m%10)/5 + ((m%10)%5)/1;
    }

    public static void main(String[] args) {
        Random random = new Random(5);
        while(true){
            int m = random.nextInt(1000000);
            int naiveChange = getChange(m);
            int fastChange = getChangeFast(m);

            if(fastChange == naiveChange){
                System.out.println("OK");
            } else{
                System.out.println("Failed for m = "+m);
                System.out.println("Naive solution returned "+naiveChange);
                System.out.println("Fasr solution returned "+fastChange);
                break;
            } 
        }
    }
}