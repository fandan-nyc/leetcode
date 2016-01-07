/*
  File Name: 169MajorityElement.cpp
  Xiaolong Zhang

  Question:
  Given an array of size n, find the majority element. 

  The majority element is the element that appears more 
  than ⌊ n/2 ⌋ times.

  You may assume that the array is non-empty and the 
  majority element always exist in the array.
  ++++++++++++++++++++++++++++++++++++++
  Solution:
  Conteract different elements, so that only the majority
  element survives.
*/

class Solution {
public:
	int majorityElement(std::vector<int> &num) {
		int count = 1;
		int majIndex = 0;
		for (int i = 1; i < num.size(); i++){
			if (num[majIndex] == num[i])
				count++;
			else
				count--;
			if (count == 0){
				majIndex = i;
				count = 1;
			}
		}
		return num[majIndex];
	}
};