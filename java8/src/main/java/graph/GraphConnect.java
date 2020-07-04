package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class GraphConnect {
  private Graph graph;
  private int ccount;
  private int[] visited;
  boolean isCycle = false;
  public GraphConnect(Graph graph){
    this.graph = graph;
    visited = new int[this.graph.V];
    for (int i = 0; i < this.graph.V; i++) {
      visited[i] = -1;
    }
    for (int i = 0; i < this.graph.V; i++) {
      if(visited[i] == -1){
        dfs(i);
        ccount++;
      }
    }
  }

  private void dfs(int v){
    visited[v] = ccount;
    for (Integer w : graph.adj(v)) {
      if(visited[w] == -1){ // 没有被遍历
        dfs(w);
      }
    }
  }

  public int ccount(){
    return this.ccount;
  }

  public boolean isConnect(int v , int w){
    return visited[v] == visited[w];
  }

  public List<List<Integer>> component(){
    List<List<Integer>> components = new ArrayList<>();
    for (int i = 0; i < ccount; i++) {
      components.add(new ArrayList<>());
    }
    for (int i = 0; i < visited.length; i++) {
      components.get(visited[i]).add(i);
    }
    return components;

  }

  public static void main(String[] args) throws FileNotFoundException {
    Graph graph = new Graph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/g2.txt");
    GraphConnect graphConnect = new GraphConnect(graph);
    System.out.println(graphConnect.ccount());
    System.out.println(graphConnect.isConnect(1, 2));
    System.out.println(graphConnect.isConnect(0, 3));
    System.out.println(graphConnect.isConnect(4, 5));
    for (List<Integer> component : graphConnect.component()) {
      for (Integer v : component) {
        System.out.print(v);
        System.out.print(",");
      }
      System.out.println();
    }

  }

}
