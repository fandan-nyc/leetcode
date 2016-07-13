/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode start = head;
        RandomListNode next ;
        RandomListNode tmp ;
        // create each node and put them into list
        while(start != null){
             tmp = new RandomListNode(start.label);
             next = start.next;
             start.next = tmp;
             tmp.next = next;
             start = next;
        }
        // assign the random to the copied node 
        start = head;
        while(start != null){
            if(start.random != null){
                start.next.random = start.random.next;
            }
            start = start.next.next;
        }
        // recover the original linked list and separate the copied one out
        RandomListNode pseudoHead= new RandomListNode(0);
        RandomListNode copy = pseudoHead;
        RandomListNode nextReal;
        start = head;
        while(start != null){
            nextReal = start.next.next;
            copy.next = start.next;
            copy = copy.next;
            copy.next = null;
            start.next = nextReal;
            start = start.next;
        }
        return pseudoHead.next;
    }
}
