/*
  File Name: 136SingleNumber.cpp
  Xiaolong Zhang

  Question:
  Given an array of integers, every element 
  appears twice except for one. Find that 
  single one.

  Note:
  Your algorithm should have a linear runtime 
  complexity. Could you implement it without 
  using extra memory? 
  ++++++++++++++++++++++++++++++++++++++++++
  Solution:
  Use XOR.
*/

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res=nums[0];
        for(int i=1; i < nums.size(); i++){
            res ^= nums[i];
        }
        return res;
    }
};