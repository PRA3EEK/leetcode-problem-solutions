class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        traverse(root, new HashMap<String, Integer>(), res);
        return res;
    }

    public String traverse(TreeNode node, Map<String, Integer> map, List<TreeNode> res){
        if(node == null) return "";
      String representation = "("+traverse(node.left, map, res)+")"+node.val+"("+traverse(node.right, map, res)+")";
      map.put(representation, map.getOrDefault(representation, 0) + 1);
      if(map.get(representation) == 2) res.add(node);
      return representation;
    }
}
