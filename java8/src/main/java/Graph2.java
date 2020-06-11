import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class Graph2 {
  HashSet<Integer>[] node;
  int size;
  List<Integer> list = new ArrayList<>();
  boolean[] visited ;
  public Graph2(HashSet<Integer>[] node , int size){
    this.node = node;
    this.size = size;
    visited = new boolean[size];
  }

  public Iterable<Integer> adj(int i){
    return node[i];
  }

  public Iterable<Integer> preorderTraversal(){
    for (int i = 0; i < size; i++) {
      if(!visited[i]){
        dfs(i);
      }
    }
    return list;
  }

  private void dfs(int i){
    list.add(i);
    visited[i] = true;
    for (Integer w : adj(i)) {
      if(!visited[w]){
        dfs(w);
      }
    }
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

    Graph2 graph2 = new Graph2(node,4 );
    System.out.println(graph2.preorderTraversal());
  }
}
