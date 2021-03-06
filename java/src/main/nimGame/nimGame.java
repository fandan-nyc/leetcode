public class Solution {
    public boolean canWinNim(int n) {
        if(n <= 0)
        {
            throw new IllegalArgumentException(String.format("cannot have a game with %d stones", n));
        }
        return n % 4  != 0; 
    }
}
