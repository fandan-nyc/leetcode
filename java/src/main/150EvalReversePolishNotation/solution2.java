class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Map<String, Operation> store = new HashMap<>();
        store.put("+", new Add());
        store.put("-", new Minus());
        store.put("*", new Multiply());
        store.put("/", new Divide());

        for(int i = 0; i < tokens.length; i++){
            if(isNum(tokens[i])){
                nums.push(Integer.valueOf(tokens[i]));
            }else{
                Operation t = store.get(tokens[i]);
                int b = nums.pop();
                int a = nums.pop();
                nums.push(t.calculate(a,b));
            }
        }
        return nums.pop();
    }
    
    boolean isNum(String a){
        return (a.charAt(0) >= '0' && a.charAt(0) <= '9') || (a.charAt(0) == '-' && a.length() > 1);
    }
}

interface Operation {
    int calculate(int a, int b);
}

class Add implements Operation {
    public int calculate(int a, int b){
        return a+b;
    }
}

class Minus implements Operation {
    public int calculate(int a, int b){
        return a-b;
    }
}

class Multiply implements Operation {
    public int calculate(int a, int b){
        return a*b;
    }
}

class Divide implements Operation {
    public int calculate(int a, int b){
        return a/b;
    }
}
