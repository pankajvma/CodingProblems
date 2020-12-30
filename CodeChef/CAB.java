import java.io.*;
import java.util.ArrayList;

public class CAB {
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[128]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static int [] powerList =new int[26];
    static char[] alphabetList = new char[26];
    public static void main(String[] args) throws Exception {
        try {
            for(int i =0; i < 26; i++){
                powerList[i] = (int)Math.pow(2, i);
            }
            char j = 97;
            for(int i =0; i < 26; i++, j++){
                alphabetList[i] = j;
            }
            /*for(char i: alphabetList){
                System.out.println(i);
            }*/
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            FastReader fs = new FastReader();
            int testCases = fs.nextInt();
            while (testCases != 0) {
                int givenLetters = fs.nextInt();
                int requiredSum = fs.nextInt();
                if((givenLetters > requiredSum) ||
                        (givenLetters < minimumRequiredLetters(requiredSum)) ){
                    //System.out.println(requiredSum);
                    System.out.println(-1);
                }else{
                    printString(requiredSum, givenLetters);
                }
                testCases--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int minimumRequiredLetters(int requiredSum){
        int minReq = 0;
        for(int i = powerList.length-1; i >= 0; i--){
            if(powerList[i] <= requiredSum){
                requiredSum -= powerList[i];
                minReq++;
                if(requiredSum == 0){
                    return minReq;
                }
            }
        }
        return  minReq;
    }

    public static void printString(int requiredSum, int givenLetters){
        for(int i = givenLetters -2; i >= 0; i--){
            if(powerList[i] <= requiredSum){
                requiredSum -= powerList[i];
                System.out.print(alphabetList[i]);
                i++;
                if(requiredSum == 0){
                    System.out.println();
                    break;
                }
            }
        }

    }

}