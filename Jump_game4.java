class Solution {


    public int minJumps(int[] arr) {

        if(arr.length == 1) return 0;
     int n = arr.length;
     Map<Integer, List<Integer>> graph = new HashMap<>();
   
     for(int i=0; i<arr.length; i++)
      graph.computeIfAbsent(arr[i],v -> new ArrayList<>()).add(i);

     int steps = 0; 
     
     Queue<Integer> q = new LinkedList<>();
     q.offer(0);
   
     while(!q.isEmpty()){
       int size = q.size();
       steps++;
         for(int i=0; i<size; i++){
           int j = q.poll();
           if(j-1 >= 0 && graph.containsKey(arr[j-1])) q.offer(j-1);
           if(j+1 < n && graph.containsKey(arr[j+1])){
            if(j+1 == n-1)return steps;
            q.offer(j+1); 
           }
           if(graph.containsKey(arr[j])){
               for(int k:graph.get(arr[j])){
                   if(k!=j){
                   if(k == n-1) return steps;
                   q.offer(k);
                   }
               }
           }
           graph.remove(arr[j]);
         }
      }
   
     return steps;
    }

    
    }
