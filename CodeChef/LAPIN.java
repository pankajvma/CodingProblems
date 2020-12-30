import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LAPIN {
    static String str;
    static String check1;
    static String check2;
    static int splitFrom;
    public static void main(String[] args) throws Exception {
        try {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases = Integer.parseInt(br.readLine());
            while (testCases != 0) {
                str = br.readLine();
                splitFrom = str.length()/2;
                check1 = str.substring(0, splitFrom);
                if(str.length() % 2 != 0){
                    splitFrom++;
                }
                check2 = str.substring(splitFrom);
                if(checkLapin(check1.toCharArray(), check2.toCharArray())){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
                testCases--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkLapin(char[] check1, char[] check2){
        int i = 0;
        int j = check1.length - 1;
        while((i >= 0 ) && (j < check1.length)){
            if(check2[j] != 0 && check1[i] == check2[j]){
                i++;
                check2[j] = 0;
                j = check1.length - 1;
            }else {
                j--;
            }
            if(j == 0 && check2[j] == '0'){
                return false;
            }
            if(i == check1.length || j == -1){
                break;
            }
        }
        for(char k: check2){
            if(k != 0){
                return  false;
            }
        }
        return true;
    }

}