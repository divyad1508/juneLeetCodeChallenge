/**
 * 
 */
package com.divya.practice.leetcode.juneChallenge;

/**
 * @author divya-dyuti
 *
 */
public class DeleteNodeInALinkedList {
    
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

}
