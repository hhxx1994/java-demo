import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class GraphBFS {
  HashSet<Integer>[] node;
  int size;
  boolean[] visited;


  public GraphBFS(HashSet<Integer>[] node, int size) {
    this.node = node;
    this.size = size;
    visited = new boolean[size];
    for (int i = 0; i < size; i++) {
      if (!visited[i]) {
        bfs(i);
      }
    }

  }

  public void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visited[v] = true;
    while (!queue.isEmpty()) {
      Integer node = queue.remove();
      for (Integer w : adj(node)) {
        if (!visited[w]) {
          queue.add(w);
          visited[w] = true;
        }
      }
    }
  }


  public Iterable<Integer> adj(int i) {
    return node[i];
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

    GraphBFS graph2 = new GraphBFS(node, 4);


  }
}
