// https://leetcode.com/problems/maximum-subarray/
package dataStructures;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = -1000000;
        int windowSize = 0;
        int tempSum = 0;
        while(windowSize < nums.length){
            for(int i = 0; i < nums.length - windowSize; i++){
                tempSum = getSum(i, i + windowSize, nums);
                if(maxSum < tempSum){
                    maxSum = tempSum;
                }
            }
            windowSize++;
        }
        return maxSum;
    }

    public int getSum(int startInd, int stopInd, int[] nums){
        int sum = 0;
        for(int i = startInd; i <= stopInd; i++){
            sum += nums[i];
        }
        for(int i = 0; i <= stopInd; i++){
        }
        return sum;
    }

    public static void main(String[] args){
        MaxSubArray maxSub = new MaxSubArray();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSub.maxSubArray(arr));
    }
}