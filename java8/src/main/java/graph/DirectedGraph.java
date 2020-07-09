package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author huanghaoxing
 */
public class DirectedGraph {

  int V;
  int E;
  Map<Integer, Set<Integer>> adj;
  Map<Integer, Integer> inDegree;
  Map<Integer, Integer> outDegree;

  private DirectedGraph() {
  }

  public DirectedGraph(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    V = scanner.nextInt();
    E = scanner.nextInt();
    adj = new HashMap<>();
    inDegree = new HashMap<>();
    outDegree = new HashMap<>();
    for (int i = 0; i < E; i++) {
      int v = scanner.nextInt();
      int w = scanner.nextInt();
      Set<Integer> adjVertex = adj.computeIfAbsent(v, k -> new HashSet<>());
      adjVertex.add(w);
      inDegree.put(v, inDegree.getOrDefault(v, 0));
      outDegree.put(v, outDegree.getOrDefault(v, 0) + 1);
      inDegree.put(w, inDegree.getOrDefault(w, 0) + 1);
      outDegree.put(w, outDegree.getOrDefault(w, 0));
    }
  }

  public int inDegree(int v) {
    return inDegree.getOrDefault(v, 0);
  }

  public int outDegree(int v) {
    return outDegree.getOrDefault(v, 0);
  }

  public void deleteEdge(int v, int w) {
    E--;
    adj.get(v).remove(w);
    outDegree.put(v, outDegree.get(v) - 1);
    inDegree.put(w, inDegree.get(w) - 1);
  }

  public DirectedGraph reverseGraph() {
    DirectedGraph graph = new DirectedGraph();
    graph.V = V;
    graph.E = E;
    graph.adj = new HashMap<>();
    graph.inDegree = new HashMap<>();
    graph.outDegree = new HashMap<>();
    for (Integer v : adj.keySet()) {
      for (Integer w : adj.get(v)) {
        Set<Integer> vertex = graph.adj.computeIfAbsent(w, k -> new HashSet<>());
        vertex.add(v);
        graph.inDegree.put(w, graph.inDegree.getOrDefault(w, 0));
        graph.inDegree.put(v, graph.inDegree.getOrDefault(v, 0) + 1);
        graph.outDegree.put(w, graph.outDegree.getOrDefault(w, 0) + 1);
        graph.outDegree.put(v, graph.outDegree.getOrDefault(v, 0));
      }
    }
    return graph;
  }

}
