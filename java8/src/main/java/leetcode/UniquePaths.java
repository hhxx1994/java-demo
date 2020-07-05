package leetcode;

/**
 * @author huanghaoxing
 */
public class UniquePaths {
  int[][] dis= new int[][]{{0,1},{1,0}};
  boolean[][] visited;
  int ret;
  int m;
  int n;

  public int uniquePaths(int m, int n) {
    this.m = m;
    this.n = n;
    visited = new boolean[m][n];
    dfs(0,0);
    return ret;
  }

  public void dfs(int x , int y){
    visited[x][y] = true;
    if(x == m -1 && y == n-1){
      ret++;
    }
    for(int i = 0; i< dis.length ; i++){
      int nextX = x + dis[i][0];
      int nextY = y + dis[i][1];
      if(inArea(nextX,nextY) && !visited[nextX][nextY]){
        dfs(nextX,nextY);
      }
    }
    visited[x][y] = false;
  }

  public boolean inArea(int x , int y){
    return x >= 0 && x < m && y >= 0 && y < n;
  }

}
