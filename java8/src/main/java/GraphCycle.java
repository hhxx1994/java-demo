import java.util.HashSet;

/**
 * @author huanghaoxing
 */
public class GraphCycle {
  HashSet<Integer>[] node;
  int size;
  boolean[] visited;
  int[] parent;

  public GraphCycle(HashSet<Integer>[] node , int size){
    this.node = node;
    this.size = size;
    visited = new boolean[size];
    parent = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = -1;
    }
  }

  public Iterable<Integer> adj(int i){
    return node[i];
  }

  public boolean isCycle(){
    for (int i = 0; i < size; i++) {
      if(!visited[i]){
        if (dfs(i,i)) {
          return true;
        }
      }
    }
    return false;
  }



  private boolean dfs(int i , int  parent){
    visited[i] = true;
    this.parent[i] = parent;
    for (Integer w : adj(i)) {
      if(!visited[w]){
        if (dfs(w,i)) {
          return true;
        }
      }else if(this.parent[w] != i){
        return true;
      }
    }
    return false;
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

    GraphCycle graph2 = new GraphCycle(node,4 );

    System.out.println(graph2.isCycle());

  }
}
