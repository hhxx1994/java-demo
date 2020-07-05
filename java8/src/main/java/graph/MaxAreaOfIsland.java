package graph;

/**
 * @author huanghaoxing
 */
public class MaxAreaOfIsland {
  int R;
  int C;
  int[][] grid;
  boolean[][] visited;
  int[][] dis = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
  int ret = 0;
  public int maxAreaOfIsland(int[][] grid) {
    if(grid == null)
      return ret;
    this.grid = grid;
    R = grid.length;;
    C = grid[0].length;
    visited = new boolean[R][C];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(!visited[i][j] && grid[i][j] == 1){
          ret = Math.max(dfs(i,j),ret);
        }
      }
    }
    return ret;
  }

  private int dfs(int x , int y){
    visited[x][y] = true;
    int ret = 1;
    for(int i = 0 ; i < dis.length ; i++){
      int nextX = x + dis[i][0];
      int nextY = y + dis[i][1];
      if(inArea(nextX,nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1){
        ret += dfs(nextX,nextY);
      }
    }
    return ret;
  }

  private boolean inArea(int x, int y){
    return x >= 0 && x < R && y >= 0 && y < C;
  }

  public static void main(String[] args) {
    MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
    int[][] grid = new int[][]{{1,1},{1,0}};
    System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
  }
}
