public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        backtracking(num, target, rst, "",0, 1L,0L);
        return rst;
    }
    
    private void backtracking(String num, int target, List<String> result, String tmp, int pos, long multi, long eval){
        if(pos == num.length()){
            if(target ==  eval){
                result.add(new String(tmp));
            }
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0'){
                break;
            }
            long curr = Long.parseLong(num.substring(pos, i+1));
            if(pos == 0){
                backtracking(num, target, result, tmp + curr, i+1, curr,curr);
            }else{
                backtracking(num, target, result, tmp + "+" + curr, i+1, curr, eval+curr);
                backtracking(num, target, result, tmp + "-" + curr, i+1, -1 * curr, eval-curr);
                backtracking(num, target, result, tmp + "*" + curr, i+1, multi * curr, eval - multi + multi * curr);
            }
        }
    }
}
