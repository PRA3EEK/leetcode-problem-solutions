class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        res.add(firstList);

        for(int i=0; i<numRows - 1 ; i++){
          List<Integer> list = res.get(res.size() - 1);
          List<Integer> newList = new ArrayList<>();
          newList.add(1);
          for(int j=0; j<list.size() - 1; j++){
            newList.add(list.get(j) + list.get(j + 1));
          }
          newList.add(1);
          res.add(newList);
        }
        return res;
    }
}
