package com.wxy.leetCode;

import com.wxy.utils.BuildList;
import com.wxy.utils.ListNode;

/**
 * Created by Cser_W on 2018/6/29.
 */
public class 移除重复数字在有序链表中 {
    public static void main(String[] args){
        int[] array = new int[]{1};
        ListNode head = new BuildList().createList(array);
        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode.val);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode phead = head;
        while (phead != null) {
            ListNode nextNode = phead.next;
            while (nextNode != null && phead.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            phead.next = nextNode;
            phead = nextNode;
        }
        return head;
    }
}
