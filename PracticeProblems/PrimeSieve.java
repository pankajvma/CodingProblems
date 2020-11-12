import java.lang.Math;
class PrimeSieve{
    public static void main(String[] args){
        int n = 2000000;
        boolean[] sieve = new boolean[n];
        for(int i = 0; i < n; i++){
            sieve[i] = true;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(!sieve[i])
                    continue;
            for(int j = i+1; j < n; j++){
                if(!sieve[j])
                    continue;
                if(j % i == 0){
                    sieve[j] = false;
                }
            }
        }
        int i = n-1;
        while(!sieve[i]){
            i--;
        }
        System.out.println(i);
    }
}