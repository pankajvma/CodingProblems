import java.io.*;
import java.util.Arrays;

public class FAIRELECT {
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

    static int jojsPacks;
    static int jjosPacks;
    static int jojVotes = 0;
    static int jjoVotes = 0;

    public static void main(String[] args) throws Exception {
        try {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            FastReader fs = new FastReader();
            int testCases = fs.nextInt();
            while (testCases != 0) {
                jojsPacks = fs.nextInt();
                jjosPacks = fs.nextInt();
                int[] joj = new int[jojsPacks];
                int[] jjo = new int[jjosPacks];
                for(int i = 0; i < jojsPacks; i++){
                    joj[i] = fs.nextInt();
                }for(int i = 0; i < jjosPacks; i++){
                    jjo[i] = fs.nextInt();
                }Arrays.sort(joj);
                Arrays.sort(jjo);
                jojVotes = 0;
                jjoVotes = 0;
                for(int i = 0; i < jojsPacks; i++){
                    jojVotes += joj[i];
                }for(int i = 0; i < jjosPacks; i++){
                    jjoVotes += jjo[i];
                }
                if(jojVotes > jjoVotes){
                    System.out.println(0);
                }else{
                    System.out.println(startSwap(joj, jjo));
                }
                testCases--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int startSwap(int[] joj, int[] jjo){
        int count = 0;
        int jjoLen = jjosPacks - 1;
        for(int i = 0; i < jojsPacks && (jjoLen - i >= 0); i++){
            jojVotes += (jjo[jjoLen - i] - joj[i]);
            jjoVotes += (joj[i] - jjo[jjoLen - i]);
            count++;
            if(jojVotes > jjoVotes){
                return  count;
            }
        }
        return  -1;
    }

}