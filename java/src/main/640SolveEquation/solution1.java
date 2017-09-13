class Solution {
    public String solveEquation(String equation) {
        String[] equs = equation.split("=");
        String leftStr  = equs[0];
        String rightStr = equs[1];
        int[] left  = calculate(leftStr);
        int[] right = calculate(rightStr);
        int coef = left[0] - right[0];
        int intercept = right[1] - left[1];
        if(coef == 0 && intercept != 0){
            return "No solution";
        }else if(coef  == 0 && intercept == 0){
            return "Infinite solutions";
        }else{
            System.out.println(intercept);
            System.out.println(coef);

            return "x=" + (intercept/coef);
        }
    }
    
    private String coeff(String x){
        if(x.length() > 1 && x.charAt(x.length()-2) >= '0' && x.charAt(x.length()-2) <= '9'){
            return x.replace("x","");
        }
        return x.replace("x","1");
    }
    
    private int[] calculate(String str){
        int coef = 0; 
        int intercept = 0;
        String[] strSplit = str.split("(?=[+-])");
        for(String i: strSplit){
            if(i.contains("x")){
                coef += Integer.valueOf(coeff(i));
            }else{
                intercept += Integer.valueOf(i);
            }
        }
        return new int[]{coef, intercept};
    }
}
