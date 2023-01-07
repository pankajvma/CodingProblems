// https://www.hackerrank.com/challenges/java-arraylist/problem
package hackerrank.java.easy.DataStructures;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListInJava {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int n = scn.nextInt();
        for(int i = 0; i < n; i++){
            arr.add(new ArrayList<Integer>());
            int numOfElemInInnerArray = scn.nextInt();
            while(numOfElemInInnerArray > 0){
                arr.get(i).add(scn.nextInt());
                numOfElemInInnerArray--;
            }
        }
        int queries = scn.nextInt();
        for(int i = 0; i < queries; i++){
            int x = scn.nextInt() - 1;
            int y = scn.nextInt() - 1;
            try{
                System.out.println(arr.get(x).get(y));
            } catch(IndexOutOfBoundsException e){
                System.out.println("ERROR!");
            }
            /* Another way of handling the exception
            if((x + 1 > n) || (y +1 > arr.get(x).size())){
                System.out.println("ERROR!");
            }
            else{
                System.out.println(arr.get(x).get(y));
            }
             */
        }
    }
}