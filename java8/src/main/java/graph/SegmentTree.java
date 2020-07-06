package graph;

/**
 * @author huanghaoxing
 */
public class SegmentTree<E> {
  E[] data;
  E[] tree;
  Merge<E> merge;

  public SegmentTree(E[] data) {
    this.data = (E[]) new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      this.data[i] = data[i];
    }
    tree = (E[]) new Object[4 * data.length];
    buildSegment(0, 0, data.length - 1);
  }

  private void buildSegment(int index, int l, int r) {
    if (l == r) {
      tree[index] = data[index];
      return;
    }

    int mid = l + (r - l) / 2;
    int leftIndex = leftIndex(index);
    int rightIndex = rightIndex(index);
    buildSegment(leftIndex, l, mid);
    buildSegment(rightIndex, mid + 1, r);
    tree[index] = merge.merge(tree[leftIndex], tree[rightIndex]);
  }

  private int leftIndex(int index) {
    return index * 2 + 1;
  }

  private int rightIndex(int index) {
    return index * 2 + 2;
  }

  public E query(int queryL, int queryR) {
    return query(0, 0, data.length - 1, queryL, queryR);
  }

  private E query(int index, int l, int r, int queryL, int queryR) {
    if (l == queryL && r == queryR) {
      return tree[index];
    }

    int mid = l + (r - l) / 2;

    int leftIndex = leftIndex(index);
    int rightIndex = rightIndex(index);
    if (mid + 1 <= queryL) {
      return query(leftIndex, mid + 1, r, queryL, queryR);
    } else if (queryR <= mid) {
      return query(rightIndex, l, mid, queryL, queryR);
    }
    E leftE = query(leftIndex, l, mid, queryL, queryR);
    E rightE = query(rightIndex, mid + 1, r, queryL, queryR);
    return merge.merge(leftE, rightE);
  }

  public void update(int index, E data) {
    this.data[index] = data;

  }

  private void update(int treeIndex, int l, int r, int index, E data) {
    if (l == r) {
      tree[treeIndex] = data;
      return;
    }
    int mid = l + (r - l) / 2;
    int leftIndex = leftIndex(treeIndex);
    int rightIndex = rightIndex(treeIndex);
    if (mid + 1 <= index) {
      update(rightIndex, mid + 1, r, index, data);
    } else {
      update(leftIndex, l, mid, index, data);
    }
    tree[treeIndex] = merge.merge(tree[leftIndex], tree[rightIndex]);
  }

}
