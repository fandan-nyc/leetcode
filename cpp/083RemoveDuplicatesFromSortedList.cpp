/*
    File Name: 083RemoveDuplicatesFromSortedList.cpp
    Xiaolong Zhang


    Question:
    Given a sorted linked list, delete all duplicates 
    such that each element appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == NULL)
        	return head;
        int currentValue = head->val;
        ListNode* fastIter = head->next;
        ListNode* slowIter = head;
        while(fastIter != NULL){
            if(fastIter->val == currentValue){
                slowIter->next = fastIter->next;
                fastIter=fastIter->next;
            }
            else{
                currentValue = fastIter->val;
                fastIter=fastIter->next;
                slowIter=slowIter->next;
            }
        }
        return head;
    }
};