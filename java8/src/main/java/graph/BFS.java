package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class BFS {
  Graph graph;
  boolean[] visited;

  public BFS(Graph graph) {
    this.graph=graph;
    visited = new boolean[graph.V];
    for (int i = 0; i < graph.V; i++) {
      if (!visited[i]) {
        bfs(i);
      }
    }

  }

  private void bfs(int v) {
    Queue<Integer>  queue = new LinkedList<>();
    queue.add(v);
    visited[v] = true;
    while (!queue.isEmpty()) {
      Integer temp = queue.remove();
      for (Integer w : graph.adj(temp)) {
        if (!visited[w]) {
          queue.add(w);
          visited[w] = true;
        }
      }
    }
  }
}
