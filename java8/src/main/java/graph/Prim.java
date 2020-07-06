package graph;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author huanghaoxing
 */
public class Prim {

  WeightGraph graph;
  List<WeightEdge> ret = new ArrayList<>();
  public Prim(WeightGraph graph) {
    this.graph = graph;
    Integer start = graph.adj.keySet().iterator().next();
    Queue<WeightEdge> queue = new PriorityQueue<>();
    TreeMap<Integer, Integer> adj = graph.adj(start);
    for (Integer v : adj.keySet()) {
      queue.add(new WeightEdge(start,v ,adj.get(v)));
    }
    boolean[] visited = new boolean[graph.V];
    visited[start] = true;
    while(!queue.isEmpty()){
      WeightEdge minEdge = queue.remove();
      if (visited[minEdge.v] && visited[minEdge.w]) {
          continue;
      }
      ret.add(minEdge);
      int w = visited[minEdge.v] ? minEdge.w : minEdge.v;
      visited[w] = true;
      for (Integer ww : graph.adj(w).keySet()) {
        queue.add(new WeightEdge(w,ww,graph.adj(w).get(ww)));
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    WeightGraph graph = new WeightGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/kruskal.txt");
    Prim prim = new Prim(graph);
    List<WeightEdge> weightEdges = prim.ret;
    for (WeightEdge weightEdge : weightEdges) {
      System.out.println(weightEdge.v +"-" + weightEdge.w +" -- " + weightEdge.weight);
    }
  }
}
