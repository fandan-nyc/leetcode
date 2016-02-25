/*
    file name: 064MinimumPathSum.cpp
    Xiaolong Zhang
*/

class Solution {
public:
    int DP(int x, int y, vector<vector<int> >& grid, vector<vector<int> >& res){
        if(res[x][y] != -1)
            return res[x][y];
        else{
            res[x][y] = min(DP(x - 1, y, grid, res), DP(x, y - 1, grid,res)) + grid[x][y];
            return res[x][y];
        }
    }
    int minPathSum(vector<vector<int>>& grid) {
        int x_size = grid.size();
        int y_size = grid[0].size();
        vector<vector<int> > res(x_size, vector<int>(y_size, -1));
        res[0][0] = grid[0][0];
        for(int i = 1; i < x_size; ++i){
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < y_size; ++i){
            res[0][i] = res[0][i-1] + grid[0][i];
        }
        return DP(x_size - 1, y_size - 1, grid, res);
    }
};