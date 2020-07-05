package graph;


import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class HamiltonLoop {

  Graph graph;
  boolean[] visited;
  int[] pre;
  int end = -1;

  public HamiltonLoop(Graph graph) {
    this.graph = graph;
    pre = new int[graph.V];
    visited = new boolean[graph.V];
    dfs(0,0, graph.V);
  }

  private boolean dfs(int v , int parent , int left) {
    visited[v] = true;
    pre[v] = parent;
    left--;
    for (Integer w : graph.adj(v)) {
      if (!visited[w]) {
        if(dfs(w,v,left))
            return  true;
      }else if(w == 0 && left == 0){
        end = v;
        return true;
      }
    }
    visited[v] = false;
    pre[v] = 0;
    return  false;
  }

  public List<Integer> path(){
    LinkedList<Integer> path = new LinkedList<>();
    if(end == -1)
      return path;
    int end = this.end;
    path.addFirst(end);
    while(end != 0){
      path.addFirst(pre[end]);
      end = pre[end];
    }
    return path;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Graph graph = new Graph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/hamilton.txt");
    HamiltonLoop hamiltonLoop = new HamiltonLoop(graph);
    List<Integer> path = hamiltonLoop.path();
    for (Integer p : path) {
      System.out.println(p);
    }
  }

}
