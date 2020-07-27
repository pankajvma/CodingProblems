class Solution {
    public int[] replaceElements(int[] arr){
        int len = arr.length-1,max=0;
        if(len==0){
            arr[0]=-1; 
            return arr;
        }
        for(int i=0; i<=len;i++){
            max=0;
            for(int j=len; j>i;j--)
                if(arr[j]>max)      
                    max=arr[j];
            arr[i]=max;
        }
        arr[len]=-1;
        return arr;
    }
}
