public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int h = 0; h < 12;h++){
            for(int m= 0 ; m < 60; m++){
                int time = h*64+m;
                if(countBits(time) == num){
                    res.add(getTimeStr(h,m));
                }
            }
        }
        return res;
    }
    
    private String getTimeStr(int h, int m){
        return h+":"+ ((m < 10) ? "0": "") + m;
    }
    
    private int countBits(int time){
        int total = 0; 
        while(time > 0){
            total ++;
            time = time & (time-1);
        }
        return total;
    }
}
