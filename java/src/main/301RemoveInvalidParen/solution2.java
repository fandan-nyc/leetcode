class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0 ;
        int rmR = 0;
        for(char i: s.toCharArray()){
            if(i == '('){
                rmL++;
            }else if(i == ')'){
                if(rmL > 0){
                    rmL --;
                }else{
                    rmR++;
                }
            }
        }
        
        Set<String> res = new HashSet<>();
        backtracking(s, res, new StringBuilder(), 0, rmL, rmR, 0);
        return new ArrayList<String>(res);
    }
    
    private void backtracking(String s, Set<String> res, StringBuilder sb, int i, int rmL, int rmR, int open){
        if(rmL < 0 || rmR < 0 || open < 0){
            return ;
        }
        if(i == s.length()){
            if(rmL == 0 && rmR == 0 && open == 0)
                res.add(sb.toString());
            return;
        }
        char curr = s.charAt(i);
        int len = sb.length();
        if(curr == '('){
            backtracking(s, res, sb, i+1, rmL-1, rmR, open);
            backtracking(s, res, sb.append(curr), i+1, rmL, rmR, open+1);
        }else if(curr == ')'){
            backtracking(s, res, sb, i+1, rmL, rmR-1, open);
            backtracking(s, res, sb.append(curr), i+1, rmL, rmR, open-1);
        }else{
            backtracking(s, res, sb.append(curr), i+1, rmL, rmR, open);
        }
        sb.setLength(len);
    }
}
