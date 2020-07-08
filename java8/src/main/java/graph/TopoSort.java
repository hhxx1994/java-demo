package graph;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author huanghaoxing
 */
public class TopoSort {
  DirectedGraph graph;

  Map<Integer, Integer> inDegree;
  List<Integer> ret;
  boolean isCycle;

  public TopoSort(DirectedGraph graph) {
    this.graph = graph;
    ret = new ArrayList<>();
    inDegree = new HashMap<>(graph.inDegree);
    Queue<Integer> queue = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) {
        queue.add(entry.getKey());
      }
    }

    while (!queue.isEmpty()) {
      Integer v = queue.remove();
      ret.add(v);
      Set<Integer> vertex = graph.adj.get(v);
      if (vertex != null) {
        for (Integer w : vertex) {
          int newInDegree = inDegree.get(w) - 1;
          if (newInDegree == 0) {
            queue.add(w);
          }
          inDegree.put(w, newInDegree);
        }
      }
    }

    if (ret.size() != graph.V) {
      ret.clear();
      isCycle = true;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    DirectedGraph directedGraph = new DirectedGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/toposort.txt");
    TopoSort topoSort = new TopoSort(directedGraph);
    System.out.println(topoSort.isCycle);
    if (!topoSort.isCycle) {
      for (Integer path : topoSort.ret) {
        System.out.println(path);
      }
    }
  }
}
