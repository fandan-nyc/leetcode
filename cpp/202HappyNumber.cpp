/*
    file name: 202HappyNumber.cpp
    Xiaolong Zhang
*/
class Solution {
  public:
    bool isHappy(int n) {
        int result = 0;
        unordered_set<int> mySet;
        while(true){
            if(n == 1) return true;
            while( n > 0 ){
                result += (n % 10) * (n % 10);
                n /= 10;
            }
            if( mySet.find(result) != mySet.end() )
                return false;
            else{
                mySet.insert(result);
                n = result;
                result = 0;
            }
        }
    }
};