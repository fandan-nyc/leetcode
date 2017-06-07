public class Solution {
    public int arrayPairSum(int[] nums) {
// use the condition that, the number is between -10000 and 10000
// the total number should never be more than 20000
// we do not sort, but since the numbers are all int, we kind of sort the data
// 1,1,1,2,2,2 in this case, we choose 1 twice and 2 once 
// 1,1,2,2,2,2 in this case, we choose 1 once and 2 twice
// the odd/even number of occurance affects the result
        int[] data = new int[20001];
        int base = 10000;
        for(int i: nums){
            data[i+base] ++;
        }
        int result = 0;
        boolean oddOccur = false;
        for(int i = 0; i < 20001 ; i++){
            if(data[i] > 0){
                int count = oddOccur ? data[i] -1: data[i]; 
                result +=   (count/2+ (count%2 == 0 ? 0:1))  * (i - base);
                oddOccur = count %2 != 0;
            }
        }
        return result;
        
    }
}
