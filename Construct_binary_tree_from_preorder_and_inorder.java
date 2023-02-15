/*
 *
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
   
    int preorderInd = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++) inorderMap.put(inorder[i], i);

        return createTree(preorder, 0, preorder.length - 1);
        
    }

    public TreeNode createTree(int[] preorder, int left, int right){

         if(left > right) return null;

         int rootVal = preorder[preorderInd++];
         System.out.println(preorderInd);
         TreeNode root = new TreeNode(rootVal);

         root.left = createTree(preorder, left, inorderMap.get(rootVal) - 1);
         root.right = createTree(preorder, inorderMap.get(rootVal) + 1, right);

         return root;
    }
}
