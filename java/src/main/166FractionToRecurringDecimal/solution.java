public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        boolean negative = (numerator  < 0  ^ denominator <0);
        String left =  negative ? "-" : "";
        long num= numerator > 0 ? numerator : (-1) * (long)numerator;
        long den = denominator > 0 ? denominator : (-1) * (long)denominator;
        left += num/den;
        num = num % den ; 
        if(num == 0){
            return  left;
        }
        left += ".";
        String right = "";
        Map<Long, Integer> map = new HashMap<Long, Integer>(); 
        int counter = 0;
        while(num != 0 && !map.containsKey(num)){
            map.put(num, counter++);
            right += (num*10/den);
            num = num*10 % den;
        }
        if(num != 0){
            int loc = map.get(num);
            right = right.substring(0,loc) + "(" + right.substring(loc) + ")";
        }
        return left + right;
    }
}
