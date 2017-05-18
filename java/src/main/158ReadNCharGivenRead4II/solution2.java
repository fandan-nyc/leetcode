/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    private int remain = 0;
    private int count = 0;
    private char[] readBuff = new char[4];
    
    public int read(char[] buf, int n) {
        int total = 0; 
        while(total < n){
            if(remain == 0){
                remain = read4(readBuff);
                count = 0;
            }
            if(remain == 0){
                break;
            }
            while(total < n && remain > 0){
                buf[total++] = readBuff[count++];
                remain --;
            }
        }
        return total;
    }
}
