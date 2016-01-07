/*
  File Name: 260SingleNumberIII.cpp
  Xiaolong Zhang

  Question:
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

  ++++++++++++++++++++++++++++++++++++
  Solution:
  Split the target numbers into two different
  sets, so that we could apply the algorithm
  from SingleNumber I
*/

class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int k = nums[0];
        for(int i = 1; i < nums.size(); i++){
            k ^= nums[i];
        }
        int p = k & (~(k - 1));    //find the most right place
                                   //which these two number differs,
                                   //this number will split the set
        vector<int> res;
        int a = 0;
        int b = 0;
        for(int i = 0; i < nums.size(); i++){
            if(p & nums[i]){
                a = a ^ nums[i];
            }
            else 
            	b = b ^ nums[i];
        }
        res.push_back(a);
        res.push_back(b);
        return res;
    }
};