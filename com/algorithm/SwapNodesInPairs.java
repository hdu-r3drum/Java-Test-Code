package com.algorithm;

import java.util.Objects;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        ListNode node1 = new ListNode();
        head.next = node1;
        node1.val = 2;
        ListNode node2 = new ListNode();
        node1.next = node2;
        node2.val =3;
        ListNode node3 = new ListNode();
        node2.next = node3;
        node3.val = 4;
        ListNode res = swapPairs(head);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    // static ListNode swapPairs(ListNode head) {
    //     ListNode res = new ListNode();
    //     ListNode pre = head;
    //     ListNode temp = res;
    //     int count = 0;
    //     if(head != null){
    //         count++;
    //     }
    //     if(head.next != null){
    //         head = head.next;
    //         count++;
    //     }else{
    //         return head;
    //     }
    //     while(head != null){
    //         if(count == 2){
    //             count = 0;
    //             ListNode n1 = new ListNode();
    //             ListNode n2 = new ListNode();
    //             n1.val = head.val;
    //             n2.val = pre.val;
    //             temp.next = n1;
    //             temp = temp.next;
    //             temp.next = n2;
    //             temp = temp.next;
    //         }
    //         if(head.next != null){
    //             head = head.next;
    //             pre = pre.next;
    //             count++;
    //         }else{
    //             break;
    //         }
    //     }
    //     return res.next;
    // }
    static ListNode swapPairs(ListNode head){
        if(head == null){
            return head;
        }
        ListNode res = new ListNode();
        ListNode temp = res;
        ListNode pre = new ListNode();
        pre = head;
        while(pre.next != null && pre.next.next != null){
            head = pre.next;
            ListNode n1 = new ListNode();
            ListNode n2 = new ListNode();
            n1.val = head.val;
            n2.val = pre.val;
            temp.next = n1;
            temp = temp.next;
            temp.next = n2;
            temp = temp.next;

            pre = pre.next.next;
        }
        if(pre != null){
            if(pre.next != null){
                head = pre.next;
                ListNode n1 = new ListNode();
                ListNode n2 = new ListNode();
                n1.val = head.val;
                n2.val = pre.val;
                temp.next = n1;
                temp = temp.next;
                temp.next = n2;
                temp = temp.next;
            }else{
                temp.next = pre;
            }
            Objects.hash(values)
        }
        return res.next;
    }
}