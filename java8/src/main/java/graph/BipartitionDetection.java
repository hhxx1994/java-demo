package graph;

import java.io.FileNotFoundException;

/**
 * @author huanghaoxing
 */
public class BipartitionDetection {
  Graph graph;
  boolean[] visited;
  int[] color;
  boolean isBipartitionGraph = true;
  public BipartitionDetection(Graph graph){
    this.graph = graph;
    visited = new boolean[graph.V];
    color = new int[graph.V];
    for (int i = 0; i < graph.V; i++) {
      color[i] = -1;
    }

    for (int i = 0; i < graph.V; i++) {
      if(!visited[i] && isBipartitionGraph){
        dfs(i,0);
      }
    }

  }

  private void dfs(int v , int color){
    visited[v] = true;
    this.color[v] = color;
    for (Integer w : graph.adj(v)) {
      if(!visited[w]){
        dfs(w,1-color);
      }else if(this.color[v] == this.color[w]){
        isBipartitionGraph = false;
        return;
      }
    }
  }
  public static void main(String[] args) throws FileNotFoundException {
    Graph graph = new Graph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/bipartition.txt");
    BipartitionDetection bipartitionDetection = new BipartitionDetection(graph);
    System.out.println(bipartitionDetection.isBipartitionGraph);
  }

}
