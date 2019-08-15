package com.Dandelion.Algorithm;

public class LinkNodeAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.setNode(l1,4);
        l1.setNode(l1.next,3);
        ListNode l2 = new ListNode(5);
        l2.setNode(l2,6);
        l2.setNode(l2.next,4);
        ListNode aaa = null;
        aaa = l1;
        while(aaa != null){
            aaa.getNodeData();
            aaa = aaa.next;
        }
    }
    public ListNode AddTwo(ListNode l1,ListNode l2){
        ListNode temp1 = null;
        ListNode temp2 = null;
        ListNode result = null;
        temp1 = l1;
        temp2 = l2;
        ListNode thisNode = null;
        result.val = temp1.val+ temp2.val;
        while(temp1.next != null){
            thisNode.val = temp1.next.val + temp2.next.val;
            result.next = thisNode;
        }
        return null;
    }


    static class ListNode {
        private int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        void setNode(ListNode now, int value){
            now.next = new ListNode(value);
        }
        void getNodeData(){
            System.out.println(this.val);
        }
    }
}