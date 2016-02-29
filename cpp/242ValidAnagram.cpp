/*
    file name: 242ValidAnagram.cpp
    Xiaolong Zhang
*/
class Solution{
  public:
  	bool isAnagram(string s, string t){
  		if(s.size() != t.size())
  			return false;

  		unordered_map<char, int> myMap;

  		for(int i = 0; i < s.length(); ++i){
  			if(myMap.find(s[i]) == s.end())
  				myMap.insert(unordered_map<char, int>::value_type(s[i]. 1));
  			else
  				myMap[s[i]] = myMap[s[i]] + 1;
  		}
  		for(int i = 0; i < t.length(); ++i){
  			if(myMap.find(t[i]) == myMap.end())
  				return false;
  			else{
  				myMap[t[i]] -= 1;
  				if(myMap[t[i]] == 0)
  					myMap.erase(t[i]);
  			}
  		}
  		if(myMap.empty())
  			return true;
  		else
  			return false;
  	}
}