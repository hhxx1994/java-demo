package graph;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class Dijkstra {
  WeightGraph graph;
  int[] dis;
  boolean[] visited;

  public Dijkstra(WeightGraph graph) {
    this.graph = graph;
    dis = new int[graph.V];
    visited = new boolean[graph.V];
    Arrays.fill(dis,Integer.MAX_VALUE);
    dis[0] = 0;
    while (true) {
      int cur = -1;
      int minDis = Integer.MAX_VALUE;
      for (int i = 0; i < graph.V; i++) {
        if (!visited[i] && dis[i] < minDis) {
          cur = i;
          minDis = dis[i];
        }
      }

      if(cur == -1)
        break;
      visited[cur] = true;
      for (Integer w : graph.adj(cur).keySet()) {
        if(!visited[w] && dis[cur] + graph.adj(cur).get(w) < dis[w]){
          dis[w] = dis[cur] + graph.adj(cur).get(w);
        }
      }
    }
  }

  public int[] dis(){
    return dis;
  }

  public static void main(String[] args) throws FileNotFoundException {
    WeightGraph weightGraph = new WeightGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/dijkstra.txt");
    Dijkstra dijkstra = new Dijkstra(weightGraph);
    int[] dis = dijkstra.dis();
    for (int d : dis) {
      System.out.println(d);
    }
  }

}
