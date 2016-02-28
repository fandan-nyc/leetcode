public class Solution {
    public int singleNumber(int[] nums) {
        int[] record = new int[32];
        for( int i: nums){
            for(int j= 0; j < 32;j++){
                if( (i & (1<<j)) != 0){
                    record[j] = record[j]+ 1;
                }
            }
        }
        int result = 0 ;
        for( int i =0; i < record.length; i++){
                int d = record[i] %3 == 0 ? 0: 1;
                result |= (d)<< i;
        }
        return result;
    }
}
