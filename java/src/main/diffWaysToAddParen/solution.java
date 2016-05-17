

public class Solution {
    private static final List<Character> operators = Arrays.asList('+','-','*','/');
    public List<Integer> diffWaysToCompute(String input) {
        char[] inputChar = input.toCharArray();
        boolean sign = true;
        List<Integer> left ; 
        List<Integer> right;
        List<Integer> result = new ArrayList<Integer>();
        int leftV ;
        int rightV;
        for(int i = 0; i < input.length();i++){
            char curr = input.charAt(i);
            if(operators.contains(curr)){
                left =  diffWaysToCompute(input.substring(0,i));
                right = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int j = 0; j < left.size();j++){
                    for(int k = 0; k < right.size(); k++){
                        leftV = left.get(j);
                        rightV = right.get(k);
                        switch(curr){
                            case '+':
                                result.add(leftV + rightV);
                                break;
                            case '-':
                                result.add(leftV - rightV);
                                break;
                            case '*':
                                result.add(leftV * rightV);
                                break;
                            case '/':
                                result.add(leftV / rightV);
                                break;
                            default:
                                throw new IllegalArgumentException("the char we have is not valid" );
                        }
                    }
                }
                sign = false;
        }
    }
    if(sign){
        int tmp = 0;
        for(int i  = 0 ; i < input.length();i++){
            tmp = tmp * 10+ (input.charAt(i)-'0'); 
        }
        result.add(tmp);
    }
    return result;
}
    
}
