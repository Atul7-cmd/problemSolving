/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;//ek pointer bna lenge aur a-1 par le jaayenge
        }

        ListNode curr = prevA;//ek curr pointer banayege jo b+1 par le jaayenf  
        for (int i = 0; i < b - a + 2; i++) {
            curr = curr.next;
        }
        ListNode nextB = curr;

        prevA.next = list2;

        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = nextB;

        return list1;
    }
}