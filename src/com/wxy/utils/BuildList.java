package com.wxy.utils;

/**
 * Created by Cser_W on 2018/4/12.
 */

public class BuildList {
    public ListNode createList(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return head;
    }
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val +"\t");
            head = head.next;
        }
    }
}
