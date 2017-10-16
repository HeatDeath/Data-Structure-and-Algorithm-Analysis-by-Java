package leetcode_linked_list;

public class mergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode l3 = head;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				l3.next = l2;
				l2 = l2.next;
			}else {
				l3.next = l1;
				l1 = l1.next;
			}
            l3 = l3.next;
		}
		
		if(l2 == null){
	        l3.next = l1;
	    } else {
	        l3.next = l2;
	    }
		return head.next;
	}
}
