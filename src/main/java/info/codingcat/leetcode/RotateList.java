package info.codingcat.leetcode;

/**
 * RotateList
 */
public class RotateList {

    public static void main(String[] args) {
        RotateList l = new RotateList();
        ListNode head = arrayToList(new int[]{0, 1, 2});
        System.out.println(listToString(l.rotateRight(head, 4)));
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }
        
        ListNode bp = head;

        int idx = 1;
        int len = 0;

        ListNode currNode = head;

        while (currNode != null) {
            len ++;
            currNode = currNode.next;
        }

        k = k % len;
        currNode = head;

        while (currNode.next != null) {
            if (idx > k) {
                bp = bp.next;
            }
            idx ++;
            currNode = currNode.next;
        }


        currNode.next = head;
        ListNode r = bp.next;
        bp.next = null;
        return r;

    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static String listToString(ListNode n) {
        StringBuilder s = new StringBuilder();
        while(n != null) {
            s.append(String.valueOf(n.val));
            if(n.next != null) {
                s.append(", ");
            }
            n = n.next;
        }
        return s.toString();
    }

    public static ListNode arrayToList(int[] array) {
        ListNode head = null;
        ListNode curr = null;
        for(int i : array) {
            if(curr == null) {
                curr = new ListNode(i);
                head = curr;
            } else {
                curr.next = new ListNode(i);
                curr = curr.next;
            }
        }
        return head;
    }
}