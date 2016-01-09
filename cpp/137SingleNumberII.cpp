/*
    File Name: 137SingleNumberII.cpp
    Xiaolong Zhang

    Question:
    Given an array of integers, every element 
    appears three times except for one. 
    Find that single one.

	Note:
	Your algorithm should have a linear runtime 
	complexity. Could you implement it without 
	using extra memory?

	++++++++++++++++++++++++++++++++++++++
	Solution:
	Since all numbers occur three time except
	one, we could create one 32-bit number to count 
	how many 1s occured on every bit. 
*/
class Solution {
public:
    int singleNumber(vector<int>& nums){
    	int result = 0;

    	int x, count;

    	for(int i = 0; i < 32; i++){
    		count = 0;
    		x = 1 << i;

    		for(int j = 0; j < nums.size(); j++){
    			if(nums[j] & x)
    				count++;
    		}
    		if(count % 3)
    			result |= x;
    	}

    	return result;

    }
}