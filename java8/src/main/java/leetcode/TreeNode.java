package leetcode;

public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){
    }
    public TreeNode(Integer val){
      this.val = val;
    }

  @Override
  public boolean equals(Object obj) {
      if(obj instanceof  TreeNode){
        return ((TreeNode) obj).val.equals(this.val);
      }
    return false;

  }
}