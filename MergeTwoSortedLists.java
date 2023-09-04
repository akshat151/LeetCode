// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if (list1 != null) {
            dummy.next = list1;
        } else if (list2 != null) {
            dummy.next = list2;
        }
        return t.next;
    }


    public static void main(String[] args) {
        MergeTwoSortedLists merger = new MergeTwoSortedLists();

        // Example 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList1 = merger.mergeTwoLists(list1, list2);
        printList(mergedList1);
        // Example 2
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = merger.mergeTwoLists(list3, list4);
        printList(mergedList2);
        // Example 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode mergedList3 = merger.mergeTwoLists(list5, list6);
        printList(mergedList3);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}


