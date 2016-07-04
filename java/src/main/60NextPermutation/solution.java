public class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used =  new boolean[n+1];
        if(n <= 0){
            return "";
        }
        k = k-1;
        int count = 0;
        String result = "";
        int totalNum = n;
        while(count < n){
            int digit = getNthUnusedNum(k/factorial(totalNum-1), used);
            result = result + digit;
            k = k%factorial(totalNum-1);
            count ++;
            totalNum--;
        }
        return result;
    }
    
    private int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return factorial(n-1) * n;
    }
    
    private int getNthUnusedNum(int n, boolean[] used){
        int count = -1;
        for(int i = 1; i < used.length; i++){
            if(used[i] == false){
                count +=1; 
                if(count == n){
                    used[i] = true;
                    return i;
                }
            }
        }
        // we should not reach here. 
        return -1;
    }
}
