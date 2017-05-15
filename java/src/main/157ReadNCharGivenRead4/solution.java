/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int read = 0;
        char[] readBuf = new char[4];
        
        while(read < n){
            int tmp = read4(readBuf);
            if(tmp == 0){
                break;
            }
            int i = 0;
            while(i < tmp && read < n){
                buf[read] = readBuf[i];
                i++;
                read++;
            }
        }
        return read;
    }
}
