/*
Given a roman numeral, 
convert it to an integer.

Input is guaranteed to 
be within the range 
from 1 to 3999.
*/

class Solution {
public:
    int getValue(char oneChar){
        switch(oneChar){
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
        stack<int> myStack;
        for(int i=0;i<s.length();i++){
            myStack.push(getValue(s[i]));
        }
        int res =0;
        int currentTop = myStack.top();
        myStack.pop();
        res = currentTop;
        if(myStack.empty())return res;
        while(!myStack.empty()){
            
            if(currentTop <= myStack.top()){
                res+=myStack.top();
            }
            else{
                res-=myStack.top();
            }
            currentTop = myStack.top();
            myStack.pop();
        }
        return res;
        
    }
};