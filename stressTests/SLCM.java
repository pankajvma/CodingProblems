package stressTests;

import java.util.Random;

public class SLCM {
  private static long lcmNaive(int a, int b) { // naive algorithm
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcmFast(long a, long b) { 
    return (a * b)/getGCD(a, b);    // lcm(a, b) = |a.b|/gcd(a, b) for LCM calculation
  }

  public static long getGCD(long a, long b){ // Fast gcd algorithm using Euclidean lemma
    if(b == 0){
        return a;
    }
    return getGCD(b, a%b);
}

  public static void main(String[] args) {
    Random rnd = new Random(5);
    int a, b;
    while(true){
        a = rnd.nextInt(1000000);
        b = rnd.nextInt(1000000);
        // a = 714552;
        // b = 374513;
        long lcmFast =  lcmFast(a, b);
        long lcm = lcmNaive(a, b);
        if(lcm == lcmFast){
            System.out.println("OK");
        } else {
            System.out.println("Failed for a: "+ a +" and b: "+ b +"\nNaive algorithm returned: " + lcm + "\nFast algorithm returned: "+lcmFast);
            break;
        }
    }
  }
}