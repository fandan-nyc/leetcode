/*
    File Name: 053MaxSubarray.cpp
    Xiaolong Zhang

    Question:
    Find the contiguous subarray within an array 
    (containing at least one number) which has 
    the largest sum.

	For example, given the array 

	[−2,1,−3,4,−1,2,1,−5,4],

	the contiguous subarray [4,−1,2,1] has the 
	largest sum = 6.


	More practice:
	If you have figured out the O(n) solution, 
	try coding another solution using the divide 
	and conquer approach, which is more subtle.
*/
class Solution {
public:
	int findCrossSum(vector<int>& nums, int low, int mid, int high){
		int leftRes = -2147483648;
		int rightRes = -2147483648;
		int sum = 0;
		for(int i = mid; i>=low; i--){
			sum = sum + nums[i];
			if(sum > leftRes){
				leftRes = sum;
			}
		}
		sum=0;
		for(int i = mid+1; i<=high; i++){
			sum = sum+nums[i];
			if(sum > rightRes){
				rightRes = sum;
			}
		}
		return leftRes + rightRes;
	}
	int findMaxSum(vector<int>& nums, int low, int high){
		if(low == high)return nums[low];
		else{
			int mid = (low+high)/2;
			int left = findMaxSum(nums, low, mid);
			int right = findMaxSum(nums, mid+1, high);
			int middle = findCrossSum(nums, low, mid, high);
			return max(max(left,right),middle);
		}
	}
	int maxSubArray(vector<int>& nums){
		return findMaxSum(nums, 0, nums.size()-1);
	}
};