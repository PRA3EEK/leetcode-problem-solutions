class Solution {
    public boolean isPalindrome(String s) {
        
       StringBuilder compressedString = new StringBuilder("");

       for(int i=0; i<s.length(); i++){
           if((s.charAt(i) - 'a'>=0 && s.charAt(i) - 'a'<26) || (s.charAt(i) - 'A'>=0 && s.charAt(i) - 'A'<26) || (s.charAt(i)>='0' && s.charAt(i)<='9'))
                 compressedString.append(s.charAt(i));

       }
       String newString = compressedString.toString().toLowerCase();
    //    System.out.println(newString);
      int l = 0;
      int r = newString.length() - 1;
      while(l<r){
          if(newString.charAt(l) != newString.charAt(r)) return false;
          l++;
          r--;
      }
        return true;
    }
}
