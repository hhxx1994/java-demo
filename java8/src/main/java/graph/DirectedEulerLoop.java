package graph;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huanghaoxing
 */
public class DirectedEulerLoop {
  DirectedGraph graph;
  LinkedList<Integer> path;

  public DirectedEulerLoop(DirectedGraph graph) {
    this.graph = graph;
    path = new LinkedList<>();
  }

  public void eulerLoop() {
    Deque<Integer> stack = new LinkedList<>();
    stack.push(0);
    int curv = 0;
    while (!stack.isEmpty()) {
      if (graph.outDegree(curv) > 0) {
        stack.push(curv);
        Integer w = graph.adj.get(curv).iterator().next();
        graph.deleteEdge(curv, w);
        curv = w;
      } else {
        path.addFirst(curv);
        curv = stack.pop();
      }
    }
  }

  public void eulerPath(int v){
    while(graph.outDegree(v) > 0){
      Integer w = graph.adj.get(v).iterator().next();
      graph.deleteEdge(v,w);
      eulerPath(w);
    }
    path.addFirst(v);
  }

  private boolean isEulerGraph() {
    for (Integer v : graph.adj.keySet()) {
      if (graph.inDegree(v) != graph.outDegree(v)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws FileNotFoundException {
    DirectedGraph directedGraph = new DirectedGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/directedEulerLoop.txt");
    DirectedEulerLoop directedEulerLoop = new DirectedEulerLoop(directedGraph);
    directedEulerLoop.eulerPath(0);
    LinkedList<Integer> eulerPath = directedEulerLoop.path;
    for (Integer path : eulerPath) {
      System.out.println(path);
    }
  }
}
