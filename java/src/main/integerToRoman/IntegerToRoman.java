public class Solution {
    public String intToRoman(int num) {
        String [] template = new String[]{"I","V","X","L","C","D","M"};
        int startP = 4; 
        int startV = 100;
        String result = "";
        while(num > 0)
        {
            if(num >= startV*10)
            {
                while(num >=  startV* 10)
                {
                    result += template[startP+2];
                    num -= startV*10;
                }
            }
            int tmp = num /(startV) ;
            if(tmp > 0)
            {
                result += oneDigit(tmp, template[startP], template[startP+1], template[startP+2]);
                num %= startV;
            }
            startP -= 2;
            startV = startV/ 10;
        }
        return result ;
    }
    
    private String oneDigit(int num, String one, String five, String ten)
    {
        if(num == 9)
        {
            return one + ten;
        }
        else if(num >= 5)
        {
            int count = num - 5;
            String result =  five;
            while(count-- > 0)
            {
                result += one;
            }
            return result;
        }
        else if(num == 4)
        {
            return  one + five ; 
        }
        else if(num >= 1)
        {
            String result = "";
            while(num > 0)
            {
                result += one;
                num --;
            }
            return result;
        }
        else
        {
            return "";
        }
    }
}

