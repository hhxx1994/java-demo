package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class EulerLoop {
  Graph graph;
  boolean eulerLoop = true;
  List<Integer> ret = new ArrayList<>();

  public EulerLoop(Graph graph) {
    this.graph = graph;
    for (int i = 0; i < graph.V; i++) {
      if(graph.degree(i) % 2 == 1){
        eulerLoop = false;
        break;
      }
    }
  }

  public List<Integer> eulerPath(){
    List<Integer> path = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();
    stack.add(0);
    int cur = 0;
    while(!stack.isEmpty()){
      if(graph.degree(cur) > 0){
        stack.push(cur);
        Integer w = graph.adj(cur).iterator().next();
        graph.deleteEdge(cur,w);
        cur = w;
      }else{
        path.add(cur);
        cur = stack.pop();
      }
    }
    return path;
  }

  public List<Integer> eulerPath2(){
    path(0);
    return ret;
  }


  private void path(int v){
    while (graph.degree(v) > 0){
      Integer w = graph.adj(v).iterator().next();
      graph.deleteEdge(v,w);
      path(w);
    }
    ret.add(v);
  }


  public static void main(String[] args) throws FileNotFoundException {
    Graph graph = new Graph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/euler.txt");
    EulerLoop eulerLoop = new EulerLoop(graph);
    List<Integer> path = eulerLoop.eulerPath2();
    for (Integer p : path) {
      System.out.println(p);
    }
  }


}
