package com.wxy.leetCode;

import com.wxy.utils.BuildList;
import com.wxy.utils.ListNode;

/**
 * Created by Cser_W on 2018/4/23.
 */
public class 旋转链表右边的k个节点 {
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5};
        int k = 2;
        ListNode head = new BuildList().createList(array);
        ListNode listNode = new 旋转链表右边的k个节点().rotateRight(head, k);
        System.out.println(listNode.val);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode tail, tempHead = head;
        while( k > 0) {
            if(tempHead.next != null) {
                tempHead = tempHead.next;
            } else {
                return null;
            }
            k--;
        }
        tail = head;
        while(tempHead != null) {
            if (tempHead.next != null) {
                tempHead = tempHead.next;
            } else {
                break;
            }
            tail = tail.next;
        }
        ListNode curHead = tail.next;
        tail.next = null;
        tempHead.next = head;
        head = curHead;
        return head;
    }
}
