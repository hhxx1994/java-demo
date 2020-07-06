package graph;

/**
 * @author huanghaoxing
 */
public class UnionFind {
  int[] parent;
  int[] rank;

  public UnionFind(int size) {
    parent = new int[size];
    rank = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  public boolean isConnect(int q, int p) {
    return false;
  }

  public int find(int p) {
    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }

  public void union(int q, int p) {
    int qRoot = find(q);
    int pRoot = find(p);
    if (rank[qRoot] < rank[pRoot]) {
      parent[qRoot] = pRoot;
    } else if (rank[pRoot] < rank[qRoot]) {
      parent[pRoot] = qRoot;
    } else {
      parent[pRoot] = qRoot;
      rank[qRoot] += 1;
    }
  }

}
