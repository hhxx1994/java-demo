import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class Graph {

  int[][] v;
  public Graph(int[][] v){
    this.v = v;
  }

  public int[] adj(int v){
    return this.v[v];
  }

  public List<Integer> preorderTraversal(){
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[this.v.length];
    dfs(0,result,visited);
    return result;
  }

  private void dfs(int v,List<Integer> list,boolean[] visited){
    list.add(v);
    visited[v]  = true;
    for (int w : adj(v)) {
      if(!visited[w]){
        dfs(w,list,visited);
      }
    }
  }



}
