class Solution {
 
        //       1
        //   2      3
        // 4   5  6   7
     //4 2 5 1 6 3 7
    

    public List<Integer> inorderTraversal(TreeNode root) {
        
      List<Integer> res = new ArrayList<>();
      helperFunction(root, res);
      return res;


    }

    public void helperFunction(TreeNode root, List<Integer> res){

      if(root != null) {
         helperFunction(root.left, res);
         res.add(root.val);
         helperFunction(root.right, res);
      }
    }


}
