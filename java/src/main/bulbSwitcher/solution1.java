public class Solution {
    public int bulbSwitch(int n) {
        int counter  = 1;
        int total  = 0;
        while(counter <= n){
            if(counter %2 == 1){
                total += n / counter;
            }
            else{
                total -= n/counter;
            }
            counter ++;
        }
        return total;
    }
}
