/*
  File Name: 237DeleteNodeInLinkedList.cpp
  Xiaolong Zhang

  Question:
  Write a function to delete a node 
  (except the tail) in a singly linked 
  list, given only access to that node.

  Supposed the linked list is 
  1 -> 2 -> 3 -> 4 
  and you are given the third node with
  value 3, the linked list should become 
  1 -> 2 -> 4 
  after calling your function.
  ++++++++++++++++++++++++++++++++++++++++
  Solution:

  Actually, this question is not asking you
  to physically delete the specified node from 
  a linked list, otherwise, it's asking you to 
  remove the specific value from the list.

  Thus, all we need to do is left shifting (range
  from node->next to the tail), and delete the tail.

  Since the question says no tail node deletion, we
  only need to consider two different situations:
    1. Delete the last but one node
    2. Delete other node

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
    void deleteNode(ListNode* node) {
        if(node->next->next == NULL){
            node->val = node->next->val;
            node->next = NULL;
        }
        else{
            node->val = node->next->val;
            deleteNode(node->next);
        }
    }
};