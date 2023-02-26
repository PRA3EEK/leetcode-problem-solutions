class Solution {
     public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        int[][] matrix =  new int[n+1][m+1];
        int[] arr = new int[m + 1];
        for(int i=0; i<m + 1; i++){
            arr[i] = i;
        }

        matrix[0] = arr;

        for(int i=0; i<n + 1 ; i++){
            matrix[i][0] = i;
        }
        
       for(int i=1; i<n + 1; i++){
           for(int j=1; j<m + 1; j++){
               if(word1.charAt(i - 1) == word2.charAt(j - 1)) matrix[i][j] = matrix[i-1][j-1];
               else {
                   matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
               }
           }
       }
    
    

   return matrix[n][m];
    }

    
}
