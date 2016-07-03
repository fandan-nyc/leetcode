// http://www.bo-song.com/leetcode-valid-number/
public class Solution {
    public boolean isNumber(String s) {
        int[][] automaton = {{ 0, 1, 3, 2,-1,-1},
                             {-1,-1, 3, 2,-1,-1},
                             { 8,-1, 4, 2, 5,-1},
                             {-1,-1,-1, 4,-1,-1},
                             { 8,-1,-1, 4, 5,-1},
                             {-1, 6,-1, 7,-1,-1},
                             {-1,-1,-1, 7,-1,-1},
                             { 8,-1,-1, 7,-1,-1},
                             { 8,-1,-1,-1,-1,-1}};
        int state = 0;
        for(char i: s.toCharArray()){
            state = automaton[state][convertCharToCode(i)];
            if(state == -1){
                return false;
            }
        }
        return state == 2 || state == 4 || state == 7 || state == 8;
    }

    private int convertCharToCode(char x){
        if(x == ' '){
            return 0;
        }
        else if(x == '+' || x == '-'){
            return 1;
        }else if(x == '.'){
            return 2;
        }
        else if( x >= '0' && x <= '9'){
            return 3;
        }
        else if( x  ==  'e' || x  =='E'){
            return 4;
        }
        return 5;
    }
}
