// https://www.hackerrank.com/challenges/java-hashset/problem?
package hackerrank.warmupChallenges.java.easy.DataStructures;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetInJava {

    public static void main(String[] args) {
           Scanner s = new Scanner(System.in);
           int t = s.nextInt();
           String [] pair_left = new String[t];
           String [] pair_right = new String[t];
           
           for (int i = 0; i < t; i++) {
               pair_left[i] = s.next();
               pair_right[i] = s.next();
           }
           int count = 0;
           HashSet<String> hs = new HashSet<>();
           for (int i = 0; i < t; i++) {
               if(hs.add(pair_left[i]+" "+pair_right[i])) count++;
               System.out.println(count);
           }
   
      }
   }