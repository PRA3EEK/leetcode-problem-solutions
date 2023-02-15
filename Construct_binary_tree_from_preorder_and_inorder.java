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


class Solution {

    Map<Integer, Integer> inorderMap = new HashMap<>();
   

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++) inorderMap.put(inorder[i], i);

        return createTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
        
    }

    public TreeNode createTree(int[] inorder, int is, int ie, int[] preorder, int ps, int pe){
   

        if(ps>pe || is>ie) return null;


        TreeNode root = new TreeNode(preorder[ps]);
        int curPos = inorderMap.get(root.val);
        int onLeft = curPos - is;

        root.left = createTree(inorder, is, curPos - 1, preorder, ps + 1, ps + onLeft);
        root.right = createTree(inorder, curPos + 1, ie, preorder, ps + onLeft + 1, pe);

        return root;
    }
}
