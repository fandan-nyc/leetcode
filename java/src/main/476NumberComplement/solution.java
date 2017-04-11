public class Solution {
    public int findComplement(int num) {
        num = ~ num; 
        for(int i = 31; i >= 0; i--){
            if( (num & (1 << i)) != 0){
                num ^= ( 1 << i);
            }
            else{
                break;
            }
        }
        return num;
    }
}
