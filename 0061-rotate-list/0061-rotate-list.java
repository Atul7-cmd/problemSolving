class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null) return head;

        ListNode temp = head;
        int n = 0;

        while (temp != null) {
            temp = temp.next;
            n++;
        }

        k = k % n;

      
        if (k == 0) return head;

        ListNode newTail = head;

        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        ListNode oldTail = newHead;

        while (oldTail.next != null) {
            oldTail = oldTail.next;
        }

        oldTail.next = head;

        return newHead;
    }
}