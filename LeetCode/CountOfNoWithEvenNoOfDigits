class Solution {
    public int findNumbers(int[] nums) {
        int numCount=0, evenCount=0;
        for(int i:nums){
            while(i!=0)
		    {
                numCount++;
                i/=10;
		    }
            if(numCount%2==0)
                evenCount++;
            numCount=0;
        }
        return evenCount;
    }
}
