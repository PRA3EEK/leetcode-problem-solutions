import java.util.HashSet;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix) {
        
     Set<Integer> columns = new HashSet<>();
     Set<Integer> rows = new HashSet<>();

     for(int i=0; i<matrix.length; i++){
         for(int j=0; j<matrix[0].length; j++){
             if(matrix[i][j] == 0) {
                 columns.add(j);
                 rows.add(i);
             }
         }
     }

    //  System.out.println(columns+" "+rows);

     for(int col:columns){
         for(int i=0; i<matrix.length; i++){
             matrix[i][col] = 0;
         }
     }

     for(int row:rows){
         for(int i=0; i<matrix[0].length; i++){
             matrix[row][i] = 0;
         }
     }

    }
}
