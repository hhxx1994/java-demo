package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class TreePath {
  TreeNode root;
  int[] pre;
  public TreePath(TreeNode root , int v){
    this.root = root;
    pre = new int[v];
    for (int i : pre) {
      pre[i] = i;
    }
    dfs(root,root);
    for (int i : pre) {
      System.out.println(i);
    }
  }

  private void dfs(TreeNode node , TreeNode parent){
      if(node == null)
         return;
      pre[node.val] = parent.val;
      dfs(node.left , node);
      dfs(node.right, node);

  }

  public List<Integer> path(int fromVal , int toVal){
    List<Integer> path = new ArrayList<>();
    while(toVal != fromVal){
      int pre = this.pre[toVal];
      path.add(0,pre);
      toVal = pre;
    }

    return  path;
  }

  public static void main(String[] args) {
    Array2Tree array2Tree = new Array2Tree();
    TreeNode treeNode = array2Tree.buildTree2(new Integer[]{0, 1, 2, 3, 4, 5, 6});
    TreePath treePath = new TreePath(treeNode, 7);
//    List<Integer> path = treePath.path(1, 4);
//    for (Integer integer : path) {
//      System.out.println(integer);
//    }
  }


}
