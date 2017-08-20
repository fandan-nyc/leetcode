class Solution {
    Map<String, List<Integer>> data = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(data.containsKey(input)){
            return data.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char curr = input.charAt(i);
            if(!isNum(curr)){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int k: left){
                    for(int j: right){
                        res.add(calc(k, j, curr));
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        data.put(input, res);
        return res;
    }
    
    private boolean isNum(char i){
        return i >= '0' && i <= '9';
    }
    
    private int calc(int a, int b, char op){
        if(op == '+'){
            return a+b;
        }else if(op == '-'){
            return a-b;
        }else {
            return a*b;
        }
    }
}
