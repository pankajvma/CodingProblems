// https://www.hackerrank.com/challenges/permutation-equation/problem
package hackerrank.problemSolving.easy.implementation;

import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> permutationEquation(List<Integer> p) {
        List<Integer> indexList = new ArrayList<>();
        for(int i = 1; i <= p.size(); i++){
            int index = p.indexOf(i)+1;
            indexList.add(p.indexOf(index)+1);
        }
        return indexList;
    }

}

public class PermutationEquation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] pTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pTemp[i]);
            p.add(pItem);
        }

        List<Integer> result = Result.permutationEquation(p);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
