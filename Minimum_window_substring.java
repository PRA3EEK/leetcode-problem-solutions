class Solution {
    public String minWindow(String s, String t) {
                
  

         /*Store the characters and their frequencies of the string t in a hashmap*/
         Map<Character, Integer> tCharacters = new HashMap<>();

         for(int i=0; i<t.length(); i++){
             int frequency = tCharacters.getOrDefault(t.charAt(i), 0);
             tCharacters.put(t.charAt(i), frequency + 1);
         }

         /*This need variable contains the size of the unique characters present in the string t.*/        
         int need = tCharacters.size();
         /*This have variable will keep the track of the unique characters present in the current window.*/
         int have = 0;

         int left = 0;
         int right = 0;

         int[] res = new int[]{-1, 0, 0};        
 
         Map<Character, Integer> windowCharacters = new HashMap<>();

         while(right < s.length()){
           
           char cur = s.charAt(right);
            
           int frequency = windowCharacters.getOrDefault(cur, 0);
           windowCharacters.put(cur, frequency + 1);

           if(tCharacters.containsKey(cur) && windowCharacters.get(cur).intValue() == tCharacters.get(cur).intValue()) have++;
           
           /*Remove the characters from the left of the window*/
           while(left<=right && have == need){
             char leftChar = s.charAt(left);

             if(res[0] == -1 || right - left + 1 < res[0]){
                 res[0] = right - left + 1;
                 res[1] = left;
                 res[2] = right;
             }

             windowCharacters.put(leftChar, windowCharacters.get(leftChar) - 1);
             if(tCharacters.containsKey(leftChar) && windowCharacters.get(leftChar).intValue() < tCharacters.get(leftChar).intValue()) have--;
             
             left++;
           }
          
          right++;
         }

       return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }
}
