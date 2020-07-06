package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class UnionFindMap {

  Map<Integer, Integer> parent = new HashMap<>();
  Map<Integer, Integer> rank = new HashMap<>();

  public boolean isConnect(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    while(p != getParent(p)){
      parent.put(p,getParent(getParent(p)));
      p = getParent(p);
    }
    return p;
  }

  private int getParent(int p){
    return parent.get(p) == null ? p : parent.get(p);
  }

  public void union(int q, int p) {
    int qRoot = find(q);
    int pRoot = find(p);
    int qRank = rank.get(q) == null ? 1 : rank.get(q);
    int pRank = rank.get(p) == null ? 1: rank.get(p);
    if(qRank < pRank){
      parent.put(qRoot,pRoot);
    }else if(pRank < qRank){
      parent.put(pRoot,qRoot);
    }else {
      parent.put(pRoot,qRoot);
      rank.put(qRoot,qRank + 1);
    }
  }

  public static void main(String[] args) {
    UnionFindMap unionFindMap = new UnionFindMap();
    unionFindMap.union(2,3);
    unionFindMap.union(6,7);
    System.out.println(unionFindMap.isConnect(2, 7));
    unionFindMap.union(2,6);
    System.out.println(unionFindMap.isConnect(2, 7));

  }
}
