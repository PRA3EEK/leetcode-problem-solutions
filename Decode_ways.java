class Solution {

   

    public int numDecodings(String s) {
        
      if(s.length() == 0 || s.charAt(0) == '0') return 0;
      if(s.length() == 1) return 1;

      int preCount = 1;
      int prepreCount = 1;

      for(int i=1; i<s.length(); i++){
          
          int count = 0;

          if(s.charAt(i) - '0' > 0) count += preCount;
          int dig = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
          if(dig >= 10 && dig <= 26) count += prepreCount;

          prepreCount = preCount;
          preCount = count;

      }

      return preCount;

    }


    
}
