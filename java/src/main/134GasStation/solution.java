class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total  = 0; 
        int tmp = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            tmp += gas[i] - cost[i];
            if(tmp < 0){
                start = i+1;
                tmp = 0;
            }
        }
        return total < 0 ? -1: start;
    }
}
