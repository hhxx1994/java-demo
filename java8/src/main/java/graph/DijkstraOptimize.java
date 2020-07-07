package graph;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author huanghaoxing
 */
public class DijkstraOptimize {
  WeightGraph graph;
  int s;
  int[] dis;
  int[] pre;
  boolean[] visited;

  private class Node implements Comparable<Node>{
    int v;
    int dis;

    public Node(int v, int dis) {
      this.v = v;
      this.dis = dis;
    }

    @Override
    public int compareTo(DijkstraOptimize.Node o) {
      return dis - o.dis;
    }
  }

  public DijkstraOptimize(WeightGraph graph , int s) {
    this.graph = graph;
    this.s = s;
    dis = new int[graph.V];
    pre = new int[graph.V];
    visited = new boolean[graph.V];
    Arrays.fill(dis,Integer.MAX_VALUE);
    dis[s] = 0;
    pre[s] = s;
    Queue<Node> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(new Node(s, 0));
    while (!priorityQueue.isEmpty()) {
      Node cur = priorityQueue.remove();
      if(visited[cur.v]){
        continue;
      }

      visited[cur.v] = true;
      for (Integer w : graph.adj(cur.v).keySet()) {
        if(!visited[w] && cur.dis + graph.adj(cur.v).get(w) < dis[w]){
          dis[w] = cur.dis + graph.adj(cur.v).get(w);
          priorityQueue.add(new Node(w,dis[w]));
          pre[w] = cur.v;
        }
      }
    }
  }

  public boolean isConnectTo(int v) {
    return visited[v];
  }

  public int disTo(int v){
    return dis[v];
  }

  public List<Integer> path(int v){
    LinkedList<Integer> path = new LinkedList<>();
    path.addFirst(v);
    while(s != v){
      path.addFirst(pre[v]);
      v = pre[v];
    }
    return path;
  }

  public static void main(String[] args) throws FileNotFoundException {
    WeightGraph weightGraph = new WeightGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/dijkstra.txt");
    DijkstraOptimize dijkstra = new DijkstraOptimize(weightGraph,0);
    System.out.println(dijkstra.disTo(4));
    for (Integer p : dijkstra.path(4)) {
      System.out.println(p);
    }
  }


}
