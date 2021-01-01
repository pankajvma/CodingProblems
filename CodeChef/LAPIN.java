import java.io.*;

public class LAPIN {
    static String str;
    static String check1;
    static String check2;
    static int splitFrom;
    static int[] frequencyArr = new int[26];
    static char[] alphabetList = new char[26];
    static char i;
    public static void main(String[] args) throws Exception {
        try {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char j = 97;
            for(int i =0; i < 26; i++, j++){
                alphabetList[i] = j;
            }
            int testCases = Integer.parseInt(br.readLine());
            while (testCases != 0) {
                for(int i =0; i < 26; i++, i++){
                    frequencyArr[i] = 0;
                }
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
        int j = 0;
        while(i < alphabetList.length){
            //System.out.println(i);
            if(alphabetList[i] == check1[j]){
                frequencyArr[i]++;
            }
            j++;
            if(j == check1.length){
                j = 0;
                i++;
            }
        }
        i = 0;
        j = 0;
        int count = 0;
        while(i < alphabetList.length){
            System.out.println(alphabetList[i]+": " + frequencyArr[i] );
            i++;
        }
        while(i < alphabetList.length){
            if(alphabetList[i] == check2[j]){
                count++;
                if(j == alphabetList.length-1 && count == frequencyArr[i]){
                    j = 0;
                    i++;
                }
            }
        }
        return true;
    }

}