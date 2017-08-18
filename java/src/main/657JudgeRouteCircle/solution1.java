class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(char i : moves.toCharArray()){
            if(i == 'U'){
                y++;
            }else if(i == 'D'){
                y--;
            }else if(i == 'L'){
                x--;
            }else{
                x++;
            }
        }
        return x == 0  && y == 0;
    }
    
}
