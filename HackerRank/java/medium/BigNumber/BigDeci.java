// https://www.hackerrank.com/challenges/java-bigdecimal/problem
package hackerrank.java.medium.BigNumber;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigDeci {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();
        int k = n;
        while(k-- >= 0){ //Applying bubble sort to perform numeric comaprisions
            for(int i = 0; i < k; i++){
                BigDecimal thisElem = new BigDecimal(s[i]); // Comparing Big Numer strings using BigDecimal
                BigDecimal nextElem = new BigDecimal(s[i+1]);
                String temp = "";
                if(thisElem.compareTo(nextElem) < 0){
                    temp = s[i];
                    s[i] = s[i + 1];
                    s[i + 1] = temp;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}