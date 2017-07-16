public class Solution {
    public String solveEquation(String equation) {
        // validate input 
        if(equation == null | equation.length() < 3){
            throw new IllegalArgumentException("illegal argument exception");
        }
        int equal = equation.lastIndexOf('=');
        int[] left = simplify(equation.substring(0, equal));
        int[] right = simplify(equation.substring(equal+1, equation.length()));
        int slop = left[0] - right[0];
        int intersect = right[1] - left[1];
        if(slop == 0 && intersect == 0){
            return "Infinite solutions";
        }else if(slop == 0 && intersect != 0){
            return "No solution";
        }else{
            return "x=" + intersect/slop;
        }
    }
    
    private int[] simplify(String exp){
        String[] each = exp.split("(?=[+-])");
        int slop = 0;
        int intersect = 0 ;
        for(String token: each){
            if(token.equals("x") || token.equals("+x")){
                slop += 1;
            }else if (token.equals("-x")){
                slop -= 1;
            }else if(token.contains("x")){
                slop += Integer.parseInt(token.substring(0,token.length()-1));
            }else{
                intersect += Integer.parseInt(token.substring(0,token.length()));
            }
        }
        return new int[]{slop, intersect};
    }
}
