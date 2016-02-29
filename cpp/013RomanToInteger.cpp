/*
    File Name: 013RomanToInteger.cpp
    Xiaolong Zhang

    Question:
    Given a roman numeral, 
    convert it to an integer.

    Input is guaranteed to 
    be within the range 
    from 1 to 3999.
    +++++++++++++++++++++++++++++++
    Solution:

*/

class Solution {
public:
    int getValue(char value_char){
        switch(value_char){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
    }
    int romanToInt(string s) {
        if(s.length() == 0)
            return 0;
        int result = 0;
        for(int i = 0; i < s.length(); ++i){
            if(i > 0 && getValue(s[i]) > getValue(s[i - 1]))
                result += getValue(s[i]) - 2 * getValue(s[i - 1]);
            else
                result += getValue(s[i]);
            
        }
        return result;
    }
    
};