/*
    File Name: 292 NimGame.cpp
    Xiaolong Zhang
    2016.01.07

    Question:
    You are playing the following Nim Game with your friend:

    There is a heap of stones on the table, each time one of
    you take turns to remove 1 to 3 stones. The one who removes
    the last stone will be the winner. You will take the first 
    turn to remove the stones.

    Both of you are very clever and have optimal strategies for 
    the game. Write a function to determine whether you can win 
    the game given the number of stones in the heap.

    For example, if there are 4 stones in the heap, then you will 
    never win the game: no matter 1, 2, or 3 stones you remove, 
    the last stone will always be removed by your friend.
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Solution:
    As the hint says, we can never win if there are 4 stones left
    in our turn, and similarly, we can enumerate the relationship
    between remaining stones and game results:
    -------------------------
    |  Stones   |  Result   |
    -------------------------
    |    1      |    Win    |
    -------------------------
    |    2      |    Win    |
    -------------------------
    |    3      |    Win    |
    -------------------------
    |    4      |    Lose   |
    -------------------------
    |    5      |    Win    |
    -------------------------
    |    6      |    Win    |
    -------------------------
    |    7      |    Win    |
    -------------------------
    |    8      |    Lose   |
    -------------------------
    |    9      |    Win    |
    -------------------------
    |   10      |    Win    |
    -------------------------
               ...
    We can figure out a pattern, that winning is possible 
    as long as the number of remaining stones is not a 
    multiply of 4.
    Thus, code will be very simple
*/
class Solution {
public:
    bool canWinNim(int n) {
         return n % 4;
    }
};