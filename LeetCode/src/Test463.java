public class Test463 {
    public int islandPerimeter(int[][] grid) {
        int cnt = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    cnt += 4;

                    if(i-1>-1 && grid[i-1][j]==1){
                        cnt -= 1;
                    }

                    if(i+1<grid.length && grid[i+1][j]==1){
                        cnt -= 1;
                    }

                    if(j-1>-1 && grid[i][j-1]==1){
                        cnt -= 1;
                    }

                    if(j+1<grid[i].length && grid[i][j+1]==1){
                        cnt -= 1;
                    }
                }
            }
        }

        return cnt;
    }
}
