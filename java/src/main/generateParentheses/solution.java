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

// another way
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(n, n, new StringBuilder(), res);
        return res;
        
    }
    
    private void backtracking(int left, int right, StringBuilder sb, List<String> store){
        if(left == 0 && right == 0){
            store.add(sb.toString());
            return;
        }
        if(left > 0){
            sb.append('(');
            backtracking(left-1, right,  sb, store);
            sb.delete(sb.length()-1, sb.length());
        }
        if(left < right && right > 0){
            sb.append(')');
            backtracking(left, right-1, sb, store);
            sb.delete(sb.length()-1, sb.length());
        }        
    }
}
