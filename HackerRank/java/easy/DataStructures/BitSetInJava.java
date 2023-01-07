// https://www.hackerrank.com/challenges/java-bitset/problem
package hackerrank.java.easy.DataStructures;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BitSetInJava {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] input = scn.nextLine().split(" ");
        int bitsetSize = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);
        BitSet b1= new BitSet(bitsetSize);
        BitSet b2 = new BitSet(bitsetSize);
        Map<String, BitSet> instruction = new HashMap<>();
        instruction.put("1", b1);
        instruction.put("2", b2);
        while(T-- > 0){
            input = scn.nextLine().split(" ");
            if(input[0].equals("AND")){
                instruction.get(input[1]).and(instruction.get(input[2]));
            } else if(input[0].equals("OR")){
                instruction.get(input[1]).or(instruction.get(input[2]));
            } else if(input[0].equals("XOR")){
                instruction.get(input[1]).xor(instruction.get(input[2]));
            } else if(input[0].equals("FLIP")){
                instruction.get(input[1]).flip(Integer.parseInt(input[2]));
            } else {
                instruction.get(input[1]).set(Integer.parseInt(input[2]));
            }
            System.out.println(b1.cardinality()+" "+b2.cardinality());
        }
    }
}