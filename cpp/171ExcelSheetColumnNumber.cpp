/*
  File Name: 171ExcelSheetColumnNumber.cpp
  Xiaolong Zhang

  Question:
  Given a column title as appear in an Excel sheet, 
  return its corresponding column number.

  For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28 
*/


class Solution{
public:
    int titleToNumber(string s){
	    int result = 0;
		int length = s.length();
		for (int i = 0; i < length; i++){
			result += (s[i] - 64) * pow(26, length - i-1);
		}
		return result;
    }
};