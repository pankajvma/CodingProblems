// https://www.hackerrank.com/challenges/utopian-tree/problem
package hackerrank.problemSolving.easy.algorithms.implementation;

import java.io.*;

class Result {

    public static int utopianTree(int n) {
        int height = 0;
        for(int i = 0; i <= n; i++){
            if(i % 2 == 0){
                height += 1;
            } else height *= 2;
        } return height;
    }

}

public class UtopianTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int result = Result.utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}