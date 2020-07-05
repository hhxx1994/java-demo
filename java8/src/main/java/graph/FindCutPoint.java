package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class FindCutPoint {
  Graph graph;
  int[] ord;
  int[] low;
  boolean[] visited;
  int ret;
  Set<Integer> cutPoint;

  public FindCutPoint(Graph graph) {
    this.graph = graph;
    ord = new int[graph.V];
    low = new int[graph.V];
    visited = new boolean[graph.V];
    cutPoint = new HashSet<>();
  }

  private void dfs(int v, int parent) {
    visited[v] = true;
    ord[v] = ret;
    low[v] = ret;
    ret ++;
    int child = 0;
    for (Integer w : graph.adj(v)) {
      if(!visited[w]){
        dfs(w,v);
        low[v] = Math.min(low[v],low[w]);
        if(v != parent && low[w] >= low[v]){
          cutPoint.add(v);
        }

        child++;
        if(v == parent && child > 1){
          cutPoint.add(v);
        }

      }else if(w != parent){
        low[v] = Math.min(low[v],low[w]);
      }
    }
  }
}
