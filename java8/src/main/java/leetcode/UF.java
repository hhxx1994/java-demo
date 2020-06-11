package leetcode;

/**
 * @author huanghaoxing
 */
public class UF {

  int[] parent;
  int[] rank;

  public UF(int size) {
    parent = new int[size];
    rank = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    if(p < 0 || p> parent.length){
      throw new IllegalArgumentException("...");
    }
    while (p != parent[p]) {
        parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if(pRoot == qRoot){
      return;
    }
    if(rank[pRoot] < rank[qRoot]){
      parent[pRoot] = qRoot;
    }else if(rank[qRoot] < rank[pRoot]){
      parent[qRoot]  = pRoot;
    }else{
      parent[pRoot] = qRoot;
      rank[qRoot] += 1;
    }
  }

}
