package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author huanghaoxing
 */
public class Kruskal {

  WeightGraph graph;
  List<WeightEdge> ret;

  public Kruskal(WeightGraph graph){
    this.graph = graph;
    List<WeightEdge> weightEdges = new ArrayList<>();
    ret = new ArrayList<>();
    for (Integer v : graph.adj.keySet()) {
      TreeMap<Integer, Integer> edges = graph.adj(v);
      for (Integer w : edges.keySet()) {
        if(v > w){
          WeightEdge weightEdge = new WeightEdge(v, w, edges.get(w));
          weightEdges.add(weightEdge);
        }
      }
    }
    Collections.sort(weightEdges);
    UnionFindMap unionFindMap = new UnionFindMap();
    for (WeightEdge weightEdge : weightEdges) {
      if (!unionFindMap.isConnect(weightEdge.v,weightEdge.w)) {
        ret.add(weightEdge);
        unionFindMap.union(weightEdge.v, weightEdge.w);
      }
    }
  }

  public List<WeightEdge> ret(){
    return ret;
  }

  public static void main(String[] args) throws FileNotFoundException {
    WeightGraph graph = new WeightGraph("/Users/huanghaoxing/source/java-demo/java8/src/main/java/graph/kruskal.txt");
    Kruskal kruskal = new Kruskal(graph);
    List<WeightEdge> weightEdges = kruskal.ret();
    for (WeightEdge weightEdge : weightEdges) {
      System.out.println(weightEdge.v +"-" + weightEdge.w +" -- " + weightEdge.weight);
    }
  }


}
