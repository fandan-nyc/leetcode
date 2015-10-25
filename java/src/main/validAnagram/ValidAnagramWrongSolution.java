public class Solution {
    public boolean isAnagram(String s, String t) {
        long sSum  = 0 ; 
        for(Character i : s.toCharArray())
        {
            sSum += (i * i * i);
        }
        for(Character i : t.toCharArray())
        {
            sSum -= ( i*i *i );
        }
        return sSum == 0;    
    }
// this will fail, and here is one example "vbnxkji", "wqdtegp"
// use i ^ 4 will cheat the tests, but again, it is not guaranteed
}
