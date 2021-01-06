import java.io.*;

class BILLRD {
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

    static long x, y, size, rounds;
    static long count = 0, x1, x2, x3, y1, y2, y3, temp;

    public static void main(String[] args) throws Exception {
        try {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            FastReader fs = new FastReader();
            int testCases = fs.nextInt();
            while (testCases != 0) {
//                System.out.println("T:"+testCases);
                size = fs.nextInt();
                rounds = fs.nextInt();
                x = fs.nextInt();
                y = fs.nextInt();
                calculatePointOfImpact();
                System.out.println(x+" "+y);
                testCases--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  void calculatePointOfImpact(){
        if(x <= y){
            y -= x;
            x = 0;
        }else{
            x -= y;
            y = 0;
        }

        if (x == 0 && y == 0) {
            x = size;
            y = size;
        }else{
            if(x >= 0 && y == 0){
                x1 = size;
                y1 = size - x;

                temp = x1;
                x2 = y1;
                y2 = temp;

                x3 = y;
                y3 = x;
            }else{
                x1 = size - y;
                y1 = size;

                temp = x1;
                x2 = y1;
                y2 = temp;

                x3 = y;
                y3 = x;
            }

            temp = rounds % 4;
            if(temp == 1){
                x = x1;
                y = y1;
            }else if(temp == 2){
                x = x2;
                y = y2;
            }else if(temp == 3){
                x = x3;
                y = y3;
            }
        }
    }
}
