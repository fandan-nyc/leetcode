class Solution {
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;
        boolean[][] blackVisited = new boolean[row][col];
        boolean[][] whiteVisited = new boolean[row][col];
        return count(image, blackVisited, whiteVisited, x , y);
    }
    
    private int count(char[][] image, boolean[][] blackVisited, boolean[][] whiteVisited, int x, int y){
        if(blackVisited[x][y]){
            return 0;
        }
        int count = 0;
        if(x > 0){
            if(image[x-1][y] == 0 && whiteVisited[x-1][y] == false){
                whiteVisited[x-1][y] = true;
                count ++;
            }else if(image[x-1][y] == 1){
                count += count(image, blackVisited, whiteVisited, x-1, y);
            }
        }
         if(x < image.length-1){
            if(image[x+1][y] == 0 && whiteVisited[x+1][y] == false){
                whiteVisited[x+1][y] = true;
                count ++;
            }else if(image[x+1][y] == 1){
                count += count(image, blackVisited, whiteVisited, x+1, y);
            }
        }
        if(y > 0){
            if(image[x][y-1] == 0 && whiteVisited[x][y-1] == false){
                whiteVisited[x][y-1] = true;
                count ++;
            }else if(image[x][y-1] == 1){
                count += count(image, blackVisited, whiteVisited, x, y-1);
            }
        }
        if(y < image[0].length -1){
            if(image[x][y+1] == 0 && whiteVisited[x][y+1] == false){
                whiteVisited[x][y+1] = true;
                count ++;
            }else if(image[x][y+1] == 1){
                count += count(image, blackVisited, whiteVisited, x, y+1);
            }
        }
        return count;
    }
}
