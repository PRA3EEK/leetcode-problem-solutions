class WordDictionary {
   
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c:word.toCharArray()){
          if(cur.children[c - 'a'] == null)
            cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        } 
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
     return check(0, word, root);
    }

    public boolean check(int ind, String word, TrieNode root){
        if(ind == word.length()) return root.isEnd;
        char c = word.charAt(ind);
        if(c == '.'){
          for(TrieNode node:root.children){
            if(node != null && check(ind + 1, word, node)) return true; 
          }
        }else{
          return root.children[c - 'a'] != null && check(ind + 1, word, root.children[c - 'a']);
        }
        return false;
    }

}



class TrieNode{

  TrieNode[] children;
  boolean isEnd;
  public TrieNode(){
   children = new TrieNode[26];
  }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
