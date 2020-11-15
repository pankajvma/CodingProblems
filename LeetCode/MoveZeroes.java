class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len= nums.length-1, zeroCounts=0;
        for(int i = 0; i<=len; i++)
            if(nums[i]==0)
                zeroCounts++;
            else
                nums[i-zeroCounts] = nums[i];
        while(zeroCounts!=0)
            nums[len-(--zeroCounts)] = 0;
    }
}
