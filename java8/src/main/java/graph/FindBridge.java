package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class FindBridge {
  Graph graph;
  int[] ord;
  int[] low;
  int ret = 0;
  List<Edge> bridge;
  boolean[] visited;

  public FindBridge(Graph graph){
    this.graph = graph;
    bridge = new ArrayList<>();
    visited = new boolean[graph.V];
    ord = new int[graph.V];
    low = new int[graph.V];
    dfs(0,0);
  }


  private void dfs(int v , int parent){
    visited[v] = true;
    ord[v] = ret;
    low[v] = ret;
    ret++;
    for (Integer w : graph.adj(v)) {
      if(!visited[w]){
        dfs(w,v);
        low[v] = Math.min(low[v],low[w]);
        if(low[w] > ord[v] ){
          bridge.add(new Edge(v,w));
        }
      }else if(w != parent){
        low[v] = Math.min(low[v], low[w]);
      }
    }
  }

  public List<Edge> bridge(){
    return bridge;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Graph graph = new Graph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/bridge.txt");
    FindBridge findBridge = new FindBridge(graph);
    List<Edge> bridge = findBridge.bridge();
    for (Edge edge : bridge) {
      System.out.println(edge.v + " -->" + edge.w);
    }

  }


}
