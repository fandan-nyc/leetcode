public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0 || n > flowerbed.length/2+1){
            return false;
        }
        for(int i = 0; i < flowerbed.length; i++){
            if(canPlot(flowerbed, i)){
                flowerbed[i] = 1;
                n--;
                if(n <= 0){
                    return true;
                }
            }
        }
        return n == 0;
        
    }
    
    private boolean canPlot(int [] flowerbed, int i){
        if(flowerbed[i] == 1){
            return false;
        }
        return (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0);
    }
}
