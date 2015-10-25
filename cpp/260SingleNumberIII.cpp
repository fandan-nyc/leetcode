/*
 Given an array of numbers nums, 
 in which exactly two elements 
 appear only once and all the 
 other elements appear exactly 
 twice. Find the two elements 
 that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5]. 

 Note:

    The order of the result is not important. 
    So in the above example, [5, 3] is also correct.

    Your algorithm should run in linear runtime 
    complexity. Could you implement it using only 
    constant space complexity?

*/

class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int k=0;
        for(int i=0;i<nums.size();i++){
            k=k^nums[i];
        }
        int p=k&(~(k-1));
        vector<int> res;
        int a=0;
        int b=0;
        for(int i=0;i<nums.size();i++){
            if(p&nums[i]){
                a=a^nums[i];
            }
            else b=b^nums[i];
        }
        res.push_back(a);
        res.push_back(b);
        return res;
    }
};