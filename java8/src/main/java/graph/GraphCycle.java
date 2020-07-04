package graph;

import java.io.FileNotFoundException;

/**
 * @author huanghaoxing
 */
public class GraphCycle {
  private Graph graph;
  private boolean[] visited;
  boolean isCycle = false;
  public GraphCycle(Graph graph){
    this.graph = graph;
    visited = new boolean[this.graph.V];
    for (int i = 0; i < this.graph.V; i++) {
      if(!visited[i] && !isCycle)
        dfs(i,i);
    }

  }

  private void dfs(int v , int parent){
    visited[v] = true;
    for (Integer w : this.graph.adj(v)) {
      if(!visited[w])
          dfs(w, v);
      else if(w != parent){
        isCycle = true;
        return;
      }
    }

  }





  public static void main(String[] args) throws FileNotFoundException {
    Graph graph = new Graph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/g.txt");
    GraphCycle graphCycle = new GraphCycle(graph);
    System.out.println(graphCycle.isCycle);

  }

}
