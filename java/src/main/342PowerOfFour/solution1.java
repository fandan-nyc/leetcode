public class Solution {
    public boolean isPowerOfFour(int num) {
      // idea is that, it should be power of 2 and the 1 should be at odd position
      return (num > 0) && ( (num & (num-1)) == 0) && ( (num & 0x55555555) != 0);
    }
}
