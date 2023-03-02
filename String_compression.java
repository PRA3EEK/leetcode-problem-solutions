class Solution {
    public int compress(char[] chars) {
        int count=1;
        StringBuilder res = new StringBuilder("");
      for(int i=1; i<chars.length; i++){
        if(chars[i] == chars[i-1]){
            count++;
        }else{
           res.append(chars[i-1]);
           if(count>1)res.append(count);
           count = 1;
        }
      }
      res.append(chars[chars.length - 1]);
      if(count>1)res.append(count);
      for(int i=0; i<res.length(); i++){
          chars[i] = res.charAt(i);
      }
      return res.length();
    }
}
