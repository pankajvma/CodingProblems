// https://www.hackerrank.com/challenges/java-dequeue/problem
package hackerrank.java.medium.DataStrucutures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DequeInJava {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;
        int temp = 0;
        Set<Integer> set = new HashSet<>();  // To store unique values
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if(deque.size() == m){      // executes only when the subarray size is reached
                if(set.size() > max) max = set.size();
                temp = deque.poll();        // Remove element from dequeque's head
                if(!deque.contains(temp)) set.remove(temp);         // if the removed attribute is not present in the dequeque now then remove it from the  set as well
            }
        }
        System.out.println(max);
    }
}