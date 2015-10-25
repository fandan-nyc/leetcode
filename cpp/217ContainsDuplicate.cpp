/*
Given an array of integers, 
find if the array contains any duplicates. 
Your function should return true if any 
value appears at least twice in the array, 
and it should return false if every element is distinct. 

*/

class Solution {
public:
	bool containsDuplicate(vector<int>& nums) {
		unordered_set<int> s = unordered_set<int>();
		for (int i = 0; i<nums.size(); i++){
			if (s.find(nums.at(i)) != s.end())return true;
			s.insert(nums.at(i));
		}
		return false;
	}
};