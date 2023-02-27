class Solution {
    public Node construct(int[][] grid) {
         boolean isSame = true;
      return createQuadTree(grid, grid.length, 0, 0);
       

    }

    public boolean isSame(int[][] grid, int n, int x, int y){
      int val = grid[x][y];
      for(int i=x; i<x+n; i++){
          for(int j=y; j<y+n; j++){
              if(grid[i][j]!=val) return false;
          }
      }
      return true;
    }

    public Node createQuadTree(int[][] grid, int n, int x, int y) {
   
     if(isSame(grid, n, x, y)){
         return new Node(grid[x][y] == 1, true);
     }
      
      Node root = new Node(false, false);
      
      root.topLeft = createQuadTree(grid, n/2, x, y);
      root.topRight = createQuadTree(grid, n/2, x, y + (n/2));
      root.bottomLeft = createQuadTree(grid, n/2, x + (n/2), y);
      root.bottomRight = createQuadTree(grid, n/2, x + (n/2), y + (n/2));


     return root;
    }
    
}
