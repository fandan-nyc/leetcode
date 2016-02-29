/*
    file name: 021MergeTwoSortedLists.cpp
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
    
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1 == nullptr)
            return l2;
        if(l2 == nullptr)
            return l1;
        if(l1->val > l2->val){
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
        else{
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }
    }
};