class Solution {
    public int trap(int[] height) {


       int res = 0;

       int[] left = new int[height.length];
       int[] right = new int[height.length];
  

       for(int i=0; i<height.length; i++)
       {
           if(i>0){
             if(height[i]>left[i-1]) left[i] = height[i];
             else left[i] = left[i-1];
           }else left[i] = height[i];
           
       }

       for(int i=height.length-1; i>=0; i--){
           if(i<height.length-1){
               if(height[i] > right[i+1]) right[i] = height[i];
               else right[i] = right[i+1];
           }else right[i] = height[i];
       }
 
      for(int i=1; i<height.length-1; i++){
        res += (Math.min(left[i], right[i]) - height[i]);
      }
     return res;
    }
}