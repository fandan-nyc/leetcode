/*
  File Name: 268MissingNumber.cpp
  Xiaolong Zhang

  Question:
	Given an array containing n distinct numbers 
	taken from 0, 1, 2, ..., n, find the one that 
	is missing from the array.

	For example,
	Given nums = [0, 1, 3] return 2.

	Note:
	Your algorithm should run in linear runtime 
	complexity. Could you implement it using only 
	constant extra space complexity?
*/


class Solution {
  public:
    int missingNumber(vector<int>& nums) {
        int res = 0;
        int count = nums.size();
        int expect = (0 + count) * (count + 1) / 2;
        for(int i = 0; i < nums.size(); i++){
            res += nums[i];
        }
        return expect - res;
    }
};