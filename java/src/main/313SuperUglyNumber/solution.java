public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0 || primes == null || primes.length == 0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        List<Integer> result = new ArrayList<Integer>();
        int[] pointer = new int[primes.length];
        result.add(1);
        int curr =1;
        while(result.size() < n){
            for(int i = 0; i < primes.length; i++){
                while(result.get(pointer[i]) * primes[i] <= curr){
                    pointer[i]++;
                }
            }
            curr = result.get(pointer[0])* primes[0];
            for(int i = 1; i < primes.length; i++){
                curr =  Math.min(curr, (result.get(pointer[i])* primes[i]));
            }
            result.add(curr);
        }
        return result.get(n-1);
    }
}
