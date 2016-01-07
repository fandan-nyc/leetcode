/*
    File Name: 258AddDigits.cpp
    Xiaolong Zhang

    Question:
    Given a non-negative integer num, 
    repeatedly add all its digits until the result has only one digit.

    For example:
    Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
    Since 2 has only one digit, return it.
    Follow up:
    Could you do it without any loop/recursion in O(1) runtime? 
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Solution:
        -------------------------
    |  Stones   |  Result   |
    -------------------------
    |    0      |     0     |
    -------------------------
    |    1      |     1     |
    -------------------------
               ...
    -------------------------
    |   10      |     1     |
    -------------------------
    |   11      |     2     |
    -------------------------
    |   12      |     3     |
    -------------------------
    |   13      |     4     |
    -------------------------
    |   14      |     5     |
    -------------------------
    |   15      |     6     |
    -------------------------
    |   16      |     7     |
    -------------------------
    |   17      |     8     |
    -------------------------
    |   18      |     9     |
    -------------------------
    |   19      |     1     |
    -------------------------
    |   20      |     2     |
    -------------------------
    |   21      |     3     |
    -------------------------
    |   22      |     4     |
    -------------------------
    |   23      |     5     |
    -------------------------
    |   24      |     6     |
    -------------------------
               ...
    We can figure out a pattern. 
*/

class Solution {
public:
    int addDigits(int num) {
        return (num-1)%9+1;
    }
};