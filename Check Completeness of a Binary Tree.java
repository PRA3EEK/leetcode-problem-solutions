/*Naive approach BFS*/
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.offer(root);
       boolean check = false;

       while(!q.isEmpty()){
           int size = q.size();
           List<Integer> list = new ArrayList<>();
           for(int i=0; i<size; i++){
               TreeNode firstNode = q.poll();
               if(firstNode!=null && check) return false;
               if(firstNode!=null){
                     list.add(firstNode.val);
                     q.offer(firstNode.left);
                     q.offer(firstNode.right);
                }else{
                    list.add(-1);
                }
            }

            for(int i:list){
                if(i == -1) check = true;
                if(i!=-1 && check) return false;
            }

       }

       return true;

    }
}
