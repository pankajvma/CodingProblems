class ThirdMaximumNumber {
    int diff1=0, diff2=0;
    public int thirdMax(int[] nums) {
        int first = 0, second = 0, third = -2147483648, diffValues=1;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        else if(len == 2)
            return Math.max(nums[0], nums[1]);
        else if(len >= 3){
            diff1 = nums[0];
            diff2 = nums[0];
            for(int i = 1; i < len; i++){
                if(nums[i] != diff1 && diffValues<2)
                    diffValues++;               
                if(nums[i] != diff1 && nums[i] != diff2){
                    diffValues++;
                    diff2 = nums[i]; 
                }
            }
        }
        if(diffValues == 1)
            return nums[0];
        else if(diffValues == 3)
            return Math.max(diff1, diff2);
        for(int i = 0; i < len; i++)
            if(nums[i] > first)
                first = nums[i];
        for(int i = 0; i < len; i++)
            if(nums[i] > second && nums[i] < first)
                second = nums[i];
        for(int i = 0; i < len; i++)
            if(nums[i] > third && nums[i] < second)
                third = nums[i];
        return third;
    }
}
