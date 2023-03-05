class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
      long res = 0;
      int leftBound = -1;
      int recentMin = -1;
      int recentMax = -1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]<minK||nums[i]>maxK) leftBound=i;
            if(nums[i]==minK) recentMin=i;
            if(nums[i]==maxK) recentMax=i;
            res+=Math.max(0, Math.min(recentMin, recentMax)-leftBound);
        }

        return res;
    }
}
