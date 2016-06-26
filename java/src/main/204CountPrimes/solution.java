public class Solution {
    public int countPrimes(int n) {
        if(n <= 1){
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i*i < n; i++){
            if(isPrime[i]){
                for(int j = i*i; j < n; j+= i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            count += isPrime[i] ? 1:0;
        }
        return count;
    }
}
