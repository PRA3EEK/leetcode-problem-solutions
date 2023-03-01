/*Merge sort*/
class Solution {
    public int[] sortArray(int[] nums) {
        
     int[] temp = new int[nums.length];
     divide(nums, 0, nums.length - 1);
     return nums;

    }

    public void divide(int[] nums, int l, int r) {
       
       if(l >= r) return;

      int mid = l + (r - l)/2;

      divide(nums, l, mid);
      divide(nums, mid + 1, r);

      merge(nums, l, mid, r);

    }

    public void merge(int[] nums, int left, int mid, int right){
      int[] temp = new int[right - left + 1];

      int l1 = left, l2 = mid + 1;
      int ind = 0;

      

      while(l1 <= mid && l2 <= right){
          if(nums[l1] <= nums[l2]) {
              temp[ind] = nums[l1++];
          }
          else{
             temp[ind] = nums[l2++];
          }
          ind++;
      }
  
      while(l1<=mid) {
          temp[ind++] = nums[l1++];
      }

      while(l2<=right){
          temp[ind++] = nums[l2++];
      }
   
      for(int i=0, j = left; i<temp.length; i++, j++){
 
        nums[j] = temp[i];
      }

    }
}

/*Heap sort*/
class Solution {
    public int[] sortArray(int[] nums) {

     createHeap(nums);
     heapSort(nums);
     return nums;     
   
    }
 
   private void swap(int[] nums, int left, int right){
       int temp = nums[left];
       nums[left] = nums[right];
       nums[right] = temp;
   }

   private void createHeap(int[] nums){

    for(int i=nums.length/2; i>=0; i--)
    {
        heapify(nums, nums.length, i);
    }

   }

   private void heapSort(int nums[]){
    for(int i=nums.length-1; i>=0; i--){
        swap(nums, 0, i);
        heapify(nums, i, 0);
    }
   }

   private void heapify(int[] nums, int n, int i){
   
    int largest = i;
    int left = 2*i;
    int right = 2*i + 1;

    if(left < n && nums[left] > nums[largest]) largest = left;
    if(right < n && nums[right] > nums[largest]) largest = right;

    if(largest != i){
        swap(nums, i, largest);
        heapify(nums, n, largest);
    }

   }
   
}
