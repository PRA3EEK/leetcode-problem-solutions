/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
     

     for(int i=0; i<inorder.length; i++) inorderMap.put(inorder[i], i);

     return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
     

    }

    public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd){
            

            if(inorderStart > inorderEnd || postorderStart > postorderEnd) return null;

            TreeNode root = new TreeNode(postorder[postorderEnd]);

            int curPositionOfRoot = inorderMap.get(root.val);
            
            int onLeft = curPositionOfRoot - inorderStart;

            root.left = buildTree(inorder, inorderStart, curPositionOfRoot - 1, postorder, postorderStart, postorderStart + onLeft - 1);

            root.right = buildTree(inorder, curPositionOfRoot + 1, inorderEnd, postorder, postorderStart + onLeft, postorderEnd - 1);
 
            return root;

    }
}
