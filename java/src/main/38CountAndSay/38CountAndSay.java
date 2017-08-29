class Solution {
    public String countAndSay(int n) {
        if(n <= 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for(int j = 1; j < n; j++){
            sb = helper(sb);
        }
        return sb.toString();
    }
    
    private StringBuilder helper(StringBuilder input){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < input.length() ; i++){
            int count = 1;
            while(i < input.length()-1 && input.charAt(i) == input.charAt(i+1)){
                i++;
                count++;
            }
            res.append(count + "" + input.charAt(i));
        }
        return res;
    }
}
