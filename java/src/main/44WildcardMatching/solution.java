public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int pPoint = 0;
        int sPoint = 0;
        int starPoint =-1;
        int sMatch = 0;
        while(sPoint < s.length()){
            // there is no star, then we should match char by char
            if(pPoint < p.length() && (p.charAt(pPoint) == '?' || s.charAt(sPoint) == p.charAt(pPoint))){
                pPoint ++;
                sPoint ++;
            }else if( pPoint < p.length() && p.charAt(pPoint) == '*'){
                //if there is start, we mark the start position and pos in s
                // compare pPoint +1 and sPoint;
                starPoint = pPoint;
                sMatch = sPoint;
                pPoint++;
            }else if(starPoint != -1){
                // if there is a start already and there is mismatch between pPoint and sPoint
                // we use the * to match the sPoint
                // bring back the point to startPoint+1 for pPoint 
                // sMatch ++
                pPoint = starPoint+1;
                sPoint = sMatch+1;
                sMatch ++;
            }else{
                return false;
            }
        }
        while(pPoint < p.length()){
            if(p.charAt(pPoint) != '*'){
                return false;
            }
            pPoint++;
        }
        return true;
    }
}
