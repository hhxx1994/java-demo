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

  public Iterable<Integer> adj(int v){
    List<Integer> adj = new ArrayList<>();
    for (int i = 0; i < this.v[v].length; i++) {
      if(this.v[v][i] == 1){
        adj.add(i);
      }
    }
    return adj;
  }

  public List<Integer> preorderTraversal(){
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[this.v.length];
    for (int i = 0; i < this.v.length; i++) {
      if(!visited[i]){
        dfs(i,result,visited);
      }
    }
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

  public static void main(String[] args) {
    int[][] g = {{0,1,1,0},{1,0,0,1},{1,0,0,1},{0,1,1,0}};
    Graph graph = new Graph(g);
    System.out.println(graph.preorderTraversal());
  }



}
