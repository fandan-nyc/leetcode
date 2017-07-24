public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int total = 0;
         for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B' && row[i] == 1 && col[j] ==1){
                    total ++;
                }   
            }
        }
        return total;
    }
}
