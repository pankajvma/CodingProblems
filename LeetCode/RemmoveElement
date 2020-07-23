class Solution {
    public int removeElement(int[] nums, int val) {
        int length=nums.length-1;
        for(int i=0; i<=length; i++){
            while(nums[i]==val){
                nums[i]=nums[length];
                if(length==i)
                   return length;
                if(--length<0)
                    return 0;
            }
        }
        return length+1;
    }
}
