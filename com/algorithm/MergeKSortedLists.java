package com.algorithm;
//[[1,4,5],[1,3,4],[2,6]]

public class MergeKSortedLists {
    public static void main(String[] args) {
        // ListNode[] lists = new ListNode[3];
        // ListNode node1 = new ListNode();
        // node1.val = 1;
        // ListNode node2 = new ListNode();
        // node1.next = node2;
        // node2.val = 4;
        // ListNode node3 = new ListNode();
        // node2.next = node3;
        // node3.val = 5;
        // ListNode node4 = new ListNode();
        // node4.val = 1;
        // ListNode node5 = new ListNode();
        // node4.next = node5;
        // node5.val = 3;
        // ListNode node6 = new ListNode();
        // node5.next= node6;
        // node6.val = 4;
        // ListNode node7 = new ListNode();
        // node7.val = 2;
        // ListNode node8 = new ListNode();
        // node7.next = node8;
        // node8.val = 6;
        // lists[0] = node1;
        // lists[1] = node4;
        // lists[2] = node7;
        ListNode[] lists = new ListNode[1];
        ListNode node = new ListNode();
        lists[0] = node;
        System.out.println(lists.length);
        ListNode res = Solution.mergeKLists(lists);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        ListNode temp = res;
        if(lists.length == 0){
            return res;
        }
        int index = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        boolean flag = true;
        while(flag){
            min = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] == null){
                    continue;
                }
                if(lists[i].val < min){
                    min = lists[i].val;
                    index = i;
                }
            }
            if(lists[index] != null){
                ListNode node = new ListNode();
                node.val = min;
                temp.next = node;
                temp = temp.next;
                if(lists[index].next != null){
                    lists[index] = lists[index].next;
                }else{
                    count++;
                    lists[index] = null;
                }
            }

            if(count == lists.length){
                flag = false;
            }
        }
        return res.next;
    }
}