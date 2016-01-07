/*
    File Name: 191NumberOfOneBits.cpp
    Xiaolong Zhang

    Question:
	Write a function that takes an unsigned integer and 
	returns the number of ’1' bits it has (also known as
	the Hamming weight).

	For example, the 32-bit integer ’11' has binary 
	representation 00000000000000000000000000001011, 
	so the function should return 3.

*/

class Solution {
public:
	int hammingWeight(long  n) {
		int res = 0;
		while (n / 2 != 0){
			if (n % 2){
				res++;
			}
			n /= 2;
		}
		if (n == 1)
			return res + 1;
		else
			return res;
	}
};