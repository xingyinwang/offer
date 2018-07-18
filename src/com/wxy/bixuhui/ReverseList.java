package com.wxy.bixuhui;

import com.wxy.utils.BuildList;
import com.wxy.utils.ListNode;

/**
 * Created by Cser_W on 2018/4/12.
 */
public class ReverseList {
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6};
        BuildList listTool = new BuildList();
        ListNode head = listTool.createList(array);
        listTool.printList(head);
        System.out.println();
        System.out.println("reverse Node List");
        ListNode revNode = reversList(head);
        listTool.printList(revNode);


    }

    public static ListNode reversList(ListNode head) {
        ListNode p = null;
        ListNode temp = head;
        while (head != null) {
            head = head.next;
            temp.next = p;
            p = temp;
            temp = head;
        }
        return p;
    }
}
