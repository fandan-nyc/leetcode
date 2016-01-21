public class Solution {
    public int addDigits(int num) {
        if(num < 10)
            return num;
       int tmp = 0;
        while(num > 0){
            tmp = tmp  + num %10; 
            num /= 10;
        }
        return addDigits(tmp);
    }
}
