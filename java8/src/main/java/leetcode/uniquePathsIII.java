package leetcode;

/**
 * @author huanghaoxing
 */
public class uniquePathsIII {
  int[][] dis = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
  int[][] grid;
  boolean[][] visited;
  int left;
  int R;
  int C;
  int end;
  int ret;
  public int uniquePathsIII(int[][] grid) {
    this.grid = grid;
    R = grid.length;
    C = grid[0].length;
    visited = new boolean[R][C];
    int startX = 0;
    int startY = 0;
    left = R*C;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(grid[i][j] == -1){
          left--;
        }else if(grid[i][j] == 1){
          startX = i;
          startY = j;
          grid[i][j] = 0;
        }else if(grid[i][j] == 2){
          end = i * R + j;
          grid[i][j] = 0;
        }
      }
    }
    dfs(startX,startY);
    return ret;
  }

  private void dfs(int x , int y){
    visited[x][y] = true;
    left--;
    if(left == 0 && end == (x *  R + y)){
      ret++;
    }
    for (int d = 0; d < dis.length; d++) {
      int nextX = x + dis[d][0];
      int nextY = y + dis[d][1];
      if(inArea(nextX,nextY) && grid[nextX][nextY] != -1 && !visited[nextX][nextY]){
        dfs(nextX,nextY);
      }
    }
    left++;
    visited[x][y] = false;
  }

  private boolean inArea(int x , int y){
    return x >= 0 && x < R && y >= 0 && y < C;
  }
}
