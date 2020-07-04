package graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class USSSPath {
  Graph graph;
  int s;
  boolean[] visited;
  int[] pre;
  int[] dis;

  public USSSPath(Graph graph , int s) {
    this.graph = graph;
    this.s = s;
    visited = new boolean[graph.V];
    pre = new int[graph.V];
    dis = new int[graph.V];
    for (int i = 0; i < graph.V; i++) {
      pre[i] = -1;
      dis[i] = 0;
    }
    bfs(s);
  }

  private void bfs(int s) {
    Queue<Integer>  queue = new LinkedList<>();
    queue.add(s);
    dis[s] = 0;
    pre[s] = s;
    visited[s] = true;
    while (!queue.isEmpty()) {
      Integer v = queue.remove();
      for (Integer w : graph.adj(v)) {
        if (!visited[w]) {
          queue.add(w);
          visited[w]= true;
          pre[w]= v;
          dis[w] = dis[v] + 1;
        }
      }
    }
  }

  private boolean isConnect(int d){
    return visited[d];
  }

  public List<Integer> path(int d) {
    LinkedList<Integer> path = new LinkedList<>();
    if (!isConnect(d)) {
      return path;
    }
    path.addFirst(d);
    while(s != d){
      path.addFirst(pre[d]);
      d = pre[d];
    }
    return path;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Graph graph = new Graph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/USSSPath.txt");
    USSSPath usssPath = new USSSPath(graph, 0);
    List<Integer> path = usssPath.path(5);
    for (Integer p : path) {
      System.out.println(p);
    }

  }





}
