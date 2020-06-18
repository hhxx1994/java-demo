import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class SingleSourcePath {

  int size;
  boolean[] visited;
  HashSet<Integer>[] node;
  int[] pre;
  int source;

  public SingleSourcePath(HashSet<Integer>[] node, int size, int source) {
    this.size = size;
    this.node = node;
    visited = new boolean[size];
    pre = new int[size];
    for (int i = 0; i < size; i++) {
      pre[i] = -1;
    }
    this.source = source;
    bfs(source);
  }

  private void bfs(int source) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited[source] = true;
    pre[source] = source;
    while (!queue.isEmpty()) {
      Integer node = queue.remove();
      for (Integer w : adj(node)) {
        if (!visited[w]) {
          queue.add(w);
          visited[w] = true;
          pre[w] = node;
        }
      }
    }
  }


  private boolean isConnected(int dest){
    return visited[dest];
  }

  public List<Integer> path(int desc){
    List<Integer> ret = new LinkedList<>();

    if (isConnected(desc)) {
      int pre = desc;
      ret.add(0,pre);
      while(pre != this.source){
        pre = this.pre[pre];
        ret.add(0,pre);
      }
    }
    return ret;
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

    SingleSourcePath singleSourcePath = new SingleSourcePath(node, 4, 0);
    List<Integer> path = singleSourcePath.path(3);
    for (Integer w : path) {
      System.out.println(w);
    }
  }


}
