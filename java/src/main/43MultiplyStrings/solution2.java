public class Solution {
    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length() + num2.length()];
        for(int i = num2.length()-1; i >= 0; i--){
            for(int j = num1.length()-1; j >= 0; j--){
                int multi = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                int total = multi + nums[i+j+1];
                nums[i+j+1] = total % 10;
                nums[i+j] += total/10;
            }
        }
        StringBuilder sb =  new StringBuilder();
        for(int i: nums){
            if(!(sb.length() == 0 && i == 0)){
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0": sb.toString();
    }
}
