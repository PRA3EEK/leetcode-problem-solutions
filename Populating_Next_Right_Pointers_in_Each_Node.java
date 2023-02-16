class Solution {
    public Node connect(Node root) {
        
     if(root == null) return root;

       Queue<Node> q = new LinkedList<>();
       List<List<Node>> listOfNodes = new ArrayList<>();
       q.offer(root);

       while(!q.isEmpty()){
           int n = q.size();
           List<Node> nodeList = new ArrayList<>();
           for(int i=0; i<n; i++){
               if(q.peek().left!=null) q.offer(q.peek().left);
               if(q.peek().right!=null) q.offer(q.peek().right);
               nodeList.add(q.poll());
           }
           listOfNodes.add(nodeList);
       }
      for(List<Node> list:listOfNodes){
          if(list.size() > 1)
          for(int i=0; i<list.size()-1; i++) list.get(i).next = list.get(i+1); 
      }
      return root;
    }
}
