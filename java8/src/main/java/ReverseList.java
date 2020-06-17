/**
 * @author huanghaoxing
 */
public class ReverseList {

  public static class Node {
    public int val;
    public Node next;
  }

  public Node reverse(Node head){
    if(head == null || head.next == null){
      return head;
    }
    Node  next = head.next;
    head.next = null;
    while(next != null){
      Node temp = next.next;
      next.next = head;
      head = next;
      next = temp;
    }
    return head;
  }

  public static void main(String[] args) {
    ReverseList reverseList = new ReverseList();
    Node node = new Node();
    node.val = 1;
    Node node1 = new Node();
    node1.val = 2;
    node.next = node1;

//    Node node2 = new Node();
//    node2.val = 3;
//    node1.next = node2;

    Node reverse = reverseList.reverse(node);
    while(reverse != null){
      System.out.println(reverse.val);
      reverse = reverse.next;
    }
  }

}
