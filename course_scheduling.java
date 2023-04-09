class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] arr = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        for(int[] pre:prerequisites){
            arr[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }

        for(int i=0; i<arr.length; i++) if(arr[i] == 0) list.add(i);

        for(int i=0; i<list.size(); i++){
            for(int j:graph[list.get(i)]){
                if(--arr[j] == 0) list.add(j);
            }
        }
        
        return list.size() == numCourses;
    }
}
