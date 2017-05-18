/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    private  int buffPointer = 4;
    private  char[] readBuff = new char[4];
    private  int readIn = 0;
    
    public int read(char[] buf, int n) {
        int buffCount  = 0;
        while(buffCount < n){
            while(buffPointer < readIn && buffCount < n){
                buf[buffCount++] = readBuff[buffPointer++];
            }
            if(buffCount >= n){
                break;
            }
            readIn = read4(readBuff);
            if(readIn == 0){
                break;
            }
            buffPointer = 0;
        }
        return buffCount;
    }
}
