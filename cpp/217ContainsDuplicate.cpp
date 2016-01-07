/*
  File Name: 217ContainsDuplicate.cpp
  Xiaolong Zhang

  Question:
  Given an array of integers, 
  find if the array contains any duplicates. 
  Your function should return true if any 
  value appears at least twice in the array, 
  and it should return false if every element is distinct. 
  ++++++++++++++++++++++++++++++++++++++++++++++++++
  Solution:
  Use the hashmap to accomplish constant time lookup,
  hence, linear time complexity.

*/

class Solution {
public:
	bool containsDuplicate(vector<int>& nums) {
		unordered_set<int> s = unordered_set<int>();
		for (int i = 0; i<nums.size(); i++){
			if (s.find(nums[i]) != s.end())
				return true;
			s.insert(nums.at(i));
		}
		return false;
	}
};