/*
  File Name: 206ReverseLinkedList.cpp
  Xiaolong Zhang

  Question:
  Reverse a linked list
  ++++++++++++++++++++++
  Solution:
  put all element into stack, and pop 
  them one by one

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
    ListNode* reverseList(ListNode* head){
        if(head == NULL || head->next ==NULL)
            return head;
        stack<ListNode*> myStack;
        ListNode* iter = head;
        while(iter != NULL){
            myStack.push(iter);
            iter = iter->next;
        }
        ListNode* newHead = myStack.top();
        myStack.pop();
        iter = newHead;
        while(!myStack.empty()){
            iter->next = myStack.top();
            myStack.pop();
            iter = iter->next;
        }
        iter->next = NULL;
        return newHead;
    }
};