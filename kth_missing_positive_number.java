class Solution {
    public int findKthPositive(int[] arr, int k) {
        int max = arr[arr.length - 1];
        int count = 0;
        int ind = 0;
        int kcount = 0;
        while(kcount<k){
            count++;
            if(ind<arr.length && count == arr[ind]){
               ind++;
            }else{
              kcount++;
            }
        }
       return count;
    }
}
