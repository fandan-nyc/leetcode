public class Solution {
   public int findLonelyPixel(char[][] picture) {
    int n = picture.length, m = picture[0].length;
    
    int firstRowCount = 0;
    for (int i=0;i<n;i++) 
        for (int j=0;j<m;j++) 
            if (picture[i][j] == 'B') {   
                if (picture[0][j] < 'Y' && picture[0][j] != 'V') picture[0][j]++;
                if (i == 0) firstRowCount++;
                else if (picture[i][0] < 'Y' && picture[i][0] != 'V') picture[i][0]++;
            }

    int count = 0;
    for (int i=0;i<n;i++) 
        for (int j=0;j<m;j++) 
            if (picture[i][j] < 'W' && (picture[0][j] == 'C' || picture[0][j] == 'X')) { 
                if (i == 0) count += firstRowCount == 1 ? 1 : 0;
                else if (picture[i][0] == 'C' || picture[i][0] == 'X') count++;
            }
                
    return count;
}
}
