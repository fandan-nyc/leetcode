String parseTernary(String expression) {
       return dfs(expression.toCharArray(), 0, expression.length()-1) + "";
    }
    
    private char dfs(char[] expression, int start, int end){
        if(start == end){
            return expression[start];
        }
        int counter = 0, i = start;
        for(; i <= end; i++){
            char curr = expression[i];
            if(curr == '?'){
                counter++;
            }else if(curr == ':'){
                counter --;
                if(counter == 0){
                    break;
                }
            }
        }
        return expression[start] == 'T'? dfs(expression, start+2,i-1): dfs(expression, i+1, end);
    }
}
