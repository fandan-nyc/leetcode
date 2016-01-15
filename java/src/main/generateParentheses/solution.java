public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n <= 0)
            return result;
        dfs(n, n, "",result);
        return result;
    }
    
    private void dfs(int left, int right, String str, List<String> result)
    {
        if(left == 0 && right == 0){
            result.add(str);
            return ;
        }
        if(left > 0){
            dfs(left-1, right, str + "(", result);
        }
        if(right > left && right >0){
            dfs(left, right-1, str + ")", result);
        }
    }
}
