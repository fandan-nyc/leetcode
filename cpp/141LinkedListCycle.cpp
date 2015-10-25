/*
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head==NULL)return false;
        ListNode* iter=head;
        ListNode* fastIter=head;
        while(fastIter->next!=NULL && fastIter->next->next!=NULL){
            iter=iter->next;
            fastIter=fastIter->next->next;
            if(iter==fastIter)return true;
            
        }
        return false;
    }
};