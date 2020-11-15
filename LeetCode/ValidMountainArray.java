class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int len= A.length-1, j=0;
        if(len==0||len<0||A[1]<A[0])
            return false;
        for(int i=0; i<len; i++){
            if(A[i]<A[i+1]&&(i+1)==len)
                return false;
            else if(A[i] < A[i+1])
                continue;
            else if(A[i] > A[i+1]){
                j = i+1;
                break;
            }
            else
                return false;    
        }
        while(j<len){
            if(A[j] > A[j+1]){
              j++;  
              continue;
            }
            else
                return false;
        }
        return true;
    }
}
