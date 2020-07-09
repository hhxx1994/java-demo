package graph;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author huanghaoxing
 */
public class StronglyComponentCount {

  DirectedGraph graph;
  int ccount = 0;
  List<List<Integer>> components = new ArrayList<>();
  Set<Integer> visited = new HashSet<>();
  DirectedGraph reverseGraph;

  public StronglyComponentCount(DirectedGraph graph) {
    this.graph = graph;
    reverseGraph = graph.reverseGraph();
    List<Integer> post = reverseGraph.post();
    Collections.reverse(post);

    for (Integer v : post) {
      if (!visited.contains(v)) {
        ccount++;
        List<Integer> ret = new ArrayList<>();
        postDfs(v, ret);
        components.add(ret);
      }
    }
  }

  private void postDfs(int v, List<Integer> ret) {
    visited.add(v);
    Set<Integer> vertex = graph.adj.get(v);
    if (vertex != null) {
      for (Integer w : vertex) {
        if (!visited.contains(w)) {
          postDfs(w, ret);
        }
      }
    }
    ret.add(v);
  }

  public static void main(String[] args) throws FileNotFoundException {
    DirectedGraph directedGraph = new DirectedGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/scc.txt");
    StronglyComponentCount stronglyComponentCount = new StronglyComponentCount(directedGraph);
    System.out.println(stronglyComponentCount.ccount);
    for (List<Integer> component : stronglyComponentCount.components) {
      for (Integer c : component) {
        System.out.print(c + ",");
      }
      System.out.println();
    }
  }


}
