package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class Graph {

   int E;
   int V;
  private Set<Integer>[] adj;

  public Graph(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    int V = scanner.nextInt();
    int E = scanner.nextInt();
    this.V = V;
    this.E = E;
    adj = new Set[this.V];
    for (int i = 0; i < V; i++) {
      adj[i] = new HashSet<>();
    }

    for (int i = 0; i < E; i++) {
      int from = scanner.nextInt();
      int to  = scanner.nextInt();
      // 无向图
      adj[from].add(to);
      adj[to].add(from);
    }
  }

  public Integer degree(int v){
    return adj[v].size();
  }

  public void deleteEdge(int v , int w){
    adj(v).remove(w);
    adj(w).remove(v);
    E--;
  }

  public Set<Integer> adj(int i){
    return adj[i];
  }
}
