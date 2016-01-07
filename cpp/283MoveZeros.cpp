/*
  File Name: 283MoveZeros.cpp
  Xiaolong Zhang

  Question:
  Given an array nums, write a function to 
  move all 0's to the end of it while maintaining
  the relative order of the non-zero elements.

  For example, given nums = [0, 1, 0, 3, 12], after 
  calling your function, nums should be [1, 3, 12, 0, 0].

  Note:
  You must do this in-place without making a copy of the array.
  Minimize the total number of operations.
  ++++++++++++++++++++++++++++++++++++++++++++
*/

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int zero_iter = 0;
        int non_zero_iter = 0;
        int size = nums.size();
        while(zero_iter < size && non_zero_iter < size){
        	//check if iter in range first
            while(zero_iter < size && nums[zero_iter] != 0)
                zero_iter ++;
            while(non_zero_iter < size && nums[non_zero_iter] == 0)
                non_zero_iter ++;
            if(non_zero_iter < size && zero_iter < size && zero_iter < non_zero_iter){
                nums[zero_iter] = nums[non_zero_iter];
                nums[non_zero_iter] = 0;
                zero_iter ++;
                non_zero_iter ++;
            }
            else
                non_zero_iter ++; 
        }
        
    }
};