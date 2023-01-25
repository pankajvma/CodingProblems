package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.Random;
import java.util.Scanner;

public class GCD {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
    
        System.out.println(getGCD(a, b));
      }
    

    public static int getGCD(int a, int b){ // Fast algorithm using Euclidean lemma
        System.out.println(a+ " "+b);
        if(b == 0){
            return a;
        }
        return getGCD(b, a%b);
    }
}
