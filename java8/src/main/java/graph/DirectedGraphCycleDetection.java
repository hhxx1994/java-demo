package graph;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class DirectedGraphCycleDetection {

  DirectedGraph graph;
  boolean isCycle = false;
  Set<Integer> visited;
  Set<Integer> inPath;

  public DirectedGraphCycleDetection(DirectedGraph graph) {
    this.graph = graph;
    visited = new HashSet<>();
    inPath = new HashSet<>();
    for (Integer v : graph.adj.keySet()) {
      if (!visited.contains(v)) {
        if (dfs(v)) {
          isCycle = true;
          break;
        }
      }
    }
  }

  private boolean dfs(int v) {
    visited.add(v);
    inPath.add(v);
    Set<Integer> vertex = graph.adj.get(v);
    if (vertex != null) {
      for (Integer w : vertex) {
        if (!visited.contains(w)) {
          if (dfs(w)) {
            return true;
          }
        } else if (inPath.contains(w)) {
          return true;
        }
      }
    }
    inPath.remove(v);
    return false;
  }

  public static void main(String[] args) throws FileNotFoundException {
    DirectedGraph directedGraph = new DirectedGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/directedGraph.txt");
    DirectedGraphCycleDetection directedGraphCycleDetection = new DirectedGraphCycleDetection(directedGraph);
    System.out.println(directedGraphCycleDetection.isCycle);
  }

}
