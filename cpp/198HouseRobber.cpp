/*
    198HouseRobber.cpp
    Xiaolong Zhang
*/

class Solution {
public:
    int DP(int i, vector<int>& nums, vector<int>& res){
        if(res[i] != -1 )
            return res[i];
        else{
            int temp = max(DP(i - 2, nums, res) + nums[i], DP(i - 1, nums, res));
            res[i] = temp;
            return temp;
        }
    }
    int rob(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        vector<int> res(nums.size(), -1);
        res[0] = nums[0];
        if(nums.size()>=2){
            res[1] = max(nums[0], nums[1]);
        }
        return DP(nums.size() - 1, nums, res);
    }
};