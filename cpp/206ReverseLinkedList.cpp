/*
  File Name: 206ReverseLinkedList.cpp
  Xiaolong Zhang

  Question:
  Reverse a linked list

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
    
    ListNode* recursion(ListNode* head, ListNode*& newHead){ //pass the pointer
        if(head->next == NULL){                              //as reference
            newHead = head;
            return head;
        }
        else{
        ListNode* temp = recursion(head->next, newHead);
        temp->next = head;
        return head;
            
        }
    }
    ListNode* reverseList(ListNode* head) {
        if(head == NULL)
            return head;
        ListNode* newHead = NULL;
        ListNode* newEnd = recursion(head, newHead);
        newEnd->next = NULL;
        return newHead;
    }
};