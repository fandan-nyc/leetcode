class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] as=  a.split("\\+");
        String[] bs=  b.split("\\+");
        int intercept = Integer.valueOf(as[0]) * Integer.valueOf(bs[0]) - getCoeff(as[1]) * getCoeff(bs[1]);
        int coeff = Integer.valueOf(as[0]) * getCoeff(bs[1]) + Integer.valueOf(bs[0]) * getCoeff(as[1]);
        return intercept + "+" + coeff +"i";
    }
    
    private int getCoeff(String a){
         return Integer.valueOf(a.substring(0,a.length()-1));
    }
}
