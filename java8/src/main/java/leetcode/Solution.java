package leetcode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) 
            return null;
        if(p.equals(q))
            return p;
        Deque<TreeNode> pQueue = new LinkedList<>();
        Deque<TreeNode> qQueue = new LinkedList<>();
        find(root,p,pQueue);
        find(root,q,qQueue);
        TreeNode pre = null;
        while(!pQueue.isEmpty() && !qQueue.isEmpty()){
            TreeNode pnode = pQueue.remove();
            TreeNode qnode = qQueue.remove();
            if(pnode.equals(qnode))
               pre = pnode;
            else
               break; 
            
        }
        return pre;
       
    }
    private boolean find(TreeNode root , TreeNode node , Deque<TreeNode> queue){
        if(root == null)
            return false;
        queue.addLast(root);
        if(root.equals(node))
            return true;
        if(find(root.left ,node , queue))
          return true;
        if(find(root.right,node , queue))
            return true;
       // queue.removeLast();
        return false;
    }

  public static void main(String[] args) {
    Array2Tree array2Tree = new Array2Tree();
    TreeNode treeNode = array2Tree.buildTree2(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    Solution solution = new Solution();
    solution.lowestCommonAncestor(treeNode,new TreeNode(5),new TreeNode(4));
  }
}