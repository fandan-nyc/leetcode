/*
    File Name: 231PowerOfTwo.cpp
    Xiaolong Zhang

    Question:
    Given an integer, write a function to 
    determine if it is a power of two.
    ++++++++++++++++++++++++++++++++++

    Solution:
    Only the highest bit will be 1 if a number
    is power of two. So, check if only the highest
    bit of target number is 1.
*/

class Solution {
public:
    bool isPowerOfTwo(int n) {
        return (n > 0) && (!(n & (n - 1)));
    } 
};