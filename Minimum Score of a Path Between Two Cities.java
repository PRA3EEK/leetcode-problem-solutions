class Solution {
    public int minScore(int n, int[][] roads) {
        
    return createGraph(n, roads);
 
    }

    public int helperFunction(int n, Map<Integer, List<List<Integer>>> graph) {
      
      int res = Integer.MAX_VALUE;

      boolean[] visited = new boolean[n + 1];
      Queue<Integer> q = new LinkedList<>();
        
       q.offer(1);
       visited[1] = true;

       while(!q.isEmpty()){
           int city = q.poll();
           if(!graph.containsKey(city)) continue;
           for(List<Integer> edge:graph.get(city)){
               res = Math.min(edge.get(1), res);
               if(!visited[edge.get(0)]){
                   visited[edge.get(0)] = true;
                   q.offer(edge.get(0));
               }
           }
       }
      
      return res;

    }

    public int createGraph(int n, int[][] roads){

      Map<Integer, List<List<Integer>>> graph = new HashMap<>();

      for(int[] arr:roads){
        graph.computeIfAbsent(arr[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(arr[1], arr[2]));
        graph.computeIfAbsent(arr[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(arr[0], arr[2]));
      }
     
      return helperFunction(n, graph);
    }
}
