public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        int i = 1;
        int tmp;
        while(i <= num){
            tmp = i & (i-1);
            result[i] = result[tmp] +1;
            i++;
        }
        return result;
    }
}
// another solution
public class Solution {
    public int[] countBits(int num) {
        int[] output = new int[num+1];
        for(int i = 0; i <= num ; i ++){
            output[i] = countOne(i);
        }
        return output;
    }
    
    private int countOne(int num){
        int count = 0; 
        for(int i = 0; i < 32; i ++){
            count += (num & (1 << i)) == 0 ? 0 :1;
        }
        return count;
    }
}

