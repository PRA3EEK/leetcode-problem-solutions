class SmallestInfiniteSet {

    int smallestNum = 1;
    PriorityQueue<Integer> q = new PriorityQueue<>();
    Set<Integer> isPresent = new HashSet<>();

    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        int res = 0;
        if(!q.isEmpty()){
           res = q.poll();
           isPresent.remove(res);
        }else{
             res = smallestNum;
              smallestNum++;
        }
        return res;
    }
    
    public void addBack(int num) {
       if(smallestNum <= num || isPresent.contains(num)) return;
       q.add(num);
       isPresent.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
