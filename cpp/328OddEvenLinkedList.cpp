/*
    file name: 328OddEvenLinkedList.cpp
    Xiaolong Zhang

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
    ListNode* oddEvenList(ListNode* head) {
        if( head == nullptr || head->next == nullptr)
            return head;
        ListNode* odd = head;
        ListNode* even = head->next;
        ListNode* odd_iter = odd;
        ListNode* even_iter = even;
        while( true ){
            if( even_iter->next != nullptr ){
                odd_iter->next = even_iter->next;
                odd_iter = odd_iter->next;
            }
            else
                break;
            if( odd_iter->next != nullptr ){
               even_iter->next = odd_iter->next;
               even_iter = even_iter->next;
            }
            else
                break;
            
        }
        odd_iter->next = even;
        even_iter->next = nullptr;
        return odd;
    }
};