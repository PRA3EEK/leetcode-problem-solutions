class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAllSequence(n, 0, 0, res, new StringBuilder(""));
        return res;
    }

    public void generateAllSequence(int n, int left, int right, List<String> res, StringBuilder str){

        if(str.length() == 2*n){
            res.add(str.toString());
            return;
        }

        if(left<n){
            str.append("(");
            generateAllSequence(n, left + 1, right, res, str);
            str.deleteCharAt(str.length() - 1);
        }
       if(right < left){
            str.append(")");
            generateAllSequence(n, left, right + 1, res, str);
            str.deleteCharAt(str.length() - 1);
       }
        
    }
}
