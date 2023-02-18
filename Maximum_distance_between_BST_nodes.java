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
    int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
       traverseTree(root);
       return res;
    }

    public void traverseTree(TreeNode root){
        
        if(root == null) return;
        
        findDiffLeft(root.left, root.val);
        traverseTree(root.left);
        findDiffRight(root.right, root.val);
        traverseTree(root.right);
    }

    public void findDiffRight(TreeNode root, int val){
     if(root == null) return;
     if(Math.abs(val-root.val) < res) res = Math.abs(val-root.val);
     findDiffRight(root.left, val);
    }

    public void findDiffLeft(TreeNode root, int val){
     if(root == null) return;
     if(Math.abs(val-root.val) < res) res = Math.abs(val-root.val);
     findDiffLeft(root.right, val);
    }
} 
