public class Solution {
    public String multiply(String num1, String num2) {
         if(num2.equals("0") || num1.equals("0")){
             return "0";
         }
        List<String> result = new ArrayList<String>();
        String zero = "";
        for(int i = num2.length()-1; i >= 0; i--){
            result.add( multiply(num1, num2.charAt(i)) + zero);
            zero += "0";
        }
        String answer = "0";
        for(String i: result){
            answer = add(answer, i);
        }
        return answer;
        
    }
    
    private String multiply(String a, char b){
        int carryOver = 0;
        StringBuilder sb =  new StringBuilder();
        for(int i= a.length()-1; i >= 0; i--){
            int curr = (a.charAt(i) - '0') * (b - '0') + carryOver;
            sb.insert(0, curr%10);
            carryOver = curr/10;
        }
        if(carryOver > 0){
            sb.insert(0, carryOver);
        }
        return sb.toString();
    }
    
    private String add(String a, String b){
        int i = a.length()-1; 
        int j = b.length()-1;
        int carryOver = 0;
        StringBuilder sb =  new StringBuilder();
        while( i  >= 0 || j >= 0){
            int left = 0;
            int right = 0;
            if( i >= 0){
                left = a.charAt(i) - '0';
            }
            if( j >=0){
                right = b.charAt(j) - '0';
            }
            int curr = left + right + carryOver;
            sb.insert(0, curr%10);
            carryOver = curr/10;
            i--;
            j--;
        }
        if(carryOver > 0){
            sb.insert(0,carryOver);
        }
        return sb.toString();
    }
}
