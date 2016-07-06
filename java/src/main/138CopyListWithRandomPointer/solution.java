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
        Map<Integer, RandomListNode> visited = new HashMap<>();
        RandomListNode result = new RandomListNode(head.label);
        RandomListNode copy = result;
        visited.put(head.label, result);
        while(head != null){
            RandomListNode next =  head.next; 
            RandomListNode random = head.random;
            if(next != null && !visited.containsKey(next.label)){
                visited.put(next.label, new RandomListNode(next.label));
            }
            if(random != null && !visited.containsKey(random.label)){
                visited.put(random.label, new RandomListNode(random.label));
            }
            if(random != null){
                result.random = visited.get(random.label);
            }else{
                result.random = null;
            }
            if(next != null){
                result.next = visited.get(next.label);
            }else {
                result.next = null;
            }
            result = result.next;
            head = head.next;
        }
        return copy;
    }
}
