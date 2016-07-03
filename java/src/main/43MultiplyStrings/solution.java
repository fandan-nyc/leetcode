public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }else if(num1.equals("1")){
            return num2;
        }else if(num2.equals("1")){
            return num1;
        }
        
        List<String> store = new ArrayList<String>();
        for(int i = num2.length()-1; i >= 0; i--){
            store.add(multiplySingle(num1, num2.charAt(i), num2.length() - i - 1));
        }
        String result = "";
        for(String i: store){
            result = addString(result, i);
        }
        return result;
    }
    
    private String multiplySingle(String num1, char single, int zeros){
        int carryOver = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = num1.length()-1; i >= 0; i--){
            int left = num1.charAt(i) - '0';
            int right = single - '0';
            int result = left * right + carryOver;
            int digit = result % 10; 
            carryOver = result/10;
            sb.insert(0, digit);
        }
        if(carryOver != 0){
            sb.insert(0, carryOver);
        }
        while(zeros > 0){
            sb.append('0');
            zeros --;
        }
        return sb.toString();
    }
    
    private String addString(String a, String b){
        if(a.length() == 0){
            return b;
        }else if(b.length() == 0){
            return a;
        }
        
        int carryOver = 0; 
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        for( i = a.length() -1,  j = b.length()-1; i >=0 && j>=0; i--,j--){
            int left = a.charAt(i) - '0';
            int right = b.charAt(j) - '0';
            int result = (left + right + carryOver);
            sb.insert(0, result %10);
            carryOver = result / 10;
        }
        while( i >= 0){
            int result = a.charAt(i) - '0' + carryOver;
            sb.insert(0, result %10);
            carryOver = result /10;
            i--;
        }
        while( j >= 0){
            int result = b.charAt(j) - '0' + carryOver;
            sb.insert(0, result %10);
            carryOver = result /10;
            j--;
        }
        if(carryOver > 0){
            sb.insert(0, carryOver);
        }
        return sb.toString();
    }
}
