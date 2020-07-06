package graph;

/**
 * @author huanghaoxing
 */
public class WeightEdge implements Comparable<WeightEdge> {
  int v;
  int w;
  int weight;
  public WeightEdge(int v, int w , int weight){
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  @Override
  public int compareTo(WeightEdge o) {
    return weight - o.weight;
  }
}
