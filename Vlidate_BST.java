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
    public boolean isValidBST(TreeNode root) {
       
       return helperFunction(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helperFunction(TreeNode root, long leftRange, long rightRange){

         if(root == null) return true;
        
         if(root.val <= leftRange || root.val >= rightRange) return false;

         return helperFunction(root.left, leftRange, root.val) && helperFunction(root.right, root.val, rightRange);
       
    }
}
