package leetcode;

/**
 * @author huanghaoxing
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode temp = new ListNode(-1);
      ListNode head = temp;
      while(l1 != null && l2 != null){
        if(l1.val < l2.val){
          temp.next = l1;
          l1 = l1.next;
          temp = temp.next;
        }else{
          temp.next = l2;
          l2 = l2.next;
          temp = temp.next;
        }
      }
      if(l1 != null)
        temp.next = l1;
      else
        temp.next = l2;

      return head.next;
  }

  public ListNode sortList(ListNode head) {
      if(head == null || head.next == null)
          return  head;
      ListNode midNode = partition(head);
    ListNode rightNode = midNode.next;
    midNode.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(rightNode);

    return merge(left,right);
  }

  public ListNode merge(ListNode l1 , ListNode l2){
      ListNode temp = new ListNode(-1);
      ListNode head = temp;
      while(l1 != null && l2 != null){
        if(l1.val < l2.val){
          temp.next = l1;
          l1 = l1.next;
          temp = temp.next;
        }else{
          temp.next = l2;
          l2 = l2.next;
          temp = temp.next;
        }
      }
      if(l1 != null)
          temp.next = l1;
      else
        temp.next = l2;

      return  head.next;
  }


  private ListNode partition(ListNode node){
      ListNode fast = node.next;
      ListNode slow = node;
      while(fast != null && fast.next != null){
        slow = slow.next;
        fast= fast.next.next;
      }
      return slow;
  }


    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        //1->2->3->4->5->NULL
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode listNode = reverseList.reverseList(one);
        while(listNode != null){
          System.out.println(listNode.val);
          listNode = listNode.next;
        }


    }
}
