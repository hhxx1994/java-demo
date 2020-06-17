import java.util.HashSet;

/**
 * @author huanghaoxing
 */
public class GraphBipartition {
  HashSet<Integer>[] node;
  int size;
  boolean[] visited;
  int[] color;
  boolean isBipartition = true;

  public GraphBipartition(HashSet<Integer>[] node, int size) {
    this.node = node;
    this.size = size;
    visited = new boolean[size];
    color = new int[size];
    for (int i = 0; i < size; i++) {
      color[i] = -1;
    }
    for (int i = 0; i < size; i++) {
      if (!visited[i] ) {
        if(!dfs(i, 0)){
          isBipartition = false;
          break;
        }
      }
    }
  }

  public Iterable<Integer> adj(int i) {
    return node[i];
  }

  private boolean dfs(int i, int color) {
    visited[i] = true;
    this.color[i] = color;
    for (Integer w : adj(i)) {
      if (!visited[w]) {
        if (!dfs(w, 1 - color)) {
          return false;
        }
      } else if (this.color[w] == color) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    HashSet<Integer>[] node = new HashSet[4];
    HashSet<Integer> node0 = new HashSet<>();
    node0.add(1);
    node0.add(2);
    node[0] = node0;

    HashSet<Integer> node1 = new HashSet<>();
    node1.add(0);
    node1.add(3);
    node[1] = node1;


    HashSet<Integer> node2 = new HashSet<>();
    node2.add(0);
    node2.add(3);
    node[2] = node2;

    HashSet<Integer> node3 = new HashSet<>();
    node3.add(1);
    node3.add(2);
    node[3] = node3;

    GraphBipartition graph2 = new GraphBipartition(node, 4);

    System.out.println(graph2.isBipartition);

  }
}
