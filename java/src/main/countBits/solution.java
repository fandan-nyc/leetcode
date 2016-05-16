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

