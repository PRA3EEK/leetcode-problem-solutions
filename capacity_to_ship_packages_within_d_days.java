class Solution {

    public int shipWithinDays(int[] weights, int days) {



      int maxWeight = 0;

      int totalWeight = 0;



      for(int i=0; i<weights.length; i++){

          totalWeight += weights[i];

          maxWeight = Math.max(maxWeight, weights[i]);

      }



      int l = maxWeight;

      int r = totalWeight;



      while(l < r){

          int mid = l + (r - l) / 2;

          if(helperFunction(weights, mid, days)){

              r = mid;

          }else l = mid + 1;

      }



      return l;

    }



    public boolean helperFunction (int[] weights, int capacity, int days) {

 

      int daysTaken = 1;

      int weight = 0;



      for(int i:weights){

          weight += i;

          if(weight > capacity){

              daysTaken++;

              weight = i;

          }

      }



      if(daysTaken <= days) return true;



      return false;



    }

}
