class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
      List<List<Integer>> res = new ArrayList<>();
      if(root == null){
          return res;
      }
      q.offer(root);  

       while(!q.isEmpty()){
        int num = q.size();
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<num ; i++){
            if(q.peek().left!=null){
            q.offer(q.peek().left);
            }
            if(q.peek().right!=null){
                q.offer(q.peek().right);
            }
            list.add(q.poll().val);
        }
        
         res.add(list);
        
       } 
       return res;
    }
}
