public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0; 
        int cows = 0;
        int[] mem = new int[10];
        for(int i = 0; i < secret.length(); i++){
            char a = secret.charAt(i); 
            char b = guess.charAt(i);
            if(a == b){
                bulls ++;
                continue;
            }
            if(mem[a-'0'] < 0){
                cows ++;
            }
            if(mem[b-'0'] > 0){
                cows ++;
            }
            mem[a - '0'] += 1;
            mem[b - '0'] -= 1;
        }
        return String.format("%dA%dB",bulls,cows);
    }
}
