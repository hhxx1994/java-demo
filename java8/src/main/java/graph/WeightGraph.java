package graph;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author huanghaoxing
 */
public class WeightGraph {
  int V;
  int E;
  Map<Integer, TreeMap<Integer,Integer>> adj;

  public WeightGraph(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    V = scanner.nextInt();
    E = scanner.nextInt();
    adj = new HashMap<>();
    for (int i = 0; i < E; i++) {
      int v = scanner.nextInt();
      int w = scanner.nextInt();
      int weight = scanner.nextInt();
      TreeMap<Integer, Integer> v_weightEdge = adj.computeIfAbsent(v, k ->new TreeMap<>());
      v_weightEdge.put(w,weight);
      TreeMap<Integer, Integer> w_weightEdge = adj.computeIfAbsent(w, k ->new TreeMap<>());
      w_weightEdge.put(v,weight);
    }
  }


  public TreeMap<Integer, Integer> adj(int v) {
    return adj.get(v);
  }
}
