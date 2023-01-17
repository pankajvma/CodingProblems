// https://www.hackerrank.com/challenges/bon-appetit/problem
package hackerrank.problemSolving.easy.implementation;

import java.io.*;
import java.util.*;

class Result {

    public static int getAnnasBill(List<Integer> bill, int k){
        int annasBill = 0;   
        for(Integer i  : bill){
            annasBill += i;
        }
        annasBill -= bill.get(k);
        return annasBill/2;
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int annasBill = getAnnasBill(bill, k);
        if(annasBill == b){
            System.out.println("Bon Appetit");
        } else{
            System.out.println(b - annasBill);
        }

    }

}

public class BillDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] billTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> bill = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int billItem = Integer.parseInt(billTemp[i]);
            bill.add(billItem);
        }

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Result.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
