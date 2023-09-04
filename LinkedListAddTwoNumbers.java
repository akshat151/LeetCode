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

public class LinkedListAddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode carry = new ListNode(0);
        ListNode dummy = answer;

        while(l1 != null && l2 != null){
            if(l1.val + l2.val + carry.val <= 9){
                dummy.val = l1.val + l2.val + carry.val;
                carry.val = 0;
            } else {
                dummy.val = (l1.val + l2.val + carry.val)%10;
                carry.val = (l1.val + l2.val + carry.val)/10;
            }
            l1 = l1.next;
            l2 = l2.next;
            if(l1 != null && l2 != null){
                dummy.next = new ListNode();
                dummy = dummy.next;
            } else if (l1 == null && l2 == null && carry.val>0) {
                dummy.next = new ListNode();
                dummy = dummy.next;
                dummy.val = carry.val;
            }
        }
        if(l1 != null){
            dummy.next = new ListNode();
            dummy = dummy.next;
            while(l1 != null){
                if(l1.val + carry.val <= 9){
                    dummy.val = l1.val + carry.val;
                    carry.val = 0;
                } else {
                    dummy.val = (l1.val + carry.val)%10;
                    carry.val = (l1.val + carry.val)/10;
                }
                l1 = l1.next;
                if(l1 != null){
                    dummy.next = new ListNode();
                    dummy = dummy.next;
                } else if (carry.val>0) {
                    dummy.next = new ListNode();
                    dummy = dummy.next;
                    dummy.val = carry.val;
                }
            }
        }
        if(l2 != null){
            dummy.next = new ListNode();
            dummy = dummy.next;
            while(l2 != null){
                if(l2.val + carry.val <= 9){
                    dummy.val = l2.val + carry.val;
                    carry.val = 0;
                } else {
                    dummy.val = (l2.val + carry.val)%10;
                    carry.val = (l2.val + carry.val)/10;
                }
                l2 = l2.next;
                if(l2 != null){
                    dummy.next = new ListNode();
                    dummy = dummy.next;
                } else if (carry.val>0) {
                    dummy.next = new ListNode();
                    dummy = dummy.next;
                    dummy.val = carry.val;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        LinkedListAddTwoNumbers solution = new LinkedListAddTwoNumbers();

        // Example 1
        ListNode l1 = new ListNode(8, new ListNode(6));
        ListNode l2 = new ListNode(6, new ListNode(4, new ListNode(8)));
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        printLinkedList(result1); // Output: [7,0,8]

        // Example 2
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        printLinkedList(result2); // Output: [0]

        // Example 3
        ListNode l5 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result3 = solution.addTwoNumbers(l5, l6);
        printLinkedList(result3); // Output: [8,9,9,9,0,0,0,1]
    }

    private static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
