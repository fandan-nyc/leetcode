/* 
   file name: 062UniquePaths.cpp
   Xiaolong Zhang
*/
class Solution {
  public:
   int recur(int x, int y, vector<vector<int> >& res) {
   	if (res[x - 1][y - 1] != 0)
		return res[x - 1][y - 1];
	else if (x == 1 || y == 1) {
		res[x - 1][y - 1] = 1;
		return 1;

	}
	else {
		int temp = recur(x - 1, y, res) + recur(x, y - 1, res);
		res[x - 1][y - 1] = temp;
		return temp;

	}
		

}
    int uniquePaths(int m, int n) {
    	vector<vector<int>> map(m, vector<int>(n, 0));
    	return recur(m, n, map);
    }
};