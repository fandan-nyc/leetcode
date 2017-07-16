public class Solution {
    public boolean validUtf8(int[] data) {
       if(data == null || data.length == 0){
           return false;
       }
        int bitCount = 0 ;
        for(int i: data){
            if(i >= 192){
                if(i >= 248 || bitCount  != 0){
                    return false;
                }else if( i >= 240){
                    bitCount = 3;
                }else if( i >= 224){
                    bitCount = 2;
                }else{
                    bitCount = 1;
                }
            }
            else if(i >= 128){
                    bitCount --;
                    if(bitCount < 0){
                        return false;
                    }
            }else{
                if(bitCount > 0){
                    return false;
                }
            }
        }
        return bitCount == 0;
    }
}
