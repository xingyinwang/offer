package com.wxy.niuke;

import com.wxy.utils.BuildList;
import com.wxy.utils.ListNode;

/**
 * Created by Cser_W on 2018/6/15.
 */
public class 倒数第K个节点 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        ListNode list = new BuildList().createList(arr);
        ListNode res = new 倒数第K个节点().FindKthToTail(list,1);
        System.out.println(res);
    }
    public ListNode FindKthToTail(ListNode head, int k) {
        int kk = 0;
        ListNode[] res = new ListNode[1];
        if (k < 0 || head == null) {
            return null;
        }
        findKthToTail(head,k,kk,res);
        return res[0];
    }

    /***
     * this is interesting
     */
    private int findKthToTail(ListNode head, int k, int kk, ListNode[] res) {
        if (head == null) {
            return kk;
        }
        kk = findKthToTail(head.next, k, kk, res);
        kk += 1;
        if( k == kk) {
            res[0] = head;
        }
        return kk;
    }
}
