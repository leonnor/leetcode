package tiku;

/**
 * className Q237
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019/7/11 19:17
 */
public class Q237 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {

            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
