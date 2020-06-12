import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class Graph3 {
  HashSet<Integer>[] node;
  int size;
  List<Integer> list = new ArrayList<>();
  int[] visited;
  int ccount = 0;
  public Graph3(HashSet<Integer>[] node , int size){
    this.node = node;
    this.size = size;
    visited = new int[size];
    for (int i = 0; i < size; i++) {
      visited[i] = -1;
    }
  }

  public Iterable<Integer> adj(int i){
    return node[i];
  }

  public Iterable<Integer> preorderTraversal(){
    for (int i = 0; i < size; i++) {
      if(visited[i] == -1){
        dfs(i,ccount);
        ccount++;
      }
    }
    return list;
  }

  private void dfs(int i , int ccount){
    list.add(i);
    visited[i] = ccount;
    for (Integer w : adj(i)) {
      if(visited[w] == -1){
        dfs(w,ccount);
      }
    }
  }

  public boolean isConnected(int v , int w){
    return visited[v] == visited[w];
  }

  public List<Integer>[] component(){
    List<Integer>[] ret = new List[ccount];

    for (int i = 0; i < visited.length; i++) {
      if(ret[visited[i]] == null){
        ret[visited[i]] = new ArrayList<>();
      }
      ret[visited[i]].add(i);
    }
    return ret;
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

    Graph3 graph2 = new Graph3(node,4 );
    System.out.println(graph2.preorderTraversal());
    System.out.println(graph2.isConnected(0, 3));
    for (List<Integer> integers : graph2.component()) {
      for (Integer integer : integers) {
        System.out.print(integer);
      }
      System.out.println();
    }
  }
}
