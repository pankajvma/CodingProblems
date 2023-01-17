// https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
package hackerrank.problemSolving.easy.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    public static int getIndex(char c){ //To find index of chracter in the Alphabet list
        return c - 'a'; // Because character c will always have greater or equal ASCII value then 'a'
    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        char[] charArray = word.toCharArray();
        int maxCharHeight = 0;
        for(Character c : charArray){
            int temp = h.get(getIndex(c));
            if(maxCharHeight < temp){
                maxCharHeight = temp;
            }
        }
    return maxCharHeight * charArray.length;
    }

}

public class DesignerPDFViewer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] hTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hTemp[i]);
            h.add(hItem);
        }

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}