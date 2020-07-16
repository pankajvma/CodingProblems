class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int numCount=0, maxCount=0;
        for(int i:nums){
            if(i==1){
                numCount++;         //[1,0,1,1,1,0,1]
                if(numCount>maxCount)
                maxCount=numCount;
            }
            else
                numCount=0;
        }
        return maxCount;
    }
}
