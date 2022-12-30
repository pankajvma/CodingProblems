// https://www.hackerrank.com/challenges/java-list/problem?
package hackerrank.warmupChallenges.java.easy.DataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ListInJava {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int listSize = Integer.parseInt(scn.nextLine());
        List<Integer> list = new LinkedList<Integer>();
        String op = "";
        String[] arr = scn.nextLine().split(" ");
        for(int i = 0; i < listSize; i++){
            list.add(Integer.parseInt(arr[i]));
        }
        int q = Integer.parseInt(scn.nextLine());
        while(q-- > 0){
            op = scn.nextLine();
            String[] xy = scn.nextLine().split(" ");
            if(op.equals("Insert")){
                list.add(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
            }else{
                list.remove(Integer.parseInt(xy[0]));
            }
        }
        ListIterator<Integer> lit = list.listIterator();
        System.out.print(lit.next());
        while(lit.hasNext()){
            System.out.print(" "+ lit.next());
        }
    }
}