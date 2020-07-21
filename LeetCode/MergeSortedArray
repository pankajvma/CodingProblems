class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        m+=n;
        int j=0;
        for(int i=0;i<n;i++){
            j=i;
            while(j<m){
                if(nums2[i]>nums1[j]){
                    for(int k=m-1;k>j;k--)
                        nums1[k]=nums1[k-1];
                nums1[j]=nums2[i];
                }
            }
        }
    }
}
