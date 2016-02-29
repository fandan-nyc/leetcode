class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head == nullptr)
            return head;
        ListNode* pre_iter = nullptr;
        ListNode* next_iter = head->next;
        while( true ){
            head->next = pre_iter;
            pre_iter = head;
            if( next_iter == nullptr )
                break;
            head = next_iter;
            next_iter = next_iter->next;
        }
        return head;
        
    }
};